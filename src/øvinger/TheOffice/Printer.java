package øvinger.TheOffice;

import java.util.*;

public class Printer {
    Map<Employee, ArrayList<String>> history = new HashMap<Employee, ArrayList<String>>();

    public void printDocument(String document, Employee employee) {
        System.out.println(document);
        ArrayList<String> employeeHistory = history.getOrDefault(employee, new ArrayList<>());
        employeeHistory.add(document);
        history.put(employee, employeeHistory);
    }

    public List<String> getPrintHistory(Employee employee) {
        return history.getOrDefault(employee, new ArrayList<String>());
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        Clerk clerk = new Clerk(printer);
        System.out.println(printer.getPrintHistory(clerk));
        clerk.printDocument("yessir");
        System.out.println(printer.getPrintHistory(clerk));
    }

}
