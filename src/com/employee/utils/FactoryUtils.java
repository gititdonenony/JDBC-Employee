package com.employee.utils;

import com.employee.dao.EmployeeDAO;
import com.employee.dao.EmployeeDAOImpl;
import com.employee.dto.EmployeeDTO;
import com.employee.entity.EmployeeEntity;
import com.employee.service.EmployeeService;
import com.employee.service.EmployeeServiceImpl;

import java.sql.Date;

public class FactoryUtils {
    public static EmployeeDAO getEmployeeDAO() {
        return new EmployeeDAOImpl();
    }

    public static EmployeeService getEmployeeService() {
        return new EmployeeServiceImpl();
    }

    public static EmployeeEntity convertDTOToEntity(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employeeDTO.getId());
        employeeEntity.setName(employeeDTO.getName());
        employeeEntity.setEmail(employeeDTO.getEmail());
        employeeEntity.setDesignation(employeeDTO.getDesignation());
        employeeEntity.setSalary(employeeDTO.getSalary());
        if (employeeDTO.getDateOfJoin() != null) {
            Date date = new Date(employeeDTO.getDateOfJoin().getTime());
            employeeEntity.setDateOfJoin(date);
        }
        return employeeEntity;
    }

    public static EmployeeDTO convertEntityToDTO(EmployeeEntity employeeEntity) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        if (employeeEntity != null) {
            employeeDTO.setId(employeeEntity.getId());
            employeeDTO.setName(employeeEntity.getName());
            employeeDTO.setEmail(employeeEntity.getEmail());
            employeeDTO.setDesignation(employeeEntity.getDesignation());
            employeeDTO.setSalary(employeeEntity.getSalary());
            employeeDTO.setDateOfJoin(employeeEntity.getDateOfJoin());
        }
        return employeeDTO;
    }

}
