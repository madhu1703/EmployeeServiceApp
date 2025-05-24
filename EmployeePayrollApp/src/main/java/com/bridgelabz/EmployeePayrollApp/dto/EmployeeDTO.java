package com.bridgelabz.EmployeePayrollApp.dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class EmployeeDTO {

    @NotNull(message = "Name should not be null")
    private String name;

    @Min(value = 500, message = "Salary must be at least 500")
    private double salary;
}