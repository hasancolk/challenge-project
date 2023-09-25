package com.enoca.challengeproject.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEmployeeRequest {

    @NotBlank(message = "name cannot be null or empty")
    private String name;

    @NotBlank(message = "surname cannot be null or empty")
    private String surname;

    @NotBlank(message = "title cannot be null or empty")
    private String title;

    @NotBlank(message = "department cannot be null or empty")
    private String department;

    @NotNull(message = "companyId cannot be null")
    private Long companyId;

}
