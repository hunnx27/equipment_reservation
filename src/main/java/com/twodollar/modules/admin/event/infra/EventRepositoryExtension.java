package com.twodollar.modules.admin.event.infra;

import com.twodollar.modules.admin.event.web.dto.EventSearchRequestDto;
import com.twodollar.modules.admin.event.web.dto.EventSearchResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EventRepositoryExtension {
    List<EventSearchResponseDto> findEventSearch(EventSearchRequestDto eventSearchRequestDto, Pageable pageable);
}
