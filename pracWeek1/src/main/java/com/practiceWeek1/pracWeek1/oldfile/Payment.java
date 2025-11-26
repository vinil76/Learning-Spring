package com.practiceWeek1.pracWeek1.oldfile;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Payment {

    public void pay(){
        System.out.println("Paying....");
    }

    @PostConstruct
    public void afterinitial(){
        System.out.println("before paying");
    }

    @PreDestroy
    public void predestroy(){
        System.out.println("After payment is done");
    }
}
