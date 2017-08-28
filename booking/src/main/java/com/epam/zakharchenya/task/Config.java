package com.epam.zakharchenya.task;

import com.epam.zakharchenya.task.model.factory.ActionFactory;
import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.epam.zakharchenya.task")
public class Config {

    @Bean
    ActionFactory actionFactory(){
        return new ActionFactory();
    }
    @Bean
    Gson gson(){
        return new Gson();
    }
    @Bean
    org.hibernate.cfg.Configuration configuration(){
        return new org.hibernate.cfg.Configuration();
    }
}
