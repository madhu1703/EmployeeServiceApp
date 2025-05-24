package com.bridgelabz.EmployeePayrollApp.service;
import com.bridgelabz.EmployeePayrollApp.entity.EmployeePayrollData;
import java.util.List;

public interface IEmployeeService {
    List<EmployeePayrollData> getAllEmployees();
    EmployeePayrollData getEmployeeById(int id);
    void deleteEmployee(int id);
}