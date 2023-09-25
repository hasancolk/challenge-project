package com.enoca.challengeproject.service;

import com.enoca.challengeproject.request.CreateCompanyRequest;
import com.enoca.challengeproject.request.UpdateCompanyRequest;
import com.enoca.challengeproject.model.Company;

import java.util.List;

public interface CompanyService {
    Company createCompany(CreateCompanyRequest request);
    void deleteCompany(Long companyId);
    Company updateCompany(UpdateCompanyRequest request);
    Company getCompanyById(Long companyId);
    List<Company> getAllCompanies();
}
