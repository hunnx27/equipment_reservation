package com.twodollar.modules.bak.review.infra;

import com.twodollar.modules.bak.review.domain.YearAmtReview;
import com.twodollar.modules.bak.company.web.dto.reponse.YearAmtListResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AmtReviewRepository extends JpaRepository<YearAmtReview, Long>,
        AmtReviewRepositoryExtension{

    List<YearAmtListResponseDto> findByCompanyId(Long company_id);
    Long countByAccount_Id(Long id);
}
