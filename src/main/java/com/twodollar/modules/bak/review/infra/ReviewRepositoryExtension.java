package com.twodollar.modules.bak.review.infra;


import com.twodollar.modules.auth.web.dto.UserPrincipal;
import com.twodollar.modules.bak.review.domain.dto.ReviewAllDto;
import com.twodollar.modules.bak.review.web.dto.FindEstaRequestDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReviewRepositoryExtension {
    List<ReviewAllDto> findByAllReview(FindEstaRequestDto findEstaRequestDto, Pageable pageable);
    List<ReviewAllDto> findByAllMyReview(UserPrincipal me, Pageable pageable);
}
