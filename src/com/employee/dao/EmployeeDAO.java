package com.employee.dao;

import com.employee.entity.EmployeeEntity;

import java.util.List;

/**
 * This interface defines the methods for interacting with the Employee database.
 * It provides methods for adding, retrieving, updating, and deleting employee records.
 *
 * @author Naveed
 */
public interface EmployeeDAO {
    public void addEmployee(EmployeeEntity employeeEntity);

    public List<EmployeeEntity> getAllEmployees();

    public EmployeeEntity getEmployeeById(int id);

    public void updateEmployee(EmployeeEntity employeeEntity);

    public void deleteEmployee(int id);

}
