package com.itsm.pub.courses.patients.front;

import com.itsm.pub.courses.patients.common.entities.Patient;
import com.itsm.pub.courses.patients.common.entities.State;
import com.itsm.pub.courses.patients.front.repository.domain.impl.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/state")
public class StateController {

    @Autowired
    private StateRepository stateRepository;

    @RequestMapping(value = "/getSomeState", method = RequestMethod.GET)
    @ResponseBody
    public State getRand() {
        return stateRepository.findAll().get(0);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addState(@RequestBody State state) {

    }

    @RequestMapping(value = "/{stateId}/addPatient", method = RequestMethod.POST)
    public void addPatientToState(
            @RequestBody Patient patient,
            @PathVariable("stateId") Integer stateId
            ) {

    }

}
