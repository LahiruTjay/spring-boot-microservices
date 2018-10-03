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

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        super();
        this.employeeDAO = employeeDAO;
    }

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

    public ResponseEntity<CommonResponse> addEmployee(Employee employee) {
        return CommonResponseUtil.successResponse(employeeDAO.save(employee));
    }

    public ResponseEntity<CommonResponse> updateEmployee(long employeeId, Employee employeeDetails) {
        Employee employee = employeeDAO.findOne(employeeId);
        if (employee != null) {
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setLastName(employeeDetails.getLastName());
            employee.setBirthDate(employeeDetails.getBirthDate());
            employeeDAO.save(employee);
            return CommonResponseUtil.successResponse(employeeDAO.save(employee));
        } else {
            return CommonResponseUtil.failureResponse();
        }
    }

    public ResponseEntity<CommonResponse> deleteEmployeeById(long employeeId) {
        employeeDAO.delete(employeeId);
        return CommonResponseUtil.successResponse("Deleted");
    }

}
