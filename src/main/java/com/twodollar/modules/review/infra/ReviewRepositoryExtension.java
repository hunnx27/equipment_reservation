package com.twodollar.modules.review.infra;


import com.twodollar.modules.auth.web.dto.UserPrincipal;
import com.twodollar.modules.review.domain.dto.ReviewAllDto;
import com.twodollar.modules.review.web.dto.FindEstaRequestDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReviewRepositoryExtension {
    List<ReviewAllDto> findByAllReview(FindEstaRequestDto findEstaRequestDto, Pageable pageable);
    List<ReviewAllDto> findByAllMyReview(UserPrincipal me, Pageable pageable);
}
