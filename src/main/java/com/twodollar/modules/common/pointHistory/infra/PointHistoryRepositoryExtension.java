package com.twodollar.modules.common.pointHistory.infra;


import com.twodollar.modules.common.pointHistory.domain.PointHistory;
import com.twodollar.modules.common.pointHistory.web.dto.request.PointHistorySearchRequest;
import org.springframework.data.domain.PageImpl;

public interface PointHistoryRepositoryExtension {

    PageImpl<PointHistory> list(PointHistorySearchRequest pointSearchRequest);

}
