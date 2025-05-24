package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApp.entity.EmployeePayrollData;
import com.bridgelabz.EmployeePayrollApp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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
        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            log.error("Invalid employee name");
            throw new IllegalArgumentException("Employee name must not be empty");
        }
        log.info("Creating employee in service: {}", dto);
        EmployeePayrollData emp = new EmployeePayrollData(0, dto.getName(), dto.getSalary());
        return repository.save(emp);
    }

    @Override
    public EmployeePayrollData updateEmployee(int id, EmployeeDTO dto) {
        EmployeePayrollData existing = getEmployeeById(id);
        existing.setName(dto.getName());
        existing.setSalary(dto.getSalary());
        log.info("Updating employee with id {} to new values: {}", id, dto);
        return repository.save(existing);
    }

    @Override
    public void deleteEmployee(int id) {
        log.warn("Deleting employee with id {}", id);
        repository.deleteById(id);
    }
}
