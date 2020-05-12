public class Seating {
    private Group group;
    private Table table;

    /**
     * Initializes this Seating ...
     */
    public Seating(Group group, Table table) {
        checkCapacity(group, table);
        this.group = group;
        group.setTable(table);
        this.table = table;
    }

    public static void checkCapacity(Group group, Table table) {
        if (group.getGuestCount() > table.getCapacity()) {
           throw new IllegalArgumentException("That group is too big to that table");
        }
    }

    public Group getGroup() {
        return group;
    }

    public Table getTable() {
        return table;
    }
}