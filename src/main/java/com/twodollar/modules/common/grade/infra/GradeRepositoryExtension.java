package com.twodollar.modules.common.grade.infra;

import com.twodollar.modules.account.domain.Account;
import com.twodollar.modules.common.grade.domain.Grade;

public interface GradeRepositoryExtension {
   Grade pointCheck(Account account);
}
