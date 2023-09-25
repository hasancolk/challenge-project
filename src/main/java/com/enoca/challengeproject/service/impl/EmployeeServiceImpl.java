package com.enoca.challengeproject.service.impl;

import com.enoca.challengeproject.request.CreateEmployeeRequest;
import com.enoca.challengeproject.response.EmployeeResponse;
import com.enoca.challengeproject.request.UpdateEmployeeRequest;
import com.enoca.challengeproject.model.Company;
import com.enoca.challengeproject.model.Employee;
import com.enoca.challengeproject.repository.CompanyRepository;
import com.enoca.challengeproject.repository.EmployeeRepository;
import com.enoca.challengeproject.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public EmployeeResponse createEmployee(CreateEmployeeRequest request) {

        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setSurname(request.getSurname());
        employee.setTitle(request.getTitle());
        employee.setDepartment(request.getDepartment());

        Optional<Company>company = companyRepository.findById(request.getCompanyId());

        if(company.isPresent()){
            employee.setCompany(company.get());
        } else{
            throw new EntityNotFoundException("Company is not found!");
        }

        return new EmployeeResponse(employeeRepository.save(employee));
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        if(employeeId == null){
            throw new IllegalArgumentException("employeeId cannot be null");
        }

        if(employeeRepository.existsById(employeeId)){
            employeeRepository.deleteById(employeeId);
        } else{
            throw new EntityNotFoundException("Employee is not found!");
        }
    }

    @Override
    public EmployeeResponse updateEmployee(UpdateEmployeeRequest request) {

        Optional<Employee>employee = employeeRepository.findById(request.getEmployeeId());

        if(employee.isEmpty()){
            throw new EntityNotFoundException("Employee is not found!");
        }

        if(StringUtils.hasText(request.getName())){
            employee.get().setName(request.getName());
        }

        if(StringUtils.hasText(request.getSurname())){
            employee.get().setSurname(request.getSurname());
        }

        if(StringUtils.hasText(request.getTitle())){
            employee.get().setTitle(request.getTitle());
        }

        if(StringUtils.hasText(request.getDepartment())){
            employee.get().setDepartment(request.getDepartment());
        }

        if(request.getCompanyId() != null){
            Optional<Company>company = companyRepository.findById(request.getCompanyId());
            if(company.isPresent()){
                employee.get().setCompany(company.get());
            } else{
                throw new EntityNotFoundException("Company is not found!");
            }
        }

        return new EmployeeResponse(employeeRepository.save(employee.get()));
    }

    @Override
    public EmployeeResponse getEmployeeById(Long employeeId) {

        if(employeeId == null){
            throw new IllegalArgumentException("employeeId cannot be null");
        }

        Optional<Employee>employee = employeeRepository.findById(employeeId);

        if(employee.isPresent()){
            return new EmployeeResponse(employee.get());
        } else{
            throw new EntityNotFoundException("Employee is not found!");
        }
    }

    @Override
    public List<EmployeeResponse> getEmployeesByCompanyId(Long companyId) {

        if(companyId == null){
            throw new IllegalArgumentException("companyId cannot be null");
        }

        if(!companyRepository.existsById(companyId)){
            throw new EntityNotFoundException("Company is not found!");
        }

        return employeeRepository.findByCompanyId(companyId);
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAllEmployees();
    }


}
