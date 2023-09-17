package com.twodollar.modules.review.infra;

import com.twodollar.modules.review.web.dto.FindEstaRequestDto;
import com.twodollar.modules.company.web.dto.reponse.YearAmtListResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AmtReviewRepositoryExtension {
    List<YearAmtListResponseDto> ListAmt(FindEstaRequestDto findEstaRequestDto, Pageable pageable);

}
