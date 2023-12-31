package com.twodollar.modules.bak.review.application;

import com.twodollar.common.exception.CustomException;
import com.twodollar.common.util.dto.AttachDto;
import com.twodollar.common.web.dto.response.enums.ErrorCode;
import com.twodollar.modules.account.application.AccountService;
import com.twodollar.modules.account.domain.Account;
import com.twodollar.modules.common.pointHistory.domain.enums.PointTable;
import com.twodollar.modules.bak.review.infra.CompanyReviewRepository;
import com.twodollar.modules.auth.web.dto.UserPrincipal;
import com.twodollar.common.util.FileUtil;
import com.twodollar.modules.common.address.infra.AddressRepository;
import com.twodollar.modules.common.address.infra.dto.DistinctAddressResponse;
import com.twodollar.modules.bak.company.domain.Company;
import com.twodollar.modules.bak.company.infra.CompanyRepository;
import com.twodollar.modules.bak.review.domain.CompanyReview;
import com.twodollar.modules.bak.company.web.dto.reponse.CompanyReviewListResponseDto;
import com.twodollar.modules.bak.review.web.dto.CompanyReviewDetailResponseDto;
import com.twodollar.modules.bak.review.web.dto.CompanyReviewRequestDto;
import com.twodollar.modules.bak.review.web.dto.FindEstaRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CompanyReviewService {
    private final CompanyReviewRepository companyReviewRepository;
    private final CompanyRepository companyRepository;
    private final AccountService accountService;
    private final AddressRepository addressRepository;
    private final FileUtil fileUtil;

    public CompanyReview create(CompanyReviewRequestDto companyReviewRequestDto, UserPrincipal me ,List<MultipartFile> files) {
        Long companyId = companyReviewRequestDto.getCompanyId();
        Account account = accountService.findOne(me.getId());
        Company company = companyRepository.findById(companyId).orElse(null);
        CompanyReview companyReview = new CompanyReview(companyReviewRequestDto, company, account);
        CompanyReview saved = companyReviewRepository.save(companyReview);
        accountService.createMyPointHistories(account, PointTable.REVIEW_REGIST);
        // Image File Upload
        if (files != null && files.size() > 0) {
            try {
                List<AttachDto> rs = fileUtil.uploadFiles(files, saved.getId());
                saved.setImages(rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return companyReview;
    }

    public List<CompanyReviewListResponseDto> companyReviewList(FindEstaRequestDto findEstaRequestDto,Pageable pageable) {
        List<CompanyReviewListResponseDto> list = companyReviewRepository.listCompanyReview(findEstaRequestDto,pageable);
        List<CompanyReviewListResponseDto> array = list.stream().map(res -> {
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

    public CompanyReviewDetailResponseDto companyReviewDetail(Long id,Long companyId) {
        CompanyReview companyReview = companyReviewRepository.findById(id).orElse(null);
        if(!(companyReview != null ? companyReview.getCompany().getId() : null).equals(companyId)){
            throw new CustomException(ErrorCode.NOT_FOUND);
        }
        CompanyReviewDetailResponseDto result = new CompanyReviewDetailResponseDto(companyReview);
        return result;
    }

}