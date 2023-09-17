package com.twodollar.modules.account.web.dto;

import com.twodollar.modules.account.web.dto.request.AccountUpdateRequest;
import com.twodollar.modules.account.domain.Account;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AccountConverter {

    void updateAccountFromDto(AccountUpdateRequest accountUpdateRequest,
        @MappingTarget Account account);

}
