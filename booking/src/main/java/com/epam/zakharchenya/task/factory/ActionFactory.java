package com.epam.zakharchenya.task.factory;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.epam.zakharchenya.task.Constants.ROOM_ID;
import static com.epam.zakharchenya.task.action.CommandType.*;

@Service
public class ActionFactory {
    private String uri;
    private static final String SHOW_ALL_ROOMS = "/main/rooms";
    private static final String SHOW_ROOMS_BY_ID = "/main/room/[1-9]+[0-9]*";

    public boolean getCurrentCommand(HttpServletRequest request, HttpServletResponse response, String searchQuery) {
        if (searchQuery != null) {
            uri = searchQuery;
        } else {
            uri = request.getRequestURI();
        }
        if (uri.matches(SHOW_ALL_ROOMS)) {
            if(request.getMethod().equalsIgnoreCase("get")){
                request.setAttribute(COMMAND_PARAM, SEARCH);
            } else if(request.getMethod().equalsIgnoreCase("post")){
                request.setAttribute(COMMAND_PARAM, ADD_ROOM);
            }
            return true;
        } else if(uri.matches(SHOW_ROOMS_BY_ID)){

            if(request.getMethod().equalsIgnoreCase("get")){
                request.setAttribute(COMMAND_PARAM, SEARCH_ID);
                int id = Integer.valueOf(uri.substring(11));
                request.setAttribute(ROOM_ID, id);
            } else if(request.getMethod().equalsIgnoreCase("post")){
                request.setAttribute(COMMAND_PARAM, ADD_ROOM);
            }
            return true;
        }
        return false;
    }
}
