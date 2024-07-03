package com.employee.service;

import com.employee.dao.EmployeeDAO;
import com.employee.dao.EmployeeDAOImpl;
import com.employee.dto.EmployeeDTO;
import com.employee.entity.EmployeeEntity;
import com.employee.exception.CustomException;
import com.employee.utils.FactoryUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the EmployeeService interface and provides the business logic for employee operations.
 *
 * @author Naveed
 */
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO = FactoryUtils.getEmployeeDAO();

    @Override
    public void addEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = FactoryUtils.convertDTOToEntity(employeeDTO);
        employeeDAO.addEmployee(employeeEntity);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeDAO.getAllEmployees();
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeEntities) {
            employeeDTOs.add(FactoryUtils.convertEntityToDTO(employeeEntity));
        }
        return employeeDTOs;
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) {
        EmployeeEntity employeeEntity = employeeDAO.getEmployeeById(id);
        if (employeeEntity != null) {
            return FactoryUtils.convertEntityToDTO(employeeEntity);
        } else {
            throw new CustomException("Employee not found with id: " + id);
        }
    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = FactoryUtils.convertDTOToEntity(employeeDTO);
        employeeDAO.updateEmployee(employeeEntity);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }

}
