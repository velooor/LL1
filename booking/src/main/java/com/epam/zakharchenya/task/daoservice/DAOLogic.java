package com.epam.zakharchenya.task.daoservice;

import com.epam.zakharchenya.task.dao.EntityDAO;
import com.epam.zakharchenya.task.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Vadzim_Zakharchenya on 8/7/2017.
 */
public abstract class DAOLogic {
    @Autowired
    protected static EntityDAO entityDAO;

    public static void openDAO(){
        HibernateUtil.openSessionWithTransaction(entityDAO);
    }
    public static void closeDAO(){
        HibernateUtil.closeSessionWithTransaction(entityDAO);
    }

}
