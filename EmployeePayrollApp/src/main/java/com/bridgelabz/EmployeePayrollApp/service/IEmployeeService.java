package com.bridgelabz.EmployeePayrollApp.service;
import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApp.entity.EmployeePayrollData;
import java.util.List;

public interface IEmployeeService {
    EmployeePayrollData createEmployee(EmployeeDTO employeeDTO);
    EmployeePayrollData updateEmployee(int id, EmployeeDTO employeeDTO);

    List<EmployeePayrollData> getAllEmployees();
    EmployeePayrollData getEmployeeById(int id);
    void deleteEmployee(int id);
}