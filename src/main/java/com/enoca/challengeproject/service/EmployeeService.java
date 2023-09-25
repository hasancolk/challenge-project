package com.enoca.challengeproject.service;

import com.enoca.challengeproject.request.CreateEmployeeRequest;
import com.enoca.challengeproject.response.EmployeeResponse;
import com.enoca.challengeproject.request.UpdateEmployeeRequest;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse createEmployee(CreateEmployeeRequest request);
    void deleteEmployee(Long employeeId);
    EmployeeResponse updateEmployee(UpdateEmployeeRequest request);
    EmployeeResponse getEmployeeById(Long employeeId);
    List<EmployeeResponse> getEmployeesByCompanyId(Long companyId);
    List<EmployeeResponse> getAllEmployees();

}
