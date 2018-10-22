package com.itsm.pub.courses.patients.front.repository.domain.impl;

import com.itsm.pub.courses.patients.common.entities.Patient;
import com.itsm.pub.courses.patients.front.context.Auditable;
import com.itsm.pub.courses.patients.front.repository.AbstractCrudRepository;
import com.itsm.pub.courses.patients.front.repository.ICrudRepository;
import com.itsm.pub.courses.patients.front.repository.domain.IPatientRepository;
import com.itsm.pub.courses.patients.front.repository.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class PatientRepository extends AbstractCrudRepository<Patient>
        implements IPatientRepository {

    @Autowired
    protected PatientRepository(EntityMapper<Patient> mapper, JdbcTemplate jdbcTemplate) {
        super(mapper, jdbcTemplate);
    }

    @Override
    protected Class<Patient> getEntityClass() {
        return Patient.class;
    }

    @Override
    @Auditable
    @Transactional
    public void create(Patient patient) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement st = con.prepareStatement(
                    "insert into patient (phone, state_id) values (?, ?) ",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, patient.getPhone());
            st.setInt(2, patient.getState().getId());
            return st;
        }, holder);

        int id = holder.getKey().intValue();
        patient.setId(id);
    }

    @Override
    public void update(Patient patient) {
        jdbcTemplate.update("update patient set phone = ?, state_id = ? where id = ?",
                patient.getPhone(),
                patient.getState().getId(),
                patient.getId()
        );
    }

    @Override
    public Patient findByPhone(String phone) {
        try {
            return jdbcTemplate.queryForObject("select * from patient where phone = ?", mapper, phone);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
