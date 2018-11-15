package com.itsm.pub.courses.patients.web.repository;

import com.itsm.pub.courses.patients.common.entities.State;
import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends CrudRepository<State, Integer> {

    State findByCode(String code);
}
