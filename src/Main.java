import com.employee.controller.EmployeeController;
import com.employee.dto.EmployeeDTO;
import com.employee.utils.DateUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents the main application for the Employee Management System.
 * It provides an interface for users to interact with the system.
 *
 * @Author: Naveed
 */
public class Main {
    private static EmployeeController employeeController;

    static {
        //Initialize the EmployeeController instance
        employeeController = new EmployeeController();
    }

    public static void main(String[] args) throws IOException {
        //Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        //BufferedReader object for reading entire lines
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int option = 0;
        //Loop through lines until user chooses to exit
        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. View Employee by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            //Read user input
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    // Adding an employee
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    System.out.println("Enter employee details:");
                    System.out.print("Name: ");
                    employeeDTO.setName(scanner.nextLine());
                    scanner.nextLine();
                    System.out.print("Designation: ");
                    employeeDTO.setDesignation(scanner.nextLine());
                    scanner.nextLine();
                    System.out.print("Email: ");
                    employeeDTO.setEmail(scanner.nextLine());
                    scanner.nextLine();
                    System.out.print("Salary: ");
                    employeeDTO.setSalary(scanner.nextInt());
                    scanner.nextLine();
                    System.out.print("Date of Joining (yyyy-mm-dd): ");
                    // Converting date string to Date object
                    employeeDTO.setDateOfJoin(DateUtils.convertStringToDate(scanner.nextLine()));
                    // Adding employee
                    employeeController.addEmployee(employeeDTO);
                    System.out.println("Employee added successfully!");
                    break;
                case 2:
                    // Retrieving all employees
                    List<EmployeeDTO> employeees = employeeController.getAllEmployees();
                    System.out.println("List of employees");
                    // Print employee details
                    for (EmployeeDTO employee : employeees) {
                        System.out.println("ID: " + employee.getId());
                        System.out.println("Name: " + employee.getName());
                        System.out.println("Designation: " + employee.getDesignation());
                        System.out.println("Email: " + employee.getEmail());
                        System.out.println("Salary: " + employee.getSalary());
                        System.out.println("Date of Joining: " + DateUtils.convertDateToString(employee.getDateOfJoin()));
                        System.out.println("----------------------------------------");
                    }
                    break;
                case 3:
                    // Retrieving employee by ID
                    System.out.println("Enter employee ID to retrieve information");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    if (id != 0) {
                        System.out.println("Invalid ID! Please try again.");
                    } else {
                        // Print employee details
                        EmployeeDTO employee = employeeController.getEmployeeById(id);
                        System.out.println("Information about employee with ID " + id);
                        System.out.println("Name: " + employee.getName());
                        System.out.println("Designation: " + employee.getDesignation());
                        System.out.println("Email: " + employee.getEmail());
                        System.out.println("Salary: " + employee.getSalary());
                        System.out.println("Date of Joining: " + DateUtils.convertDateToString(employee.getDateOfJoin()));
                    }
                    break;
                case 4:
                    // Updating employee information
                    System.out.println("Enter employee ID to update information");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    if (id != 0) {
                        System.out.println("Invalid ID! Please try again.");
                    } else {
                        // Getting updated employee details
                        EmployeeDTO updatedEmployee = new EmployeeDTO();
                        System.out.println("Enter updated details:");
                        System.out.print("Name: ");
                        updatedEmployee.setName(scanner.nextLine());
                        scanner.nextLine();
                        System.out.print("Designation: ");
                        updatedEmployee.setDesignation(scanner.nextLine());
                        scanner.nextLine();
                        System.out.print("Email: ");
                        updatedEmployee.setEmail(scanner.nextLine());
                        scanner.nextLine();
                        System.out.print("Salary: ");
                        updatedEmployee.setSalary(scanner.nextInt());
                        scanner.nextLine();
                        System.out.print("Date of Joining (yyyy-mm-dd): ");
                        // Converting date string to Date object
                        updatedEmployee.setDateOfJoin(DateUtils.convertStringToDate(scanner.nextLine()));
                        EmployeeDTO employeeDTO1 = new EmployeeDTO();
                        employeeDTO1.setId(id);
                        employeeDTO1.setName(updatedEmployee.getName());
                        employeeDTO1.setDesignation(updatedEmployee.getDesignation());
                        employeeDTO1.setEmail(updatedEmployee.getEmail());
                        employeeDTO1.setSalary(updatedEmployee.getSalary());
                        employeeDTO1.setDateOfJoin(updatedEmployee.getDateOfJoin());
                        // Updating employee
                        employeeController.updateEmployee(employeeDTO1);
                        System.out.println("Employee updated successfully!");
                    }
                    break;
                case 5:
                    // Deleting employee
                    System.out.println("Enter employee ID to delete");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    if (id != 0) {
                        System.out.println("Invalid ID! Please try again.");

                    } else {
                        // Deleting employee
                        employeeController.deleteEmployee(id);
                        System.out.println("Employee with ID " + id + " deleted!");
                    }
                    break;
            }
        } while (option != 0);

        scanner.close();
    }


}