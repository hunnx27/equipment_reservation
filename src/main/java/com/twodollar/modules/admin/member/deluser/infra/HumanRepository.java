package com.twodollar.modules.admin.member.deluser.infra;

import com.twodollar.modules.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanRepository extends JpaRepository<Account, Long>, HumanRepositoryExtension {
}
