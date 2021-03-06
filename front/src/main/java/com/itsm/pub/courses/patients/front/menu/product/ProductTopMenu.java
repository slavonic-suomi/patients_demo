package com.itsm.pub.courses.patients.front.menu.product;

import com.itsm.pub.courses.patients.front.menu.AbstractMenu;
import com.itsm.pub.courses.patients.front.menu.IMenuItem;
import com.itsm.pub.courses.patients.front.menu.TopLevelMenu;
import com.itsm.pub.courses.patients.front.menu.patient.PatientMenuItem;
import com.itsm.pub.courses.patients.front.menu.util.MenuHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@TopLevelMenu
public class ProductTopMenu extends AbstractMenu implements IMenuItem {

    @Autowired
    public ProductTopMenu(@ProductMenuItem List<IMenuItem> topLevelItems, MenuHelper menuHelper) {
        super(topLevelItems, menuHelper);
    }

    @Override
    public String getTitle() {
        return "Product management";
    }

    @Override
    public int doAction() {
        run();
        return 0;
    }
}
