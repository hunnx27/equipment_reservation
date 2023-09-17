package com.twodollar.modules.review.infra;

import com.twodollar.modules.review.domain.CompanyReview;
import com.twodollar.modules.review.web.dto.FindEstaRequestDto;
import com.twodollar.modules.company.web.dto.reponse.CompanyReviewListResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompanyReviewRepositoryExtension {
    List<CompanyReviewListResponseDto> listCompanyReview(FindEstaRequestDto findEstaRequestDto, Pageable pageable);
    List<CompanyReview> listCompanyReviewByCompanyId(Long companyId);
}
