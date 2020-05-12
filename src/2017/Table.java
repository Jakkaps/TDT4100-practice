public abstract class Table{
    private static int currentNumber = 1;
    private int number;

    public Table() {
        this.number = currentNumber;
        currentNumber++;
    }

    public int getNumber() {
        return number;
    }

    public abstract int getCapacity();
}
