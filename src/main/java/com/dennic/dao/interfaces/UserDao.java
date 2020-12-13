package com.dennic.dao.interfaces;

import com.dennic.dao.DaoException;
import com.dennic.entity.User;
import com.dennic.dto.UserData;

public interface UserDao {
    User authentification (String login, String password) throws DaoException;

    boolean registration (UserData userData) throws DaoException;
}
