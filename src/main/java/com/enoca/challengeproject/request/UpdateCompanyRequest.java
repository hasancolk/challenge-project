package com.enoca.challengeproject.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCompanyRequest {

    @NotNull(message = "companyId cannot be null")
    private Long companyId;

    private String name;

    private String industry;
}
