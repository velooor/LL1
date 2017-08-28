package com.epam.zakharchenya.task.model.action.command;

import com.epam.zakharchenya.task.model.Constants;
import com.epam.zakharchenya.task.model.action.Command;
import com.epam.zakharchenya.task.model.entity.Visitor;
import com.epam.zakharchenya.task.model.exception.CommandException;
import com.epam.zakharchenya.task.model.logic.SearchCommandLogic;
import com.google.gson.JsonArray;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** Class serves to process the corresponding command: Find all rooms in database
 *
 * @author Vadim Zakharchenya
 * @version 1.0
 */
@Service
public class SearchCommand implements Command {

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

        return SearchCommandLogic.process();
    }
}
