package com.employee.service;

import com.employee.dto.EmployeeDTO;

import java.util.List;

/**
 * This interface defines the methods for Employee Service operations.
 *
 * @author Naveed
 */

public interface EmployeeService {
    public void addEmployee(EmployeeDTO employeeDTO);

    public List<EmployeeDTO> getAllEmployees();

    public EmployeeDTO getEmployeeById(int id);

    public void updateEmployee(EmployeeDTO employeeDTO);

    public void deleteEmployee(int id);

}
