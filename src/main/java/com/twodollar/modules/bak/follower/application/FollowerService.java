package com.twodollar.modules.bak.follower.application;

import com.twodollar.common.web.ApiR;
import com.twodollar.common.web.dto.response.enums.Role;
import com.twodollar.modules.account.domain.Account;
import com.twodollar.modules.account.infra.AccountRepository;
import com.twodollar.modules.auth.web.dto.UserPrincipal;
import com.twodollar.modules.bak.company.application.util.AggregateCompany;
import com.twodollar.modules.bak.company.application.util.dto.EvaluationScore;
import com.twodollar.modules.bak.company.application.util.dto.UserScore;
import com.twodollar.modules.bak.company.domain.Company;
import com.twodollar.modules.bak.company.infra.CompanyRepository;
import com.twodollar.modules.bak.review.domain.CompanyReview;
import com.twodollar.modules.bak.review.infra.CompanyReviewRepository;
import com.twodollar.modules.bak.follower.domain.Follower;
import com.twodollar.modules.bak.follower.infra.FollowerRepository;
import com.twodollar.modules.bak.follower.web.dto.FollowerFindAccountResponseDto;
import com.twodollar.modules.bak.follower.web.dto.FollowerFindCompanyResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class FollowerService {
    private final FollowerRepository followerRepository;
    private final AccountRepository accountRepository;
    private final CompanyRepository companyRepository;
    private final CompanyReviewRepository companyReviewRepository;

    public ApiR<?> create(UserPrincipal me, Long id) {
        Account account = accountRepository.findById(me.getId()).orElse(null);
        Company company = companyRepository.findById(id).orElse(null);
        Follower follower = followerRepository.findById(id).orElse(null);
        Follower check = followerRepository.findByCompanyIdAndAccount_Id(id, me.getId());
        if(account.getRole().equals(Role.USER)) {
            if (check != null) {
                if (!check.getAccount().getId().equals(me.getId())) {
                    if (account != null && company != null) {
                        if (follower == null) {
                            follower = Follower.builder()
                                    .createdAt(ZonedDateTime.now())
                                    .gubnCode(company.getInterestCompany())
                                    .account(account)
                                    .company(company)
                                    .build();
                            followerRepository.save(follower);
                            return ApiR.createSuccess(HttpStatus.OK);
                        } else {
                            return null;
                        }
                    }
                }
            } else {
                if (account != null && company != null) {
                    if (follower == null) {
                        follower = Follower.builder()
                                .createdAt(ZonedDateTime.now())
                                .gubnCode(company.getInterestCompany())
                                .account(account)
                                .company(company)
                                .build();
                        followerRepository.save(follower);
                        return ApiR.createSuccess(HttpStatus.OK);
                    } else {
                        return null;
                    }
                }
            }
        }
        return ApiR.createError(HttpStatus.NOT_FOUND.getReasonPhrase());
    }

    public List<FollowerFindAccountResponseDto> findAccountFollower(UserPrincipal me, Long id) {
        List<Follower> check = followerRepository.findByAccount_Id(id);
        List<FollowerFindAccountResponseDto> responseDtos;
        responseDtos= check.stream().map(res -> {
            List<CompanyReview> reviews = companyReviewRepository.listCompanyReviewByCompanyId(res.getCompany().getId());
            AggregateCompany agg = reviews.stream().collect(AggregateCompany::new, AggregateCompany::add, AggregateCompany::merge);
            EvaluationScore escore = new EvaluationScore(res.getCompany());
            UserScore uscore = new UserScore(agg);
            long evalTot = escore.getScoreTot();
            long userTot = uscore.getScoreTot();
            int avgCnt = 0;
            if (evalTot > 0) avgCnt++;
            if (userTot > 0) avgCnt++;
            Long jipyoScore = avgCnt != 0 ? (evalTot + userTot) / avgCnt : 0;
            FollowerFindAccountResponseDto followerFindResponseDto = new FollowerFindAccountResponseDto(res);
            followerFindResponseDto.setJipyo(jipyoScore);
            return followerFindResponseDto;
        }).collect(Collectors.toList());
        return responseDtos;
    }
    public List<FollowerFindCompanyResponseDto> findCompanyFollower(UserPrincipal me, Long id) {
        List<Follower> check = followerRepository.findByCompany_Id(id);
        List<FollowerFindCompanyResponseDto> result;
        result = check.stream().map(res->{
            FollowerFindCompanyResponseDto followerFindCompanyResponseDto = new FollowerFindCompanyResponseDto(res);
            return followerFindCompanyResponseDto;
        }).collect(Collectors.toList());
        return result;
    }
}
