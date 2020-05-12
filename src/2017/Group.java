public class Group {
    private int guestCount;
    private Table table;
    /**
     * Initializes this Group with the provided guest count
     */
    public Group(int guestCount) {
       this.guestCount = guestCount;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public void setGuestCount(int guestCount) {
        if (table != null){
            Seating.checkCapacity(this, table);
        }
        this.guestCount = guestCount;
    }
}