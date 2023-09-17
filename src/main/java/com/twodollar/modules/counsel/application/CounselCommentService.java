package com.twodollar.modules.counsel.application;

import com.twodollar.common.web.dto.response.enums.YN;
import com.twodollar.common.util.FileUtil;
import com.twodollar.modules.account.application.AccountService;
import com.twodollar.modules.account.domain.Account;
import com.twodollar.modules.auth.web.dto.UserPrincipal;
import com.twodollar.modules.common.pointHistory.domain.enums.PointTable;
import com.twodollar.modules.counsel.domain.CounselComment;
import com.twodollar.modules.counsel.infra.counsel.CounselRepository;
import com.twodollar.modules.counsel.infra.counselComment.CounselCommentRepository;
import com.twodollar.modules.counsel.web.dto.request.counselComment.CounselCommentCreateRequest;
import com.twodollar.modules.counsel.web.dto.request.counselComment.CounselCommentUpdateRequest;
import com.twodollar.modules.counsel.web.dto.response.counselComment.CounselCommentDetailResponse;
import com.twodollar.modules.counsel.web.dto.response.counselComment.CounselCommentListResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CounselCommentService {

    private final AccountService accountService;
    private final CounselCommentRepository counselCommentRepository;
    private final CounselRepository counselRepository;
    private final FileUtil fileUtil;

    public ResponseEntity<?> create(CounselCommentCreateRequest counselCommentCreateRequest, UserPrincipal me) {
        // 댓글 등록자 설정
        Account account = accountService.findOne(me.getId());
        // 답변 설정
        counselCommentCreateRequest.setParentCounsel(counselRepository.findById(counselCommentCreateRequest.getParentCounselId()).orElseGet(null));
        CounselComment counselComment = new CounselComment(counselCommentCreateRequest, account);
        CounselComment saved = counselCommentRepository.save(counselComment);
        accountService.createMyPointHistories(account, PointTable.COUNCEL_ANSWER_REGIST);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    public List<CounselCommentListResponse> commentList(Long answerId, Pageable pageable, UserPrincipal me){
        Account account = accountService.findOne(me.getId());
        List<CounselComment> list = counselCommentRepository.findCommentList(answerId, pageable);
        List<CounselCommentListResponse> result = list.stream().map(counselComment->new CounselCommentListResponse(counselComment, account)).collect(Collectors.toList());
        return result;
    }

    public CounselCommentDetailResponse detail(Long id, UserPrincipal me){
        CounselComment counselComment = counselCommentRepository.findById(id).orElse(null);
        CounselCommentDetailResponse result = null;
        if(counselComment != null){
            result = new CounselCommentDetailResponse(counselComment);
        }
        return result;
    }

    public CounselComment updateCounselComment(Long id, CounselCommentUpdateRequest counselCommentUpdateRequest, UserPrincipal me){
        Account account = accountService.findOne(me.getId());
        CounselComment counselComment = counselCommentRepository.findById(id).get();
        if(counselComment.getAccount().getUserId().equals(account.getUserId())) {
            counselComment.updateCounselComment(counselCommentUpdateRequest, account);
            CounselComment saved = counselCommentRepository.save(counselComment);
            return saved;
        }else{
            return counselComment;
        }
    }

    public CounselComment deleteCounselCommentSoft(Long id){
        CounselComment counselComment = counselCommentRepository.findById(id).orElseThrow();
        counselComment.setIsDelete(YN.Y);
        counselCommentRepository.save(counselComment);
        return counselComment;
    }

}
