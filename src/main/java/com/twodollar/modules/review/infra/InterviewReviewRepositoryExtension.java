package com.twodollar.modules.review.infra;

import com.twodollar.modules.company.web.dto.reponse.InterviewListResponseDto;
import com.twodollar.modules.review.web.dto.FindEstaRequestDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InterviewReviewRepositoryExtension {
    List<InterviewListResponseDto> ListInterview(FindEstaRequestDto findEstaRequestDto, Pageable pageable);
}
