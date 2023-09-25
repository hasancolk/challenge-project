package com.enoca.challengeproject.service.impl;

import com.enoca.challengeproject.request.CreateCompanyRequest;
import com.enoca.challengeproject.request.UpdateCompanyRequest;
import com.enoca.challengeproject.model.Company;
import com.enoca.challengeproject.repository.CompanyRepository;
import com.enoca.challengeproject.repository.EmployeeRepository;
import com.enoca.challengeproject.service.CompanyService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Company createCompany(CreateCompanyRequest request) {

        Company company = new Company();
        company.setName(request.getName());
        company.setIndustry(request.getIndustry());

        return companyRepository.save(company);
    }

    @Transactional
    @Override
    public void deleteCompany(Long companyId) {

        if(companyId == null){
            throw new IllegalArgumentException("companyId cannot be null");
        }

        if(companyRepository.existsById(companyId)){
            employeeRepository.deleteByCompanyId(companyId);
            companyRepository.deleteById(companyId);
        } else{
            throw new EntityNotFoundException("Company is not found!");
        }

    }

    @Override
    public Company updateCompany(UpdateCompanyRequest request) {

        Optional<Company>company = companyRepository.findById(request.getCompanyId());

        if(company.isEmpty()){
            throw new EntityNotFoundException("Company is not found!");
        }

        if(StringUtils.hasText(request.getName())){
            company.get().setName(request.getName());
        }

        if(StringUtils.hasText(request.getIndustry())){
            company.get().setIndustry(request.getIndustry());
        }

        return companyRepository.save(company.get());
    }

    @Override
    public Company getCompanyById(Long companyId) {

        if(companyId == null){
            throw new IllegalArgumentException("companyId cannot be null");
        }

        Optional<Company>company = companyRepository.findById(companyId);

        if(company.isPresent()){
            return company.get();
        } else{
            throw new EntityNotFoundException("Company is not found!");
        }
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }


}
