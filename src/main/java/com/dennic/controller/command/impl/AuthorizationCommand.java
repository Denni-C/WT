package com.dennic.controller.command.impl;

import com.dennic.controller.command.Command;
import com.dennic.entity.Car;
import com.dennic.entity.User;
import com.dennic.dto.UserData;
import com.dennic.service.ServiceException;
import com.dennic.service.ServiceFactory;
import com.dennic.service.interfaces.RentService;
import com.dennic.service.interfaces.UserService;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class AuthorizationCommand implements Command {
    private static final String AUTH_JSP_PATH = "/WEB-INF/jsp/guests/login.jsp";
    private static final String CATALOG_JSP_PATH = "/WEB-INF/jsp/rent/car.jsp";

    private static final String PARAMETER_LOGIN = "login";
    private static final String PARAMETER_PASSWORD = "password";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login;
        String password;

        login = request.getParameter(PARAMETER_LOGIN);
        password = DigestUtils.shaHex(request.getParameter(PARAMETER_PASSWORD));

        UserService service = ServiceFactory.getInstance().getUserService();

        UserData userData = new UserData();

        String page;

        userData.setLogin(login);
        userData.setPassword(password);

        try {
            User user = service.authorization(login, password);

            request.setAttribute("userObject", user);
            RentService rentService = ServiceFactory.getInstance().getRentService();
            List<Car> cars = rentService.getCarList();
            request.setAttribute("cars", cars);
            page = CATALOG_JSP_PATH;
        } catch (ServiceException e) {
            request.setAttribute("error", "Error. Try again!");
            page = AUTH_JSP_PATH;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

}
