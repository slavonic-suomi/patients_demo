package com.itsm.pub.courses.patients.front.repository.domain.impl;

import com.itsm.pub.courses.patients.common.entities.State;
import com.itsm.pub.courses.patients.front.repository.AbstractListRepository;
import com.itsm.pub.courses.patients.front.repository.domain.IStateRepository;
import com.itsm.pub.courses.patients.front.repository.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class StateRepository extends AbstractListRepository<State> implements IStateRepository {

    @Autowired
    protected StateRepository(EntityMapper<State> mapper, JdbcTemplate jdbcTemplate) {
        super(mapper, jdbcTemplate);
    }

    @Override
    protected Class<State> getEntityClass() {
        return State.class;
    }

    @Override
    public State findByCode(String code) {
        return jdbcTemplate.queryForObject("select * from " + mapper.getTableName() + " where code = ? ", mapper, code);
    }
}
