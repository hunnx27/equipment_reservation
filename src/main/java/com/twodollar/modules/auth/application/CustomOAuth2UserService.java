package com.twodollar.modules.auth.application;

import com.twodollar.common.web.dto.response.enums.Role;
import com.twodollar.modules.account.application.AccountService;
import com.twodollar.modules.account.domain.Account;
import com.twodollar.modules.account.domain.enums.AuthProvider;
import com.twodollar.modules.account.infra.AccountRepository;
import com.twodollar.modules.auth.application.util.OAuth2UserInfoFactory;
import com.twodollar.modules.auth.web.dto.UserPrincipal;
import com.twodollar.modules.auth.web.dto.oauth.OAuth2UserInfo;
import com.twodollar.modules.common.pointHistory.domain.enums.PointTable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

/* OAuth2 인증 제거 */
@Deprecated

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
//    @Autowired
//    private AccountRepository accountRepository;
//    private final AccountService accountService;
//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
//        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
//        try {
//            return processOAuth2User(oAuth2UserRequest, oAuth2User);
//        } catch (AuthenticationException ex) {
//            throw ex;
//        } catch (Exception ex) {
//            // Throwing an instance of AuthenticationException will trigger the OAuth2AuthenticationFailureHandler
//            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
//        }
//    }
//    private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) throws ParseException {
//        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(oAuth2UserRequest.getClientRegistration().getRegistrationId(), oAuth2User.getAttributes());
//
//        if(ObjectUtils.isEmpty(oAuth2UserInfo.getId())) {
//            throw new OAuth2AuthenticationException("Email not found from OAuth2 provider");
//        }
//        AuthProvider snsType = AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId());
//        //Optional<Account> userOptional = accountRepository.findByPlainUserId(oAuth2UserInfo.getId(), snsType);
//        //Optional<Account> userOptional = accountRepository.findByPlainUserId2(oAuth2UserInfo.getId());
//        Optional<Account> userOptional = accountRepository.findByPlainUserId3(oAuth2UserInfo.getId());
//        Account account;
//        if(userOptional.isPresent()) {
//            account = userOptional.get();
//            account = updateExistingUser(account, oAuth2UserInfo);
//            account.setLastedAt(ZonedDateTime.now());
//            accountRepository.save(account);
//        } else {
//            // 신규 유저면 등록(Step, ID저장안함.)
//            account = getNewUser(oAuth2UserRequest, oAuth2UserInfo);
//
//        }
//        if (account.getLastedAt() != null) {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//            String temp1 = account.getLastedAt().format(formatter);
//            String temp2 = ZonedDateTime.now().format(formatter);
//            Date tempResult = new SimpleDateFormat("yyyy/MM/dd").parse(temp1);
//            Date tempResult2 = new SimpleDateFormat("yyyy/MM/dd").parse(temp2);
//            long diffSec = (tempResult2.getTime()-tempResult.getTime())/1000;
//            if(diffSec>=60*60*24){
//                accountService.createMyPointHistories(account, PointTable.LOGIN_ATTEND);
//            }
//        }
//
//        return UserPrincipal.create(account, oAuth2User.getAttributes());
//    }
//    private Account getNewUser(OAuth2UserRequest oAuth2UserRequest, OAuth2UserInfo oAuth2UserInfo) {
//
//        Account user = Account.builder()
//                .provider(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()))
//                .userId(oAuth2UserInfo.getId())
//                //.gubn(Gubn.TEACHER)
//                .role(Role.USER)
//                .build();
//        //return accountRepository.save(user);
//        return user;
//    }
//
//    // 기존 USER -> OAuth2 방식으로 덮어쓰기..
//    private Account updateExistingUser(Account existingUser, OAuth2UserInfo oAuth2UserInfo) {
//        existingUser.update(oAuth2UserInfo.getrRegistrationId());
//        return accountRepository.save(existingUser);
//    }

}
