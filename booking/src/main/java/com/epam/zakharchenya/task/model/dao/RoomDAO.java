package com.epam.zakharchenya.task.model.dao;

import com.epam.zakharchenya.task.model.daoservice.DAOLogic;
import com.epam.zakharchenya.task.model.entity.Room;
import com.epam.zakharchenya.task.model.entity.DatabaseEntity;
import com.epam.zakharchenya.task.model.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/** DAO class for room database entity.
 *
 * @author Vadim Zakharchenya
 * @version 1.0
 */
@Repository
public class RoomDAO extends EntityDAO{
    public RoomDAO() {
    }

    @Override
    public ArrayList<Room> loadAll() {
        DAOLogic.openDAO();
        return (ArrayList<Room>) session.createQuery("from Room ").list();
    }

    @Override
    public Room loadById(int roomId) {
        DAOLogic.openDAO();
        return (Room) session.get(Room.class, roomId);
    }

    @Override
    public void update(DatabaseEntity room) {
        DAOLogic.openDAO();
        session.update(room);
    }

    @Override
    public void save(DatabaseEntity room) {
        DAOLogic.openDAO();
        session.save(room);
    }
}
