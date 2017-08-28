package com.epam.zakharchenya.task.model.dao;

import com.epam.zakharchenya.task.model.entity.DatabaseEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/** Super class for all DAO classes. Sets basic behaviour and properties.
 *
 * @author Vadim Zakharchenya
 * @version 1.0
 */
@Repository
public abstract class EntityDAO <T extends DatabaseEntity>  {
    /** Session for DB connection */
    protected Session session;

    /** Transaction for DB connection */
    protected Transaction transaction;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    /**
     * Loads all items from database
     * @return Array list with items
     */
    public abstract ArrayList<T> loadAll();

    /**
     * Loads items by id from database
     * @param id id of the item
     * @return found item
     */
    public abstract T loadById(int id);

    /**
     * Updates item at database
     * @param tt item to update
     */
    public abstract void update(T tt);

    /**
     * Saves he item from database
     * @param tt item to save
     */
    public abstract void save(T tt);
}
