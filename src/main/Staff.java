package org.employee;

public interface Staff {
    int salary = 0;

    boolean creditSalary(int salary);

    void showSalary();

    boolean setPerformance(String performance);

    void viewPerformance();

    boolean setEmployeeRole(String role);

    void showEmployeeRole();
}
