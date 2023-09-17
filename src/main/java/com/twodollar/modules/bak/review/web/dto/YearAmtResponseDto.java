package com.twodollar.modules.bak.review.web.dto;

import lombok.Data;

@Data
public class YearAmtResponseDto {
    private Long Amt;

    public YearAmtResponseDto(Long Amt){
        this.Amt=getAmt();
    }
}
