package com.twodollar.modules.bak.review.infra;

import com.twodollar.modules.bak.review.domain.CompanyReview;
import com.twodollar.modules.bak.review.web.dto.FindEstaRequestDto;
import com.twodollar.modules.bak.company.web.dto.reponse.CompanyReviewListResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompanyReviewRepositoryExtension {
    List<CompanyReviewListResponseDto> listCompanyReview(FindEstaRequestDto findEstaRequestDto, Pageable pageable);
    List<CompanyReview> listCompanyReviewByCompanyId(Long companyId);
}
