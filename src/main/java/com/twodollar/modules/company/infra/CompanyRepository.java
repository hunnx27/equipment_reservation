package com.twodollar.modules.company.infra;


import com.twodollar.modules.company.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long>,
        CompanyRepositoryExtension {
}
