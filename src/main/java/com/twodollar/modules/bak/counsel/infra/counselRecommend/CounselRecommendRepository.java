package com.twodollar.modules.bak.counsel.infra.counselRecommend;


import com.twodollar.modules.bak.counsel.domain.CounselRecommend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounselRecommendRepository extends JpaRepository<CounselRecommend, Long>,
        CounselRecommendRepositoryExtension {

//    List<Counsel> findByParentCounselId(Long parentCounselId);
//    @Query("select c from Counsel c where c.qnaGubn='A' and c.parentCounsel.id = :parentCounselId")
//    List<Counsel> findByParentCounselId2(@Param("parentCounselId") Long parentCounselId);
}
