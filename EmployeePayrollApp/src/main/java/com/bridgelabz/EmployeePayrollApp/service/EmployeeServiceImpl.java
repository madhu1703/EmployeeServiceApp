package com.bridgelabz.EmployeePayrollApp.service;
import com.bridgelabz.EmployeePayrollApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.EmployeePayrollApp.entity.EmployeePayrollData;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<EmployeePayrollData> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeeById(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }



    @Override
    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }
}