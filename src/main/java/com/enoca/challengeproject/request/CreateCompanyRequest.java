package com.enoca.challengeproject.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCompanyRequest {

    @NotBlank(message = "name cannot be null or empty")
    private String name;

    @NotBlank(message = "industry cannot be null or empty")
    private String industry;
}
