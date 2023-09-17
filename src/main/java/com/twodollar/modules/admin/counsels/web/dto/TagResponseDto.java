package com.twodollar.modules.admin.counsels.web.dto;

import com.twodollar.common.web.dto.response.enums.Gubn;
import lombok.Getter;

@Getter
public class TagResponseDto {
    private Gubn gubn;
    private String inputTag;
    private Long count;
}
