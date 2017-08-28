package com.epam.zakharchenya.task.action.command;

import com.epam.zakharchenya.task.Constants;
import com.epam.zakharchenya.task.action.Command;
import com.epam.zakharchenya.task.exception.CommandException;
import com.epam.zakharchenya.task.manager.ConfigurationManager;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.epam.zakharchenya.task.Constants.PAGE_ERROR;

/** Class serves to process the corresponding command: Forward to error page
 *
 * @author Vadim Zakharchenya
 * @version 1.0
 */
@Service
public class ErrorCommand implements Command {
    /**Processing command logic
     *
     * @param request from client
     * @param response for client
     * @return path for jsp file to be forwarded to
     * @throws CommandException command layer exception
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        request.getSession().setAttribute(Constants.STATE_KEY, Constants.State.FORWARD);
        return ConfigurationManager.getProperty(PAGE_ERROR);
    }
}
