package com.epam.zakharchenya.task.dao;

import com.epam.zakharchenya.task.daoservice.DAOLogic;
import com.epam.zakharchenya.task.entity.Room;
import com.epam.zakharchenya.task.entity.DatabaseEntity;
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
