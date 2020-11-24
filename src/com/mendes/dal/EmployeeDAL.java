package com.mendes.dal;

import com.mendes.dbConnection.DbConnection;
import com.mendes.entity.Employee;
import com.mendes.enums.EmployeesColumn;
import com.mendes.utility.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mendesmustafa on 24.11.2020.
 */

public class EmployeeDAL {

    private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM EMPLOYEES";
    private static final String SELECT_SALARY_INTERVAL = "SELECT * FROM EMPLOYEES WHERE SALARY >= ? AND SALARY <= ? BY ORDER SALARY DESC";

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public EmployeeDAL() {
        connection = DbConnection.connectionPostgresql();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            Util.processSQLException(e);
        }
    }

    public List<Employee> listAllEmployees() {

        List<Employee> employeeList = new ArrayList<Employee>();
        try {
            resultSet = statement.executeQuery(SELECT_ALL_EMPLOYEES);
            while (resultSet.next()) {
                employeeList.add(createEntity(resultSet));
            }
        } catch (SQLException e) {
            Util.processSQLException(e);
        }
        return employeeList;
    }

    public List<Employee> listSalaryInterval(double limitLower, double limitUp) {

        List<Employee> employeeList = new ArrayList<Employee>();
        try {
            preparedStatement = connection.prepareStatement(SELECT_SALARY_INTERVAL);
            preparedStatement.setDouble(1, limitLower);
            preparedStatement.setDouble(2, limitUp);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employeeList.add(createEntity(resultSet));
            }
        } catch (SQLException e) {
            Util.processSQLException(e);
        }
        return employeeList;
    }

    private Employee createEntity(ResultSet resultSet) {
        try {
            int employeeId = resultSet.getInt(EmployeesColumn.EMPLOYEE_ID.toString());
            String firstName = resultSet.getString(EmployeesColumn.FIRST_NAME.toString());
            String lastName = resultSet.getString(EmployeesColumn.LAST_NAME.toString());
            double salary = resultSet.getDouble(EmployeesColumn.SALARY.toString());
            Date startJobDate = resultSet.getDate(EmployeesColumn.HIRE_DATE.toString());

            return new Employee(employeeId, firstName, lastName, salary, startJobDate);
        } catch (SQLException e) {
            Util.processSQLException(e);
            return null;
        }
    }
}