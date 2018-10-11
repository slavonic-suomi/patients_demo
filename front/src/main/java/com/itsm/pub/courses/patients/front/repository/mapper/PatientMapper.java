package com.itsm.pub.courses.patients.front.repository.mapper;

import com.itsm.pub.courses.patients.common.entities.Patient;
import com.itsm.pub.courses.patients.common.entities.State;
import com.itsm.pub.courses.patients.front.repository.IListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PatientMapper implements EntityMapper<Patient> {

    private final IListRepository<State> stateRepository;

    @Autowired
    public PatientMapper(IListRepository<State> stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public String getTableName() {
        return "patient";
    }

    @Override
    public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String phone = rs.getString("phone");

        int stateId = rs.getInt("state_id");
        State state = stateRepository.find(stateId);

        return new Patient(id, phone, state);
    }
}
