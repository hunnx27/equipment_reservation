package com.twodollar.modules.admin.faq.web.dto;

import com.twodollar.modules.admin.notice.domain.enums.DeviceGubn;
import lombok.Data;

@Data
public class FaqSearchRequestDto {
    private String txt;
    private DeviceGubn deviceGubn;
    private String createDtA;
    private String createDtB;
}
