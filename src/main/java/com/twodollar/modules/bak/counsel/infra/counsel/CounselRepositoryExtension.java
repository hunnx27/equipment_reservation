package com.twodollar.modules.bak.counsel.infra.counsel;


import com.twodollar.modules.account.domain.Account;
import com.twodollar.modules.bak.counsel.domain.Counsel;
import com.twodollar.modules.bak.counsel.web.dto.request.counsel.CounselSearchRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CounselRepositoryExtension {

    List<Counsel> findCounselList(CounselSearchRequest counselSearchRequest, Pageable pageable);
    List<Counsel> findMyqCounselList(Account account, Pageable pageable,String option);
    List<Counsel> findMyaCounselList(Account account, Pageable pageable,String option);
    List<Counsel> findAnswerList(Long parentCounselId, Pageable pageable);
    List<Counsel> findCounselTag(String tag);
    long countAdoptedAnswer(Long answerId, Long accountId);


}