import java.util.*;
import java.util.stream.Collectors;

/**
 * A place where groups of guests can buy a meal
 */
public class Diner implements ObservableCapacity{
    private Collection<Table> tables;
    private Collection<Seating> seatings = new ArrayList<>();
    private Collection<CapacityListener> listeners = new ArrayList<>();

    public Diner(Table... tables) {
        this.tables = Arrays.asList(tables);
    }

    public Diner(Collection<Seating> seatings, Table... tables) {
        this(tables);
        this.seatings = seatings;
    }

    /**
     * Tells whether a Table is occupied.
     * @param table the Table to check
     * @return true if anyone is sitting at the provided Table
     */
    public boolean isOccupied(Table table) {
        return seatings.stream().anyMatch(seating -> seating.getTable() == table);
    }

    /**
     * Computes the guest capacity,
     * either the remaining (includeOccupied == false) or total (includeOccupied == true).
     * @param includeOccupied controls whether to include tables that are occupied.
     * @return the guest capacity
     */
    public int getCapacity(boolean includeOccupied) {
        return tables.stream().filter(t -> !isOccupied(t) || includeOccupied).mapToInt(Table::getCapacity).sum();
    }

    /**
     * Adds a table to this Diner
     * @param table
     */
    public void addTable(Table table) {
        if (!this.tables.contains(table)){
           tables.add(table);
           notifyListeners();
        }
    }

    /**
     * Removes a Table from this Diner.
     * If the table is occupied an IllegalArgumentException exception should be thrown.
     * @param table
     * @throws IllegalArgumentException
     */
    public void removeTable(Table table) {
        checkNotOccupied(table, "Can't remove an occupied table");
        tables.remove(table);
        notifyListeners();
    }

    private void checkNotOccupied(Table table, String message) {
        if (isOccupied(table)) {
            throw new IllegalArgumentException("Someone's sitting at that table");
        }
    }

    /**
     * Merges two tables, i.e. replaces two tables with one table.
     * lostCapacity is the difference between the old capacity and the new.
     * This number is typically positive, since seats are lost when moving two tables
     * close to each other.
     * @param table1
     * @param table2
     * @param lostCapacity
     * @throws IllegalArgumentException if any of the tables are occupied
     */
    public void mergeTables(Table table1, Table table2, int lostCapacity) {
        checkNotOccupied(table1,"Can't merge an occupied table");
        checkNotOccupied(table2,"Can't merge an occupied table");

        addTable(new CompositeTable(table1, table2, lostCapacity));
        removeTable(table1);
        removeTable(table2);
        notifyListeners();
    }

    /**
     * Splits a table into two, i.e. replaces one tables with two tables.
     * The two capacities are the capacities of the two new tables.
     * @param table
     * @param capacity1
     * @param capacity2
     * @throws IllegalArgumentException if the table is occupied
     */
    public void splitTable(CompositeTable table) {
        checkNotOccupied(table, "Can't split an occupied table");

        removeTable(table);
        addTable(table.getTable1());
        addTable(table.getTable2());
        notifyListeners();
    }

    /**
     * Tells whether a table has the provided capacity,
     * i.e. if that number of new guests can be seated there.
     * Note that a table cannot be shared among different groups.
     * @param table
     * @param capacity
     * @return true of capacity number of guests can be seated here, false otherwise.
     */
    public boolean hasCapacity(Table table, int capacity) {
        return table.getCapacity() >= capacity && !isOccupied(table);
    }

    /**
     * Returns the tables that has the provided capacity.
     * The tables should be sorted with the one with the least capacity (but enough) first.
     * @param capacity
     * @return the tables that has the provided capacity
     */
    public Collection<Table> findAvailableTables(int capacity) {
       return tables.stream().filter(t -> hasCapacity(t, capacity)).sorted(Comparator.comparing(Table::getCapacity)).collect(Collectors.toList());
    }

    /**
     * Finds a suitable, existing table for the provided group, and creates
     * (but doesn't add) a corresponding Seating.
     * The chosen table should be the one with the least capacity.
     * @param group the group to be seated
     * @return the newly created Seating
     */
    public Seating createSeating(Group group) {
        Collection<Table> tables = findAvailableTables(group.getGuestCount());
        return tables.isEmpty() ? null : new Seating(group, tables.iterator().next());
    }

    /**
     * Creates and adds a Seating for the provided group, using the createSeating method.
     * @param group
     * @return true if a Seating was created and added, false otherwise.
     */
    public boolean addSeating(Group group) {
        Seating seating = createSeating(group);
        if (seating == null){
            return false;
        }

        seatings.add(seating);
        notifyListeners();
        return true;
    }

    /**
     * Removes the seating for the provided table (number), if one exists
     * @param tableNum the number of the table to be removed
     */
    public void removeSeating(int tableNum) {
        seatings.stream().filter(s -> s.getTable().getNumber() == tableNum).findFirst().ifPresent(seating -> {
            seatings.remove(seating);
            notifyListeners();
        });
    }

    @Override
    public void addListener(CapacityListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    @Override
    public void removeListener(CapacityListener listener){
        listeners.remove(listener);
    }

    private void notifyListeners(){
        listeners.forEach(listener -> listener.capacityChanged(this));
    }
}