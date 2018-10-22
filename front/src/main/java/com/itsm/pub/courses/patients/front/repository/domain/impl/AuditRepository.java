package com.itsm.pub.courses.patients.front.repository.domain.impl;

import com.itsm.pub.courses.patients.common.entities.AuditRecord;
import com.itsm.pub.courses.patients.front.repository.AbstractListRepository;
import com.itsm.pub.courses.patients.front.repository.domain.IAuditRepository;
import com.itsm.pub.courses.patients.front.repository.mapper.EntityMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

@Repository
public class AuditRepository
    extends AbstractListRepository<AuditRecord>
        implements IAuditRepository {

    protected AuditRepository(EntityMapper<AuditRecord> mapper, JdbcTemplate jdbcTemplate) {
        super(mapper, jdbcTemplate);
    }

    @Override
    protected Class<AuditRecord> getEntityClass() {
        return AuditRecord.class;
    }

    @Override
    @Transactional
    public void create(boolean success, String name, Object... params) {
        String data = Arrays.stream(params)
                .map(Object::toString)
                .collect(Collectors.joining(";"));

        data = name + " : " + data;

        jdbcTemplate.update(
            "insert into audit (data, date, success) " +
             " values (?,?,?) ", data, new Date(), success
        );


    }
}
