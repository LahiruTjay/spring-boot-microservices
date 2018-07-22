package com.example.employee.service;

import org.springframework.http.ResponseEntity;

import com.example.employee.common.dto.CommonResponse;

public interface EmployeeService {

    ResponseEntity<CommonResponse> getAllEmployees();

    ResponseEntity<CommonResponse> getEmployeeById(long employeeId);

}
