package com.twodollar.modules.admin.reviews.web.dto;

import com.twodollar.common.web.dto.response.enums.InterestCompany;
import com.twodollar.common.web.dto.response.enums.State;
import com.twodollar.modules.bak.company.domain.enums.EstablishmentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewMRequestDto {
    private InterestCompany interestCompany;
    private EstablishmentType establishmentType;
    private State state;
    private String siDo;
    private String sigunGu;
    private String createdAtOption;
    private String createdAtA;
    private String createdAtB;

    private String officeName;
}
