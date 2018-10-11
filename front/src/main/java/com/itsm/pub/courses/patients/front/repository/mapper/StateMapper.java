package com.itsm.pub.courses.patients.front.repository.mapper;

import com.itsm.pub.courses.patients.common.entities.State;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class StateMapper implements EntityMapper<State> {
    
    @Override
    public State mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String code = rs.getString("code");
        String name = rs.getString("name");
        return new State(id, code, name);
    }

    @Override
    public String getTableName() {
        return "state";
    }
}
