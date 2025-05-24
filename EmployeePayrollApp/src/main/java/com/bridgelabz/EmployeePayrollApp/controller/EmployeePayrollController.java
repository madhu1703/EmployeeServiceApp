package com.bridgelabz.EmployeePayrollApp.controller;
import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApp.entity.EmployeePayrollData;
import com.bridgelabz.EmployeePayrollApp.service.IEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
@CrossOrigin("*")
public class EmployeePayrollController {

    @Autowired
    private IEmployeeService service;

    @GetMapping("/")
    public List<EmployeePayrollData> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public EmployeePayrollData getEmployee(@PathVariable int id) {
        return service.getEmployeeById(id);
    }
    @PostMapping("/create")
    public EmployeePayrollData createEmployee(@Valid @RequestBody EmployeeDTO dto) {
        return service.createEmployee(dto);
    }

    @PutMapping("/update/{id}")
    public EmployeePayrollData updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeeDTO dto) {
        return service.updateEmployee(id, dto);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
        return "Deleted Employee ID: " + id;
    }
}
