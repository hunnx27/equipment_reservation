package com.twodollar.modules.admin.companies.web.dto;

import com.twodollar.common.web.dto.response.enums.Gubn;
import com.twodollar.common.web.dto.response.enums.InterestCompany;
import com.twodollar.common.web.dto.response.enums.ProcessT;
import com.twodollar.modules.bak.company.domain.enums.EstablishmentType;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class CompaniesFixDetailResponseDto {
    private Long id;
    private String userId;
    private Gubn gubn;
    private ZonedDateTime createDt;
    private String fixText;
    //기관정보탭
    private InterestCompany interestCompany;
    private EstablishmentType establishmentType;
    private String officeName;
    private String zonecode;
    //처리현황
    private String apprId;
    private ProcessT process;
    private String apprTxt;
}
