package com.practiceWeek1.pracWeek1.oldfile;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("singletion") Default
@Scope("prototype") //this will create multiple objects not same objects will be used.
public class Apple {


    void eatApple(){
        System.out.println("I am eating Apple");
    }

    @PostConstruct
    void callThisBeforeBeanisCreated(){
        System.out.println("Creating the apple before use");
    }

    @PreDestroy
    void callThisBeforeDestroy(){
        System.out.println("Destroying Bean");
    }
}
