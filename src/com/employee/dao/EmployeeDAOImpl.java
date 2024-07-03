package com.employee.dao;

import com.employee.entity.EmployeeEntity;
import com.employee.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the EmployeeDAO interface and provides methods for interacting with the
 * Employee table in the database.
 *
 * @author Naveed
 */
public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    //Adds a new employee to the database
    public void addEmployee(EmployeeEntity employeeEntity) {
        // Insert a new employee into the 'emp' table in the database using SQL INSERT statement
        String sql = "INSERT INTO emp(name, email, designation,salary,date_of_joining) VALUES(?,?,?,?,?)";
        try {
            Connection conn = JDBCUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, employeeEntity.getName());
            ps.setString(2, employeeEntity.getEmail());
            ps.setString(3, employeeEntity.getDesignation());
            ps.setInt(4, employeeEntity.getSalary());
            ps.setDate(5, new java.sql.Date(employeeEntity.getDateOfJoin().getTime()));
            ps.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    //Retrieves all employees from the database
    public List<EmployeeEntity> getAllEmployees() {
        // Retrieve all employees from the 'emp' table in the database using SQL SELECT statement
        String sql = "SELECT * FROM emp";
        List<EmployeeEntity> employeeEntities = new ArrayList<>();
        try {
            Connection conn = JDBCUtils.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                EmployeeEntity employeeEntity = new EmployeeEntity();
                employeeEntity.setId(resultSet.getInt("id"));
                employeeEntity.setName(resultSet.getString("name"));
                employeeEntity.setEmail(resultSet.getString("email"));
                employeeEntity.setDesignation(resultSet.getString("designation"));
                employeeEntity.setSalary(resultSet.getInt("salary"));
                employeeEntity.setDateOfJoin(resultSet.getDate("date_of_joining"));
                employeeEntities.add(employeeEntity);
            }
            JDBCUtils.closeResultSet(resultSet);
            JDBCUtils.closeStatement(statement);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return employeeEntities;
    }

    @Override
    //Retrieves an employee by their ID from the database
    public EmployeeEntity getEmployeeById(int id) {
        // Retrieve an employee by their ID from the 'emp' table in the database using SQL SELECT statement
        String sql = "SELECT * FROM emp WHERE id = ?";
        try {
            Connection conn = JDBCUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                EmployeeEntity employeeEntity = new EmployeeEntity();
                employeeEntity.setId(resultSet.getInt("id"));
                employeeEntity.setName(resultSet.getString("name"));
                employeeEntity.setEmail(resultSet.getString("email"));
                employeeEntity.setDesignation(resultSet.getString("designation"));
                employeeEntity.setSalary(resultSet.getInt("salary"));
                employeeEntity.setDateOfJoin(resultSet.getDate("date_of_joining"));
                return employeeEntity;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    //Updates an employee's information in the database'
    public void updateEmployee(EmployeeEntity employeeEntity) {
        // Update an employee's information in the 'emp' table in the database using SQL UPDATE statement'
        String sql = "UPDATE emp SET name = ?, email = ?, designation = ?, salary = ?, date_of_joining = ? WHERE id = ?";
        try {
            Connection conn = JDBCUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, employeeEntity.getName());
            ps.setString(2, employeeEntity.getEmail());
            ps.setString(3, employeeEntity.getDesignation());
            ps.setInt(4, employeeEntity.getSalary());
            ps.setDate(5, new java.sql.Date(employeeEntity.getDateOfJoin().getTime()));
            ps.setInt(6, employeeEntity.getId());
            ps.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    // Deletes an employee from the database by their ID
    public void deleteEmployee(int id) {
        // Delete an employee from the 'emp' table in the database using SQL DELETE statement''
        String sql = "DELETE FROM emp WHERE id = ?";
        try {
            Connection conn = JDBCUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
