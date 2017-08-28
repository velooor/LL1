package com.epam.zakharchenya.task.action.command;

import com.epam.zakharchenya.task.action.Command;
import com.epam.zakharchenya.task.action.CommandFactory;
import com.epam.zakharchenya.task.exception.CommandException;
import com.epam.zakharchenya.task.factory.ActionFactory;
import com.epam.zakharchenya.task.util.ContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Class serves to process the corresponding command: Process query request
 *
 * @author Vadim Zakharchenya
 * @version 1.0
 */
@Service
public class QueryCommand implements Command {
    private static final String SEARCH_QUERY = "searchQuery";

    /**Processing command logic
     *
     * @param request from client
     * @param response for client
     * @return path for jsp file to be forwarded to or JSON array
     * @throws CommandException command layer exception
     */
    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String searchQuery = "/" + request.getParameter(SEARCH_QUERY);
        ActionFactory actionFactory = ContextHolder.getApplicationContext().getBean(ActionFactory.class);
        actionFactory.getCurrentCommand(request, response, searchQuery);

        return new CommandFactory().getCurrentCommand(request, response).execute(request, response);
    }
}