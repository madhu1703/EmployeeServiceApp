package com.bridgelabz.EmployeePayrollApp.service;
import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
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
    public EmployeePayrollData createEmployee(EmployeeDTO dto) {
        EmployeePayrollData emp = new EmployeePayrollData(0, dto.getName(), dto.getSalary());
        return repository.save(emp);
    }
    public EmployeePayrollData updateEmployee(int id, EmployeeDTO dto) {
        EmployeePayrollData existing = getEmployeeById(id);
        existing.setName(dto.getName());
        existing.setSalary(dto.getSalary());
        return repository.save(existing);
    }


    @Override
    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }
}