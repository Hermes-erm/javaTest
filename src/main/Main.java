package org.employee;

import java.util.ArrayList;
import java.util.Scanner;

class Employee implements Staff {
    String name = "";
    int salary = 0;
    String performance = "Not updated";
    String role = "Not yet decided";

    public boolean creditSalary(int salary) {
        this.salary = salary;
        return true;
    }

    public void showSalary() {
        System.out.printf("Here's your salary mister/misses : %d\n", this.salary);
    }

    public boolean setPerformance(String performance) {
        this.performance = performance;
        return false;
    }

    public void viewPerformance() {
        System.out.printf("Your performance is quite.. %s\n", this.performance);
    }

    public boolean setEmployeeRole(String role) {
        this.role = role;
        return false;
    }

    public void showEmployeeRole() {
        System.out.printf("Here's your role - %s\n", this.role);
    }
}

public class Main {
    static Scanner in = new Scanner(System.in);
    static ArrayList<Employee> empObjs = new ArrayList<>();

    public static void main(String[] args) {
        // "label" to access it over anywhere.
        // loop:
        while (true) {
            System.out.println("------- Proceed actions :  -------");
            System.out.print("1 add new Employee\n");
            System.out.print("2 select employee\n");
            System.out.print("3 list of employees\n");
            System.out.print("4 Exit\n");

            int opt = in.nextInt();
            switch (opt) {
                case 1:
                    addNewEmployee();
                    break;
                case 2:
                    selectEmployee();
                    break;
                case 3:
                    showEmployeeList();
                    break;
                case 4:
                    System.out.println("------- Exit -------");
                    break loop;
                default:
                    System.out.println("Cases not matched! Try again..");
                    break;
            }
        }
    }

    static public void addNewEmployee() {
        System.out.println("------- Add new employee  -------");

        System.out.print("Enter name (he/she) : ");
        in.nextLine(); // to bypass the line.
        String name = in.nextLine(); // Reads the full name, including spaces

        System.out.printf("Enter role of %s : ", name);
        String role = in.next();

        System.out.println("Add ? yes(1) / no(2) : ");
        int choice = in.nextInt();

        if (choice != 1)
            return;
        Employee emp = new Employee();
        emp.name = name;
        emp.role = role;
        empObjs.add(emp);
        System.out.println("Employee added (\"");
        // over for now...
    }

    static public void selectEmployee() {
        if (empObjs.isEmpty()) {
            System.out.println("Oops! nO employees to list here!");
            return;
        }
        System.out.println("select any one of 'em : ");
        for (int i = 0; i < empObjs.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, empObjs.get(i).name);
        }
        int choice = in.nextInt();
        if (choice <= 0 || choice > empObjs.size()) {
            System.out.println("sry, no employee found for the given index!");
            return;
        }
        System.out.printf("Name: %s\n", empObjs.get(choice - 1).name);
        System.out.printf("Role:  %s\n", empObjs.get(choice - 1).role);
    }

    static public void showEmployeeList() {
        if (empObjs.isEmpty()) {
            System.out.println("Oops! nO employees to list here!");
            return;
        }
        System.out.println("here are the list of employees : ");
        for (int i = 0; i < empObjs.size(); i++) {
            System.out.printf("%d. %s %s\n", i + 1, empObjs.get(i).name, empObjs.get(i).role);
        }
    }

}