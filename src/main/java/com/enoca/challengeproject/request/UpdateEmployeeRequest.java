package com.enoca.challengeproject.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEmployeeRequest {

    @NotNull(message = "employeeId cannot be null")
    private Long employeeId;

    private String name;

    private String surname;

    private String title;

    private String department;

    private Long companyId;
}
