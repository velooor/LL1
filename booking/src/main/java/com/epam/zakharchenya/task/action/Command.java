package com.epam.zakharchenya.task.action;

import com.epam.zakharchenya.task.exception.CommandException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Interface, that sets behaviour for all command classes
 *
 * @author Vadim Zakharchenya
 * @version 2.0
 */
@Service
public interface Command {
    /**Processing command logic
     *
     * @param request from client
     * @param response for client
     * @return path for jsp file / image, encoded to string / xml file as string / JSON data array to send to client
     * @throws CommandException command layer exception
     */
    Object execute(HttpServletRequest request, HttpServletResponse response) throws CommandException;
}

