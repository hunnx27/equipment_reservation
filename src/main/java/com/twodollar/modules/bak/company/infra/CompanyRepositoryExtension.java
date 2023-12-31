package com.twodollar.modules.bak.company.infra;


import com.twodollar.modules.bak.company.domain.Company;
import com.twodollar.modules.bak.company.web.dto.reponse.CompanyDetailResponse;
import com.twodollar.modules.bak.company.web.dto.reponse.CompanySearchResponse;
import com.twodollar.modules.bak.company.web.dto.request.CompanySearchRequest;
import com.twodollar.modules.bak.company.web.dto.request.CompanyUpdateRequest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompanyRepositoryExtension {
    List<CompanyDetailResponse> convertlist(Company company);
    PageImpl<Company> list(CompanySearchRequest companySearchRequest);
    List<CompanySearchResponse> search(CompanySearchRequest companySearchRequest, Pageable pageable);
    Long searchTotSize(CompanySearchRequest companySearchRequest);

    //        QAccount account = QAccount.account;
    //
    //        // 조건생성
    //        BooleanBuilder where = new BooleanBuilder();
    //        where.and(account.userId.eq(encodedUserId));
    //
    //        // 쿼리생성
    //        Account findedAccount = qf.selectFrom(account)
    //                .where(where)
    //                .fetchOne();
    //
    //        return Optional.ofNullable(findedAccount);
    //    }

    //        QAccount account = QAccount.account;
    //
    //        // 조건생성
    //        BooleanBuilder where = new BooleanBuilder();
    //        where.and(account.userId.eq(encodedUserId));
    //
    //        // 쿼리생성
    //        Account findedAccount = qf.selectFrom(account)
    //                .where(where)
    //                .fetchOne();
    //
    //        return Optional.ofNullable(findedAccount);
    //    }

    void update(Long id,CompanyUpdateRequest updateRequest);
    List<Company> getListBaseCompany(Pageable pageable);
}
