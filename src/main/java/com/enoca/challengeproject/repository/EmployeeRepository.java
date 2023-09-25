package com.enoca.challengeproject.repository;

import com.enoca.challengeproject.response.EmployeeResponse;
import com.enoca.challengeproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void deleteByCompanyId(Long companyId);

    @Query("SELECT new com.enoca.challengeproject.response.EmployeeResponse(id, name, surname, title, department, company.name) " +
            "FROM Employee " +
            "WHERE company.id = :companyId")
    List<EmployeeResponse> findByCompanyId(@Param("companyId") Long companyId);

    @Query("SELECT new com.enoca.challengeproject.response.EmployeeResponse(id, name, surname, title, department, company.name) " +
            "FROM Employee")
    List<EmployeeResponse> findAllEmployees();
}