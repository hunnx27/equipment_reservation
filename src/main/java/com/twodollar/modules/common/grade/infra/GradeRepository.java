package com.twodollar.modules.common.grade.infra;

import com.twodollar.modules.common.grade.domain.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long>,GradeRepositoryExtension {
    Grade findByGrade(String code);
}
