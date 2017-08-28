package com.epam.zakharchenya.task.model.logic;

import com.epam.zakharchenya.task.model.action.command.ErrorCommand;
import com.epam.zakharchenya.task.model.entity.Room;
import com.epam.zakharchenya.task.model.util.ContextHolder;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.util.ArrayList;

/**
 * Created by Vadzim_Zakharchenya on 8/7/2017.
 */

public class JSONConversionLogic{
    public static JsonArray convertToJSON(ArrayList<Room> rooms){
        return ContextHolder.getApplicationContext().getBean(Gson.class).toJsonTree(rooms).getAsJsonArray();
    }
    public static JsonArray convertToJSON(Room room){
        ArrayList<Room> rooms = new ArrayList<Room>();
        rooms.add(room);
        return ContextHolder.getApplicationContext().getBean(Gson.class).toJsonTree(rooms).getAsJsonArray();
    }
}
