package com.twodollar.modules.account.infra;

import com.twodollar.modules.account.domain.Account;
import com.twodollar.modules.account.domain.enums.AuthProvider;
import com.twodollar.modules.account.web.dto.request.AccountSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AccountRepositoryExtension {

    Page<Account> accounts(AccountSearchRequest accountSearchRequest, Pageable pageable);

    Account deleteAccount(Long id);

    Optional<Account> findByPlainUserId3(String userId);
    Optional<Account> findByEncodedUserId2(String userId);

    @Deprecated
    Optional<Account> findByPlainUserId(String userId, AuthProvider snsType);
    @Deprecated
    Optional<Account> findByPlainUserId2(String userId);
    @Deprecated
    Optional<Account> findByEncodedUserId(String userId);

}
