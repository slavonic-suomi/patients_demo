package com.itsm.pub.courses.patients.front.repository.mapper;

import com.itsm.pub.courses.patients.common.entities.IEntity;
import org.springframework.jdbc.core.RowMapper;

public interface EntityMapper<E extends IEntity> extends RowMapper<E> {
    String getTableName();
}
