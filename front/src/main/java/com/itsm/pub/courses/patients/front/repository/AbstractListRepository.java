package com.itsm.pub.courses.patients.front.repository;

import com.itsm.pub.courses.patients.common.entities.IEntity;
import com.itsm.pub.courses.patients.front.repository.mapper.EntityMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public abstract class AbstractListRepository<E extends IEntity> implements IListRepository<E> {
    protected final EntityMapper<E> mapper;
    protected final JdbcTemplate jdbcTemplate;

    protected AbstractListRepository(
            EntityMapper<E> mapper,
            JdbcTemplate jdbcTemplate
    ) {
        this.mapper = mapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<E> findAll() {
        return jdbcTemplate.query("select * from  " + mapper.getTableName(), mapper);
    }

    @Override
    public E find(Integer id) {
        List<E> result = jdbcTemplate.query("select * from " + mapper.getTableName() +" where id = ? ", new Object[]{id}, mapper);
        return result
                .stream()
                .findFirst()
                .orElse(null);
    }
}
