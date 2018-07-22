package com.example.employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.employee.common.dto.CommonResponse;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeDAO;
import com.example.employee.service.EmployeeService;
import com.example.employee.util.CommonResponseUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;

    public ResponseEntity<CommonResponse> getAllEmployees() {
        return CommonResponseUtil.successResponse(employeeDAO.findAll());
    }

    public ResponseEntity<CommonResponse> getEmployeeById(long employeeId) {
        Employee employee = employeeDAO.findOne(employeeId);
        if (employee != null) {
            return CommonResponseUtil.successResponse(employee);
        } else {
            return CommonResponseUtil.failureResponse();
        }
    }

}
