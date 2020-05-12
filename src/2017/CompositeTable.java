public class CompositeTable extends Table{
    private Table table1;
    private Table table2;
    private int lostCapacity;

    public CompositeTable(Table table1, Table table2, int lostCapacity) {
        this.table1 = table1;
        this.table2 = table2;
        this.lostCapacity = lostCapacity;
    }

    @Override
    public int getCapacity() {
        return table1.getCapacity() + table2.getCapacity() - lostCapacity;
    }

    public Table getTable1() {
        return table1;
    }

    public Table getTable2() {
        return table2;
    }
}
