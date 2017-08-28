package com.epam.zakharchenya.task.model.logic;

import com.epam.zakharchenya.task.model.daoservice.BookingLogic;
import com.epam.zakharchenya.task.model.entity.Room;
import com.epam.zakharchenya.task.model.util.ContextHolder;
import com.google.gson.JsonArray;

import java.util.ArrayList;

public class SearchCommandLogic {
    public static JsonArray process(){
        BookingLogic bookingLogic = ContextHolder.getApplicationContext().getBean(BookingLogic.class);
        ArrayList<Room> rooms = bookingLogic.loadAll();
        BookingLogic.closeDAO();
        return JSONConversionLogic.convertToJSON(rooms);
    }
    public static JsonArray process(int id){
        BookingLogic bookingLogic = ContextHolder.getApplicationContext().getBean(BookingLogic.class);
        Room room = bookingLogic.loadById(id);
        BookingLogic.closeDAO();
        return JSONConversionLogic.convertToJSON(room);
    }
}
