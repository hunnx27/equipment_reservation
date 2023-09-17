package com.twodollar.modules.review.application;

import com.twodollar.common.exception.CustomException;
import com.twodollar.common.web.dto.response.enums.ErrorCode;
import com.twodollar.modules.account.application.AccountService;
import com.twodollar.modules.account.domain.Account;
import com.twodollar.modules.common.pointHistory.domain.enums.PointTable;
import com.twodollar.modules.review.domain.InterviewReviewItem;
import com.twodollar.modules.review.infra.InterviewReviewRepository;
import com.twodollar.modules.auth.web.dto.UserPrincipal;
import com.twodollar.modules.common.address.infra.AddressRepository;
import com.twodollar.modules.common.address.infra.dto.DistinctAddressResponse;
import com.twodollar.modules.company.domain.Company;
import com.twodollar.modules.company.infra.CompanyRepository;
import com.twodollar.modules.review.domain.InterviewReview;
import com.twodollar.modules.review.infra.InterviewReviewItemRepository;
import com.twodollar.modules.company.web.dto.reponse.InterviewListResponseDto;
import com.twodollar.modules.review.web.dto.FindEstaRequestDto;
import com.twodollar.modules.review.web.dto.InterviewRequestDto;
import com.twodollar.modules.review.web.dto.InterviewReviewDetailResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class InterviewService {
    private final InterviewReviewRepository interviewReviewRepository;
    private final CompanyRepository companyRepository;
    private final AccountService accountService;
    private final AddressRepository addressRepository;
    private final InterviewReviewItemRepository interviewReviewItemRepository;

    public InterviewReview create(InterviewRequestDto interviewRequestDto, UserPrincipal me) {
        Long companyId = interviewRequestDto.getCompanyId();
        Account account = accountService.findOne(me.getId());
        Company company = companyRepository.findById(companyId).orElse(null);
        InterviewReview interviewReview = new InterviewReview(interviewRequestDto, company,account);
        InterviewReview mom = interviewReviewRepository.save(interviewReview);
        accountService.createMyPointHistories(account, PointTable.INTERVIEW_REGIST);
        List<InterviewRequestDto.Interview> interviews = interviewRequestDto.getInterviews();
        for(int i=0; i<interviews.size(); i++){
            //sava...
            InterviewRequestDto.Interview itv = interviews.get(i);
            InterviewReviewItem interviewReviewItem = new InterviewReviewItem(itv, mom);
            interviewReviewItemRepository.save(interviewReviewItem);
        }
        return interviewReview;
    }
    public List<InterviewListResponseDto> interviewReviewList(FindEstaRequestDto findEstaRequestDto, Pageable pageable) {
        List<InterviewListResponseDto> list =  interviewReviewRepository.ListInterview(findEstaRequestDto,pageable);
        List<InterviewListResponseDto> array = list.stream().map(res -> {
//           String q_1 =(interviewReviewItemRepository.getById(res.getId()).getInterviewQ());
//            res.setQ_1(q_1);
            List<DistinctAddressResponse> addressList = addressRepository.findDistinctBySigunguCode(res.zoneCode);
            if (addressList.size() > 0) {
                DistinctAddressResponse address = addressList.get(0);
                String mapsidogunguName = address.getSidoName() + " " + address.getSigunguName();
                res.setMapsidogunguName(mapsidogunguName);
            }
            return res;
        }).collect(Collectors.toList());
        return array;
    }
    public InterviewReviewDetailResponseDto interviewReviewDetail(Long id,Long companyId) {
        InterviewReview interviewReview = interviewReviewRepository.findById(id).orElse(null);
        if(!(interviewReview != null ? interviewReview.getCompany().getId() : null).equals(companyId)){
            throw new CustomException(ErrorCode.NOT_FOUND);
        }
        InterviewReviewDetailResponseDto result = new InterviewReviewDetailResponseDto(interviewReview);
        return result;
    }
}
