package com.epam.zakharchenya.task.util;

import com.epam.zakharchenya.task.dao.EntityDAO;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static Logger logger = LogManager.getLogger(HibernateUtil.class);
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return ContextHolder.getApplicationContext().getBean(Configuration.class).configure().buildSessionFactory();
        } catch (Throwable ex) {
            logger.log(Level.ERROR, "Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session openSessionWithTransaction(EntityDAO entityDAO){
        entityDAO.setSession(HibernateUtil.getSessionFactory().openSession());
        entityDAO.setTransaction(entityDAO.getSession().beginTransaction());
        return entityDAO.getSession();
    }

    public static void closeSessionWithTransaction(EntityDAO entityDAO) {
        entityDAO.getTransaction().commit();
        entityDAO.getSession().close();
    }
}
