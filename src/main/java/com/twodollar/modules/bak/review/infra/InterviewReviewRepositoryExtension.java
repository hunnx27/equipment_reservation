package com.twodollar.modules.bak.review.infra;

import com.twodollar.modules.bak.company.web.dto.reponse.InterviewListResponseDto;
import com.twodollar.modules.bak.review.web.dto.FindEstaRequestDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InterviewReviewRepositoryExtension {
    List<InterviewListResponseDto> ListInterview(FindEstaRequestDto findEstaRequestDto, Pageable pageable);
}
