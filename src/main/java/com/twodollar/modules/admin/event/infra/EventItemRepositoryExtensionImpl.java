package com.twodollar.modules.admin.event.infra;

import com.twodollar.modules.account.domain.QAccount;
import com.twodollar.modules.admin.event.domain.QEvent;
import com.twodollar.modules.admin.event.domain.QEventItem;
import com.twodollar.modules.admin.notice.domain.Notice;
import com.twodollar.modules.common.pointHistory.domain.QPointHistory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;

public class EventItemRepositoryExtensionImpl extends QuerydslRepositorySupport implements
        EventItemRepositoryExtension {

    private final JPAQueryFactory qf;
    private final EntityManager em;

    public EventItemRepositoryExtensionImpl(JPAQueryFactory qf, EntityManager em) {
        super(Notice.class);
        this.qf = qf;
        this.em = em;
    }

}
