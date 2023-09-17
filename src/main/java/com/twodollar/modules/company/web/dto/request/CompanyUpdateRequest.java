package com.twodollar.modules.company.web.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CompanyUpdateRequest {
    @NotNull(message = "반드시 입력해야 합니다")
    private String name;
}
