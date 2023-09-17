package com.twodollar.modules.admin.faq.infra;

import com.twodollar.modules.admin.faq.domian.Faq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqRepository  extends JpaRepository<Faq, Long>, FaqRepositoryExtension {
}
