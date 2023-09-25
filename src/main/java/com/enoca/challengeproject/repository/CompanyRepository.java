package com.enoca.challengeproject.repository;

import com.enoca.challengeproject.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}