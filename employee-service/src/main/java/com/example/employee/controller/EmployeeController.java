package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.common.dto.CommonResponse;
import com.example.employee.service.EmployeeService;
import com.example.employee.util.CommonResponseUtil;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "employees", method = RequestMethod.GET)
    ResponseEntity<CommonResponse> getAllEmployees() {
        return CommonResponseUtil.successResponse(employeeService.getAllEmployees());
    }
}
