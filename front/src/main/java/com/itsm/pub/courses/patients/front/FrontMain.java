package com.itsm.pub.courses.patients.front;

import com.itsm.pub.courses.patients.front.config.FrontConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FrontMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FrontConfig.class);
        context.registerShutdownHook();

        Runnable mainMenu = (Runnable) context.getBean("mainMenu");
        mainMenu.run();
    }
}
