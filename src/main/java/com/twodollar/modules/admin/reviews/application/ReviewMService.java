package com.twodollar.modules.admin.reviews.application;

import com.twodollar.common.exception.CustomException;
import com.twodollar.modules.admin.reviews.infra.ReviewMRepository;
import com.twodollar.modules.admin.reviews.web.dto.*;
import com.twodollar.modules.auth.web.dto.UserPrincipal;
import com.twodollar.modules.bak.review.domain.CompanyReview;
import com.twodollar.modules.bak.review.domain.InterviewReview;
import com.twodollar.modules.bak.review.domain.YearAmtReview;
import com.twodollar.modules.bak.review.infra.AmtReviewRepository;
import com.twodollar.modules.bak.review.infra.CompanyReviewRepository;
import com.twodollar.modules.bak.review.infra.InterviewReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ReviewMService {
    private final ReviewMRepository reviewMRepository;
    private final AmtReviewRepository amtReviewRepository;
    private final InterviewReviewRepository interviewReviewRepository;
    private final CompanyReviewRepository companyReviewRepository;

    public List<ReviewMallResponseDto> allReview(Pageable pageable) throws CustomException {
        // 모든 리뷰 조회하는데 state가 W인 항목만
        List<ReviewMallResponseDto> Result = reviewMRepository.findByAllReview(pageable);
        return Result;
    }

    public List<ReviewsResponseDto> companyReview(Pageable pageable) throws CustomException {
        // 기관리뷰를 조회하는데 state가 W인 항목만
        List<ReviewsResponseDto> Result = reviewMRepository.findByCompanyReview(pageable);
        return Result;
    }

    public List<ReviewsResponseDto> interviewReview(Pageable pageable) throws CustomException {
        // 면접리뷰 조회하는데 state가 W인 항목만
        List<ReviewsResponseDto> Result = reviewMRepository.findByInterviewReview(pageable);
        return Result;
    }

    public List<ReviewsResponseDto> amtReview(Pageable pageable) throws CustomException {
        // 연봉리뷰를 조회하는데 state가 W인 항목만
        List<ReviewsResponseDto> Result = reviewMRepository.findByAmtReview(pageable);
        return Result;
    }

    public AllReviewResponsedto review(Long reviewId, String type) {
        switch (type) {
            case "AMT":
                YearAmtReview amtReview = amtReviewRepository.findById(reviewId).orElse(null);
                AmtReviewResponseDto amtReviewResponseDto = new AmtReviewResponseDto(amtReview);
                AllReviewResponsedto allReviewResponsedto = new AllReviewResponsedto(amtReviewResponseDto);
                return allReviewResponsedto;
            case "INTERVIEW":
                InterviewReview interviewReview = interviewReviewRepository.findById(reviewId).orElse(null);
                InterviewReviewResponseDto interviewReviewResponseDto = new InterviewReviewResponseDto(interviewReview);
                AllReviewResponsedto allReviewResponsedto1 = new AllReviewResponsedto(interviewReviewResponseDto);
                return allReviewResponsedto1;
            case "COMPANY":
                CompanyReview companyReview = companyReviewRepository.findById(reviewId).orElse(null);
                CompanyReviewResponseDto companyReviewResponseDto = new CompanyReviewResponseDto(companyReview);
                AllReviewResponsedto allReviewResponsedto2 = new AllReviewResponsedto(companyReviewResponseDto);
                return allReviewResponsedto2;
            default:
                log.info("hi!");
                break;
        }
        return null;
    }

    public List<ReviewMallResponseDto> companyAllReview(ReviewMRequestDto reviewMRequestDto, Pageable pageable) throws CustomException {
        //전체회원을 받아온다
        List<ReviewMallResponseDto> liveMemberListResult = reviewMRepository.findByAllCompanyReview(reviewMRequestDto, pageable);
        return liveMemberListResult;
    }
    public List<ReviewMallResponseDto> interviewAllReview(ReviewMRequestDto reviewMRequestDto, Pageable pageable) throws CustomException {
        //전체회원을 받아온다
        List<ReviewMallResponseDto> liveMemberListResult = reviewMRepository.findByAllInterviewReview(reviewMRequestDto, pageable);
        return liveMemberListResult;
    }
    public List<ReviewMallResponseDto> amtAllReview(ReviewMRequestDto reviewMRequestDto, Pageable pageable) throws CustomException {
        //전체회원을 받아온다
        List<ReviewMallResponseDto> liveMemberListResult = reviewMRepository.findByAllAmtReview(reviewMRequestDto, pageable);
        return liveMemberListResult;
    }

    public void update(ReviewStateUpdateRequestDto reviewStateUpdateRequestDto, UserPrincipal me, Long id,String type) {
        switch (type) {
            case "AMT":
                YearAmtReview amtReview = amtReviewRepository.findById(id).orElse(null);
                if (amtReview != null) {
                amtReview.setState(reviewStateUpdateRequestDto.getState());
                amtReview.setApprTxt(reviewStateUpdateRequestDto.getAdminTxt());
                amtReview.setApprId(me.getUserId());
                amtReview.setApprDt(ZonedDateTime.now());
                amtReviewRepository.save(amtReview);
            }
            case "INTERVIEW":
                InterviewReview interviewReview = interviewReviewRepository.findById(id).orElse(null);
                if (interviewReview != null) {
                    interviewReview.setState(reviewStateUpdateRequestDto.getState());
                    interviewReview.setApprTxt(reviewStateUpdateRequestDto.getAdminTxt());
                    interviewReview.setApprId(me.getUserId());
                    interviewReview.setApprDt(ZonedDateTime.now());
                    interviewReviewRepository.save(interviewReview);
                }
            case "COMPANY":
                CompanyReview companyReview = companyReviewRepository.findById(id).orElse(null);
                if (companyReview != null) {
                    companyReview.setState(reviewStateUpdateRequestDto.getState());
                    companyReview.setApprTxt(reviewStateUpdateRequestDto.getAdminTxt());
                    companyReview.setApprId(me.getUserId());
                    companyReview.setApprDt(ZonedDateTime.now());
                    companyReviewRepository.save(companyReview);
                }
            default:
                log.info("hi!");
                break;
        }
    }
}
