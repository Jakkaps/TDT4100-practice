public class SimpleTable extends Table{
    private int capacity;

    public SimpleTable(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }
}
