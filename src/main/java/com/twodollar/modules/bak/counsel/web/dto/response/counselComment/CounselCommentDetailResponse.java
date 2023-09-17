package com.twodollar.modules.bak.counsel.web.dto.response.counselComment;

import com.twodollar.modules.bak.counsel.domain.CounselComment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CounselCommentDetailResponse {

    private Long id;
    private String txt;
    private Long parentCounselId;

    public CounselCommentDetailResponse(CounselComment counselComment) {
        this.id = counselComment.getId();
        this.txt = counselComment.getTxt();
        this.parentCounselId = counselComment.getCounsel().getId();
    }
}
