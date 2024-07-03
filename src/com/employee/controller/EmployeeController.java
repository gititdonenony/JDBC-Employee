package com.employee.controller;

import com.employee.dto.EmployeeDTO;
import com.employee.service.EmployeeService;
import com.employee.service.EmployeeServiceImpl;
import com.employee.utils.FactoryUtils;

import java.util.List;

/**
 * This class is responsible for handling all operations related to Employee.
 * It interacts with the EmployeeService to perform CRUD operations.
 *
 * @author Naveed
 */

public class EmployeeController {
    private EmployeeService employeeService = FactoryUtils.getEmployeeService();

    public void addEmployee(EmployeeDTO employeeDTO) {
        employeeService.addEmployee(employeeDTO);
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    public EmployeeDTO getEmployeeById(int id) {
        return employeeService.getEmployeeById(id);
    }

    public void updateEmployee(EmployeeDTO employeeDTO) {
        employeeService.updateEmployee(employeeDTO);
    }

    public void deleteEmployee(int id) {
        employeeService.deleteEmployee(id);
    }

}

