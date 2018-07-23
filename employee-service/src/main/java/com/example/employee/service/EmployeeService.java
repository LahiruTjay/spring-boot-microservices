package com.example.employee.service;

import org.springframework.http.ResponseEntity;

import com.example.employee.common.dto.CommonResponse;
import com.example.employee.model.Employee;

public interface EmployeeService {

    ResponseEntity<CommonResponse> getAllEmployees();

    ResponseEntity<CommonResponse> getEmployeeById(long employeeId);

    ResponseEntity<CommonResponse> addEmployee(Employee employeeDetails);

    ResponseEntity<CommonResponse> updateEmployee(long employeeId, Employee employeeDetails);

    ResponseEntity<CommonResponse> deleteEmployeeById(long employeeId);

}
