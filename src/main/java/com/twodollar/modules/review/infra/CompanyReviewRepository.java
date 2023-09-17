package com.twodollar.modules.review.infra;

import com.twodollar.modules.review.domain.CompanyReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyReviewRepository extends JpaRepository<CompanyReview, Long>,
        CompanyReviewRepositoryExtension{
    
    List<CompanyReview> findByCompanyId(Long company_id);
    Long countByAccount_Id(Long id);
}
