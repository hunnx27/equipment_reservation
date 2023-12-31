package com.twodollar.modules.bak.counsel.infra.counsel;


import com.twodollar.modules.bak.counsel.domain.Counsel;
import com.twodollar.modules.bak.counsel.domain.enums.QnaGubn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounselRepository extends JpaRepository<Counsel, Long>,
        CounselRepositoryExtension {

    long countByParentCounselId(Long parentCounselId);
    Long countByAccount_IdAndQnaGubn(Long id, QnaGubn gubn);

//    List<Counsel> findByParentCounselId(Long parentCounselId);
//    @Query("select c from Counsel c where c.qnaGubn='A' and c.parentCounsel.id = :parentCounselId")
//    List<Counsel> findByParentCounselId2(@Param("parentCounselId") Long parentCounselId);
}
