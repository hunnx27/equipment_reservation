package com.twodollar.modules.admin.member.livemember.infra;

import com.twodollar.common.web.dto.response.enums.Gubn;
import com.twodollar.modules.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LiveMemberRepository extends JpaRepository<Account, Long> ,LiveMemberRepositoryExtension{
    List<Account> findAllByGubn(Gubn gubn);

}
