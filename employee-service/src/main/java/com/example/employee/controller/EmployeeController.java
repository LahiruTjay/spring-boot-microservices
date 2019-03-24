package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.common.dto.CommonResponse;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // @CrossOrigin(origins = "*")
    @RequestMapping(value = "/angular/employees", method = RequestMethod.GET)
    List<Employee> getAllEmployeesForAngular() {
        return employeeService.getAllEmployeesForAngular();
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    ResponseEntity<CommonResponse> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.GET)
    ResponseEntity<CommonResponse> getEmployeeById(@PathVariable(value = "employeeId") long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    ResponseEntity<CommonResponse> addEmployee(@RequestBody Employee employeeDetails) {
        return employeeService.addEmployee(employeeDetails);
    }

    @RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.PUT)
    ResponseEntity<CommonResponse> updateEmployee(@PathVariable(value = "employeeId") long employeeId, @RequestBody Employee employeeDetails) {
        return employeeService.updateEmployee(employeeId, employeeDetails);
    }

    @RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.DELETE)
    ResponseEntity<CommonResponse> deleteEmployeeById(@PathVariable(value = "employeeId") long employeeId) {
        return employeeService.deleteEmployeeById(employeeId);
    }

}
