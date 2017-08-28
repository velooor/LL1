package com.epam.zakharchenya.task.controller;

import com.epam.zakharchenya.task.Constants;
import com.epam.zakharchenya.task.action.CommandFactory;
import com.epam.zakharchenya.task.exception.CommandException;
import com.epam.zakharchenya.task.factory.ActionFactory;
import com.epam.zakharchenya.task.manager.ConfigurationManager;
import com.epam.zakharchenya.task.util.ContextHolder;
import com.google.gson.JsonArray;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

import static com.epam.zakharchenya.task.Constants.PAGE_ERROR;
import static com.epam.zakharchenya.task.Constants.STATE_KEY;

@WebServlet(name = "WebServlet", urlPatterns = {"/main/*"})
@MultipartConfig(maxFileSize = 52428800, maxRequestSize = 52428800)
public class Controller extends HttpServlet {

    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public void destroy() {
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContextHolder.getApplicationContext().getBean(ActionFactory.class).getCurrentCommand(request, response, null);
        Object result = null;
        try{
            result = ContextHolder.getApplicationContext().getBean(CommandFactory.class).getCurrentCommand(request, response).execute(request, response);
        } catch (CommandException ex){
            System.out.println(ex);
        }
        if (result != null) {
            Constants.State state = (Constants.State) request.getSession().getAttribute(STATE_KEY);

            switch (state) {
                case RESPONSE:
                    response.getOutputStream().write(Base64.getDecoder().decode((String) result));
                    break;
                case AJAX:
                    try {
                        JsonArray jsonArray = (JsonArray) result;
                        response.setContentType("application/json");
                        response.setHeader("Cache-Control", "no-cache");
                        response.getWriter().println(jsonArray);
                    } catch (IOException ex) {
                        System.out.println("AJAX JsonException");
                    }
                    break;
                case FORWARD:
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher((String) result);
                    dispatcher.forward(request, response);
                    break;
                default:
                    dispatcher = getServletContext().getRequestDispatcher((String) result);
                    dispatcher.forward(request, response);
                    break;
            }
        } else {
            response.sendRedirect(request.getContextPath() + ConfigurationManager.getProperty(PAGE_ERROR));
        }

    }
}