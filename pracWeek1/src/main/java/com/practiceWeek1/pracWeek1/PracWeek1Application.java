package com.practiceWeek1.pracWeek1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracWeek1Application implements CommandLineRunner {

//    @Autowired
//    Apple apple1;
//
//    @Autowired
//    Apple apple2;

//      @Autowired
//      Payment paymentObj1;
//
//      @Autowired
//      Payment paymentObj2;

    //@Autowired
    //final NotificationService notificationServiceObj;

//    public PracWeek1Application(/*@Qualifier("emailNotif") */NotificationService notificationServiceObj){
//        this.notificationServiceObj = notificationServiceObj;
//    }


	public static void main(String[] args) {
		SpringApplication.run(PracWeek1Application.class, args);

//        Apple obj = new Apple();
//        obj.eatApple();




	}

    @Override
    public void run(String... args) throws Exception {
//        apple1.eatApple();
//        apple2.eatApple();
//        System.out.println(apple1.hashCode());
//        System.out.println(apple2.hashCode());


//        System.out.println(paymentObj1.hashCode());
//        System.out.println(paymentObj2.hashCode());
//
//
//        paymentObj1.pay();
//        paymentObj2.pay();

        //NotificationService notificationServiceObj = new EmailNotificationService();
       // notificationServiceObj.send("Hello");
    }




}

