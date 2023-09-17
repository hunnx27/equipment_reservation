package com.twodollar.modules.bak.review.infra;

import com.twodollar.modules.bak.review.domain.InterviewReviewItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewReviewItemRepository extends JpaRepository<InterviewReviewItem, Long>{

}
