package com.epam.zakharchenya.task.action.command;

import com.epam.zakharchenya.task.Constants;
import com.epam.zakharchenya.task.action.Command;
import com.epam.zakharchenya.task.exception.CommandException;
import com.epam.zakharchenya.task.logic.SearchCommandLogic;
import com.google.gson.JsonArray;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.epam.zakharchenya.task.Constants.ROOM_ID;

/** Class serves to process the corresponding command: Find room by ID in database
 *
 * @author Vadim Zakharchenya
 * @version 1.0
 */
@Service
public class SearchIDCommand implements Command {

    /**Processing command logic
     *
     * @param request from client
     * @param response for client
     * @return JSON data array to send to client
     * @throws CommandException command layer exception
     */
    @Override
    public JsonArray execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        request.getSession().setAttribute(Constants.STATE_KEY, Constants.State.AJAX);
        int id = (int)request.getAttribute(ROOM_ID);

        return SearchCommandLogic.process(id);
    }
}
