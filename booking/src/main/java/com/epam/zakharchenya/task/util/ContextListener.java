package com.epam.zakharchenya.task.util;

import com.epam.zakharchenya.task.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //ContextHolder contextHolder = new ContextHolder();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        ContextHolder.setApplicationContext(applicationContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}