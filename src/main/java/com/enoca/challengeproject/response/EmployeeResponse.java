package com.enoca.challengeproject.response;

import com.enoca.challengeproject.model.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeResponse {

    private Long id;
    private String name;
    private String surname;
    private String title;
    private String department;
    private String companyName;

    public EmployeeResponse(Employee employee){
        this.id = employee.getId();
        this.name = employee.getName();
        this.surname = employee.getSurname();
        this.title = employee.getTitle();
        this.department = employee.getDepartment();
        this.companyName = employee.getCompany().getName();
    }

    public EmployeeResponse(Long id, String name, String surname, String title, String department, String companyName){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.department = department;
        this.companyName = companyName;
    }

}
