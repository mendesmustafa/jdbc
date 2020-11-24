package com.mendes;

import com.mendes.dal.EmployeeDAL;
import com.mendes.entity.Employee;

import javax.swing.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees;
        EmployeeDAL employeeDAL = new EmployeeDAL();

        employees = employeeDAL.listAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        String strLowerLimit = JOptionPane.showInputDialog("Maas alt limiti giriniz:");
        String strUpLimit = JOptionPane.showInputDialog("Maas üst limiti giriniz:");

        employees = employeeDAL.listSalaryInterval(Integer.parseInt(strLowerLimit), Integer.parseInt(strLowerLimit));
        System.out.println("\n\n" + strLowerLimit + " ve " + strUpLimit + " aralığındaki çalışan listesi:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}