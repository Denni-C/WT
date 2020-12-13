package com.dennic.service.impl;

import com.dennic.dao.DaoException;
import com.dennic.dao.DaoFactory;
import com.dennic.dao.interfaces.UserDao;
import com.dennic.entity.User;
import com.dennic.dto.UserData;
import com.dennic.service.ServiceException;
import com.dennic.service.interfaces.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User authorization(String login, String password) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        UserDao userDAO = daoFactory.getUserDao();

        try {
            return userDAO.authentification(login, password);
        }catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean registration(UserData user) throws ServiceException {
        DaoFactory daoProvider = DaoFactory.getInstance();
        UserDao userDAO = daoProvider.getUserDao();

        try {
            return userDAO.registration(user);
        }catch (DaoException e){
            throw new ServiceException(e);
        }
    }
}
