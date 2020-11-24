package com.mendes.entity;

import java.util.Date;

/**
 * Created by mendesmustafa on 24.11.2020.
 */

public class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private double salary;
    private Date startJobDate;

    public Employee(int employeeId, String firstName, String lastName, double salary, Date startJobDate) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.startJobDate = startJobDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getStartJobDate() {
        return startJobDate;
    }

    public void setStartJobDate(Date startJobDate) {
        this.startJobDate = startJobDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", startJobDate=" + startJobDate +
                '}';
    }
}