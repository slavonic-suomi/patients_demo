package com.itsm.pub.courses.patients.web.controller;

import com.itsm.pub.courses.patients.common.entities.State;
import com.itsm.pub.courses.patients.web.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("state")
public class StateController {

    private final StateRepository stateRepository;

    @Autowired
    public StateController(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @RequestMapping("{id}")
    public State getState(@PathVariable("id") Integer id) {
        return stateRepository.findById(id).orElse(null);
    }

    @RequestMapping("/search/code/{code}")
    public State getState(@PathVariable("code") String code) {
        return stateRepository.findByCode(code);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Integer createState(@RequestBody State state) {
        stateRepository.save(state);
        return state.getId();
    }
}
