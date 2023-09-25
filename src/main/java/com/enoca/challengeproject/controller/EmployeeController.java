package com.enoca.challengeproject.controller;

import com.enoca.challengeproject.response.BaseResponse;
import com.enoca.challengeproject.request.CreateEmployeeRequest;
import com.enoca.challengeproject.response.EmployeeResponse;
import com.enoca.challengeproject.request.UpdateEmployeeRequest;
import com.enoca.challengeproject.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/createEmployee")
    public ResponseEntity<BaseResponse> createEmployee(@Valid @RequestBody CreateEmployeeRequest request){
        BaseResponse response = new BaseResponse();
        EmployeeResponse employee = employeeService.createEmployee(request);
        response.getData().put("createdEmployee",employee);
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteEmployee/{employeeId}")
    public ResponseEntity<BaseResponse> deleteCompany(@PathVariable Long employeeId){
        BaseResponse baseResponse = new BaseResponse();
        employeeService.deleteEmployee(employeeId);
        baseResponse.getData().put("message","Employee with ID: " + employeeId + " has been successfully deleted.");
        baseResponse.setSuccess(true);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<BaseResponse> updateEmployee(@Valid @RequestBody UpdateEmployeeRequest request){
        BaseResponse response = new BaseResponse();
        EmployeeResponse employee = employeeService.updateEmployee(request);
        response.getData().put("updatedEmployee",employee);
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getEmployeeById/{employeeId}")
    public ResponseEntity<BaseResponse> getEmployeeById(@PathVariable Long employeeId){
        BaseResponse response = new BaseResponse();
        EmployeeResponse employee = employeeService.getEmployeeById(employeeId);
        response.getData().put("employee",employee);
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getEmployeesByCompanyId/{companyId}")
    public ResponseEntity<BaseResponse> getEmployeesByCompanyId(@PathVariable Long companyId){
        BaseResponse response = new BaseResponse();
        List<EmployeeResponse> employees = employeeService.getEmployeesByCompanyId(companyId);
        response.getData().put("employees",employees);
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<BaseResponse> getAllEmployees(){
        BaseResponse response = new BaseResponse();
        List<EmployeeResponse> employees = employeeService.getAllEmployees();
        response.getData().put("employees",employees);
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
