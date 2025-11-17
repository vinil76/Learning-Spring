package com.practiceWeek1.pracWeek1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracWeek1Application implements CommandLineRunner {

    @Autowired
    Apple orj;


	public static void main(String[] args) {
		SpringApplication.run(PracWeek1Application.class, args);

//        Apple obj = new Apple();
//        obj.eatApple();

	}

    @Override
    public void run(String... args) throws Exception {
        orj.eatApple();
    }



}

