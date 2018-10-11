package com.itsm.pub.courses.patients.front.menu.patient;

import com.itsm.pub.courses.patients.front.menu.IMenuItem;
import org.springframework.stereotype.Component;

@Component
@PatientMenuItem
public class PatientUpdateMenuItem implements IMenuItem {
    @Override
    public String getTitle() {
        return "Update patient";
    }

    @Override
    public int doAction() {
        return 0;
    }

    @Override
    public int priority() {
        return 1;
    }
}
