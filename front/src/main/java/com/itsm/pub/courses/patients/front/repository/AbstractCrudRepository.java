package com.itsm.pub.courses.patients.front.repository;

import com.itsm.pub.courses.patients.common.entities.IEntity;
import com.itsm.pub.courses.patients.front.repository.mapper.EntityMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractCrudRepository<E extends IEntity>
        extends AbstractListRepository<E>
        implements ICrudRepository<E> {

    public AbstractCrudRepository(EntityMapper<E> mapper, JdbcTemplate jdbcTemplate) {
        super(mapper, jdbcTemplate);
    }


    @Override
    public void delete(E e) {
        jdbcTemplate.update("delete  from " + mapper.getTableName() +
                " where id = ?", e.getId());
    }
}
