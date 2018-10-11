package com.itsm.pub.courses.patients.front.repository.mapper;

import com.itsm.pub.courses.patients.common.entities.AuditRecord;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AuditRecordMapper implements EntityMapper<AuditRecord> {
    @Override
    public String getTableName() {
        return "audit";
    }

    @Override
    public AuditRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
