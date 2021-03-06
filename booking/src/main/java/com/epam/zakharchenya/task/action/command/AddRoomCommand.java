package com.epam.zakharchenya.task.action.command;

import com.epam.zakharchenya.task.Constants;
import com.epam.zakharchenya.task.action.Command;
import com.epam.zakharchenya.task.daoservice.BookingLogic;
import com.epam.zakharchenya.task.exception.CommandException;
import com.epam.zakharchenya.task.logic.SearchCommandLogic;
import com.epam.zakharchenya.task.util.ContextHolder;
import com.google.gson.JsonArray;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Class serves to process the corresponding command: Add room to database
 *
 * @author Vadim Zakharchenya
 * @version 1.0
 */
@Service
public class AddRoomCommand implements Command {
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

        BookingLogic bookingLogic = ContextHolder.getApplicationContext().getBean(BookingLogic.class);
        bookingLogic.addRoom();
        BookingLogic.closeDAO();

        return SearchCommandLogic.process();
    }
}
