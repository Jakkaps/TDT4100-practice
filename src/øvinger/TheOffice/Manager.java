package øvinger.TheOffice;

import java.util.*;
import java.util.function.BinaryOperator;

public class Manager implements Employee{
    private List<Employee> employees;

    public Manager(Collection<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            throw new IllegalArgumentException("A manager is not without employees");
        }

        this.employees = new ArrayList<>(employees);
    }

    private Employee mostLazyEmployee(){
        employees.sort(Comparator.comparing(Employee::getTaskCount));
        System.out.println(employees);
        return employees.get(0);
    }

    @Override
    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
        return mostLazyEmployee().doCalculations(operation, value1, value2);
    }

    @Override
    public void printDocument(String document) {
        mostLazyEmployee().printDocument(document);
    }

    @Override
    public int getTaskCount() {
        return employees.stream().mapToInt(Employee::getTaskCount).sum();
    }

    @Override
    public int getResourceCount() {
        return employees.stream().mapToInt(Employee::getResourceCount).sum();
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        Employee e1 = new Clerk(printer);
        Employee e2 = new Clerk(printer);
        Employee e3 = new Clerk(printer);

        Manager manager = new Manager(List.of(e1, e2, e3));
        System.out.println(manager.getResourceCount());
        System.out.println("Task count: " + manager.getTaskCount());
        manager.printDocument("hei");
        System.out.println(manager.doCalculations(Double::sum, 6, 3));
        System.out.println(manager.getResourceCount());
        System.out.println(manager.getTaskCount());
    }
}
