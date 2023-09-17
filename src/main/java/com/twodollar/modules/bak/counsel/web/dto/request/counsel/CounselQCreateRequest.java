package com.twodollar.modules.bak.counsel.web.dto.request.counsel;

import com.twodollar.common.web.dto.response.enums.InterestCompany;
import com.twodollar.common.web.dto.response.enums.YN;
import com.twodollar.modules.bak.counsel.domain.enums.QnaItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CounselQCreateRequest {

    private String addedTagData;
    private InterestCompany interestCompanyName; // 관심 기관
    private String relatedZone;
    private QnaItem qnaItem;
    private String txt;
    private YN shortOpenYn;

    // 자동처리
//    @Convert(converter = GubnConverter.class)
//    private Gubn gubn;
//    private JobGubn jobGubn;
//    private QnaGubn qnaGubn=QnaGubn.Q;





}
