package com.twodollar.modules.admin.notice.web.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class NoticeRequestDto {
    @NotNull(message = "반드시 입력해야 합니다")
    private String title;
    @NotNull(message = "반드시 입력해야 합니다")
    private String deviceGubn;
    @NotNull(message = "반드시 입력해야 합니다")
    private String useYn;
    @NotNull(message = "반드시 입력해야 합니다")
    private String content;
}
