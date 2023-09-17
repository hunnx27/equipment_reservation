package com.twodollar.modules.bak.counsel.infra.counselRecommend;


import com.twodollar.modules.bak.counsel.domain.CounselRecommend;

import java.util.List;

public interface CounselRecommendRepositoryExtension {
//    List<Counsel> findAnswerList(Long parentCounselId, Pageable pageable);

    List<CounselRecommend> findRecommendCheck(Long answerId, Long accountId);
    List<CounselRecommend> findRecommendCheckN(Long answerId, Long accountId);
    List<CounselRecommend> findRecommend(Long answerId);
    long countNotice(Long answerId, Long accountId);
}