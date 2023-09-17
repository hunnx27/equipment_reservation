package com.twodollar.modules.admin.auth.infra;

import com.twodollar.modules.account.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminAuthRepository extends JpaRepository<Admin, Long>{
}
