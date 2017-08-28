package com.epam.zakharchenya.task.model.action.command;

import com.epam.zakharchenya.task.model.Constants;
import com.epam.zakharchenya.task.model.action.Command;
import com.epam.zakharchenya.task.model.entity.Visitor;
import com.epam.zakharchenya.task.model.exception.CommandException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** Class serves to process the corresponding command: Change current locale
 *
 * @author Vadim Zakharchenya
 * @version 1.0
 */
@Service
public class LocaleCommand implements Command {
    private static final String LOCALE_ATTRIBUTE="language";
    private static final String LOCALE_ATTR="locale";

    /**Processing command logic
     *
     * @param request from client
     * @param response for client
     * @return path for jsp file to be forwarded to
     * @throws CommandException command layer exception
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String locale = request.getParameter(LOCALE_ATTRIBUTE);
        HttpSession session = request.getSession();
        Visitor visitor = (Visitor)request.getSession().getAttribute(Constants.VISITOR_KEY);
        session.setAttribute(LOCALE_ATTR, locale);
        request.getSession().setAttribute(Constants.STATE_KEY, Constants.State.FORWARD);
        return request.getContextPath() + visitor.getCurrentPage();
    }
}
