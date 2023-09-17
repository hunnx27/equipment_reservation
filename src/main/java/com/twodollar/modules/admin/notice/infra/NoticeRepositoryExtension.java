package com.twodollar.modules.admin.notice.infra;

import com.twodollar.modules.admin.notice.web.dto.NoticeSearchRequestDto;
import com.twodollar.modules.admin.notice.web.dto.NoticeSearchResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NoticeRepositoryExtension {
    List<NoticeSearchResponseDto> findNoticeSearch(NoticeSearchRequestDto noticeSearchRequestDto, Pageable pageable);
}
