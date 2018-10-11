package com.itsm.pub.courses.patients.front.menu.state;

import com.itsm.pub.courses.patients.common.entities.State;
import com.itsm.pub.courses.patients.front.menu.IMenuItem;
import com.itsm.pub.courses.patients.front.repository.domain.impl.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@StateMenuItem
public class StateByIdMenuItem implements IMenuItem {

    private final StateRepository stateRepository;

    @Autowired
    public StateByIdMenuItem(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public String getTitle() {
        return "Print random state";
    }

    @Override
    public int doAction() {
        List<State> all = stateRepository.findAll();
        int randomIndex = new Random().nextInt(all.size());
        System.out.println(all.get(randomIndex));
        return 0;
    }
}
