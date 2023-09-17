package com.twodollar.modules.review.infra;

import com.twodollar.modules.review.domain.InterviewReviewItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewReviewItemRepository extends JpaRepository<InterviewReviewItem, Long>{

}
