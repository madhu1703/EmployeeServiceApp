package com.bridgelabz.EmployeePayrollApp.repository;
import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bridgelabz.EmployeePayrollApp.entity.EmployeePayrollData;

public interface EmployeeRepository extends JpaRepository<EmployeePayrollData, Integer> {
}
