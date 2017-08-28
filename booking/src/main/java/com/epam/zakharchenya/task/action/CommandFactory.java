package com.epam.zakharchenya.task.action;

import com.epam.zakharchenya.task.action.command.*;
import com.epam.zakharchenya.task.util.ContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.epam.zakharchenya.task.action.CommandType.*;

/**
 * Class, which interpret command param from client
 * and return corresponding command object
 *
 * @author Vadim Zakharchenya
 * @version 1.0
 */
@Service
public class CommandFactory {
    /**Interpret command param from client
     * and return corresponding class
     *
     * @param response for client
     * @param request from client
     * @return command object
     */
    public Command getCurrentCommand(HttpServletRequest request, HttpServletResponse response) {
        String command = request.getParameter(COMMAND_PARAM);
        if (request.getAttribute(COMMAND_PARAM) != null) {
            command = (String) request.getAttribute(COMMAND_PARAM);
        }
        switch (command) {
            case LOCALE:
                return ContextHolder.getApplicationContext().getBean(LocaleCommand.class);
            case NULL:
                return ContextHolder.getApplicationContext().getBean(ErrorCommand.class);
            case SEARCH:
                return ContextHolder.getApplicationContext().getBean(SearchCommand.class);
            case QUERY:
                return ContextHolder.getApplicationContext().getBean(QueryCommand.class);
            case SEARCH_ID:
                return ContextHolder.getApplicationContext().getBean(SearchIDCommand.class);
            case ADD_ROOM:
                return ContextHolder.getApplicationContext().getBean(AddRoomCommand.class);
        }
        return null;
    }
}

