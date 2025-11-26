package com.practiceWeek1.pracWeek1;


import com.practiceWeek1.pracWeek1.oldfile.Payment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean

    @Scope("prototype")
    Payment payment(){
        return new Payment();
    }
}
