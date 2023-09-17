package com.twodollar.modules.admin.counsels.web.dto;

import com.twodollar.common.web.dto.response.enums.Gubn;
import com.twodollar.common.web.dto.response.enums.YN;
import com.twodollar.modules.counsel.domain.enums.CounselState;
import com.twodollar.modules.counsel.domain.enums.QnaItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Setter
@NoArgsConstructor
public class CounselsResponseDto {

    public String getGubn() {
        String gubName = this.gubName;
        if (this.gubn != null && this.gubName == null) {
            gubName = this.gubn.getName();
        }
        return gubName;
    }
    private Gubn gubn;
    private String gubName;

    public String getQnaItem() {
        String qnaItemName= this.qnaItemName;
        if(this.qnaItem!=null && this.qnaItemName==null){
            qnaItemName=this.qnaItem.getName();
        }
        return qnaItemName;
    }
    private String qnaItemName;
    private QnaItem qnaItem;

    @Getter
    private String inputTag;
    @Getter
    private String txt;

    public Long getqCount() {
        return qCount!=null? this.qCount:0;
    }
    private Long qCount;

    public String getCounselState() {
        String counselStateName = this.counselStateName;
        if(counselState!=null&& this.counselStateName==null){
            counselStateName=this.counselState.getName();
        }
        return counselStateName;
    }
    private String counselStateName;
    private CounselState counselState;

    @Getter
    private String userId;
    @Getter
    private YN shortOpenYn;

    public String getCreatedAt(){
        String createdDtName=this.createdDtName;
        if(createdAt!=null&&this.createdDtName==null){
            createdDtName= this.createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        return createdDtName;
    }

    private String createdDtName;
    private ZonedDateTime createdAt;

    public YN getIsDeleted() {
        return isDeleted!=null? YN.valueOf(String.valueOf(isDeleted)):YN.N;
    }
    private YN isDeleted;

}
