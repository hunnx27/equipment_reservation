package com.twodollar.modules.bak.review.web.dto;

import com.twodollar.common.domain.BaseEntity;
import com.twodollar.common.web.dto.response.enums.YN;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class CompanyReviewRequestDto extends BaseEntity {

    @NotNull(message="반드시 입력해야 합니다.")
    private String txt;
    @NotNull(message="반드시 입력해야 합니다.")
    private Long companyId;
    @NotNull(message="반드시 입력해야 합니다.")
    private Long workExp;
    private YN WorkExpOpenYn;
    @NotNull(message="반드시 입력해야 합니다.")
    private String itemB1;
    @NotNull(message="반드시 입력해야 합니다.")
    private String itemB2;
    @NotNull(message="반드시 입력해야 합니다.")
    private String itemB3;
    @NotNull(message="반드시 입력해야 합니다.")
    private String itemC1;
    @NotNull(message="반드시 입력해야 합니다.")
    private String itemC2;
    @NotNull(message="반드시 입력해야 합니다.")
    private String itemC3;
    @NotNull(message="반드시 입력해야 합니다.")
    private String itemD1;
    @NotNull(message="반드시 입력해야 합니다.")
    private String itemD2;
    @NotNull(message="반드시 입력해야 합니다.")
    private String likeCode;

}
