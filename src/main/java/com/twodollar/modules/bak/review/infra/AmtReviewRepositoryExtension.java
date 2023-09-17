package com.twodollar.modules.bak.review.infra;

import com.twodollar.modules.bak.review.web.dto.FindEstaRequestDto;
import com.twodollar.modules.bak.company.web.dto.reponse.YearAmtListResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AmtReviewRepositoryExtension {
    List<YearAmtListResponseDto> ListAmt(FindEstaRequestDto findEstaRequestDto, Pageable pageable);

}
