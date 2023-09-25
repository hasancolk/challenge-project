package com.enoca.challengeproject.controller;

import com.enoca.challengeproject.response.BaseResponse;
import com.enoca.challengeproject.request.CreateCompanyRequest;
import com.enoca.challengeproject.request.UpdateCompanyRequest;
import com.enoca.challengeproject.model.Company;
import com.enoca.challengeproject.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/createCompany")
    public ResponseEntity<BaseResponse> createCompany(@Valid @RequestBody CreateCompanyRequest request){
        BaseResponse response = new BaseResponse();
        Company company = companyService.createCompany(request);
        response.getData().put("createdCompany",company);
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCompany/{companyId}")
    public ResponseEntity<BaseResponse> deleteCompany(@PathVariable Long companyId){
        BaseResponse baseResponse = new BaseResponse();
        companyService.deleteCompany(companyId);
        baseResponse.getData().put("message","Company with ID: " + companyId + " has been successfully deleted.");
        baseResponse.setSuccess(true);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PutMapping("/updateCompany")
    public ResponseEntity<BaseResponse> updateCompany(@Valid @RequestBody UpdateCompanyRequest request){
        BaseResponse response = new BaseResponse();
        Company company = companyService.updateCompany(request);
        response.getData().put("updatedCompany",company);
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getCompanyById/{companyId}")
    public ResponseEntity<BaseResponse> getCompanyById(@PathVariable Long companyId){
        BaseResponse response = new BaseResponse();
        Company company = companyService.getCompanyById(companyId);
        response.getData().put("company",company);
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getAllCompanies")
    public ResponseEntity<BaseResponse> getAllCompanies(){
        BaseResponse response = new BaseResponse();
        List<Company> companies = companyService.getAllCompanies();
        response.getData().put("companies",companies);
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
