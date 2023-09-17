package com.twodollar.modules.admin.notice.infra;

import com.twodollar.modules.admin.notice.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository  extends JpaRepository<Notice, Long>, NoticeRepositoryExtension {
}
