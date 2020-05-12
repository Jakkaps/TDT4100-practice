package øvinger.TheOffice;

import java.util.function.BinaryOperator;

public class Clerk implements Employee{
    private Printer printer;
    private int taskCount = 0;

    public Clerk(Printer printer) {
        this.printer = printer;
    }

    @Override
    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
        taskCount++;
        return operation.apply(value1, value2);
    }

    @Override
    public void printDocument(String document) {
        taskCount++;
        printer.printDocument(document, this);
    }

    @Override
    public int getTaskCount() {
        return taskCount;
    }

    @Override
    public int getResourceCount() {
        return 1;
    }

    public static void main(String[] args) {
        Clerk clerk = new Clerk(new Printer());
        System.out.println(clerk.doCalculations(Double::sum, 2, 2));
        clerk.printDocument("yebbooii");
        System.out.println(clerk.getTaskCount());
    }

    @Override
    public String toString() {
        return "Clerk{" +
                "taskCount=" + taskCount +
                '}';
    }
}
