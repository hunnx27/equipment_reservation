package com.twodollar.modules.review.infra;

import com.twodollar.modules.review.domain.InterviewReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterviewReviewRepository  extends JpaRepository<InterviewReview, Long>,
        InterviewReviewRepositoryExtension{

    List<InterviewReview> findByCompanyId(Long company_id);
    Long countByAccount_Id(Long id);;
}
