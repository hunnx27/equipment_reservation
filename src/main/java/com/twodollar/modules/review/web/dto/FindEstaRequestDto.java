package com.twodollar.modules.review.web.dto;

import com.twodollar.common.web.dto.response.enums.InterestCompany;
import com.twodollar.common.web.dto.request.BasePageRequest;
import com.twodollar.modules.company.domain.enums.EstablishmentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindEstaRequestDto extends BasePageRequest {
    private InterestCompany interestCompany;
    private EstablishmentType establishmentType;
    private String sido;
    private String gungu;

}
/*
{
  "interestCompany": "daycarecenter",
  "establishmentType": "all"
}
 */