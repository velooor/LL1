package com.epam.zakharchenya.task.model.daoservice;

import com.epam.zakharchenya.task.model.dao.RoomDAO;
import com.epam.zakharchenya.task.model.entity.Room;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class BookingLogic extends DAOLogic {

    public BookingLogic() {
        entityDAO = new RoomDAO();
    }

    public ArrayList<Room> loadAll(){
        return entityDAO.loadAll();
    }

    public Room loadById(int roomId){
        return (Room)entityDAO.loadById(roomId);
    }

    public void update(Room room){
        entityDAO.update(room);
    }

    public void save(Room room){
        entityDAO.save(room);
    }

    public void addRoom(){
        Room room = new Room();
        room.setStartDate(Timestamp.valueOf(LocalDateTime.now().minusDays(1)));
        room.setEndDate(Timestamp.valueOf(LocalDateTime.now().minusDays(1)));
        save(room);
    }
}

