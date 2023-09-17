package com.twodollar.modules.bak.company.infra;


import com.twodollar.modules.bak.company.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long>,
        CompanyRepositoryExtension {
}
