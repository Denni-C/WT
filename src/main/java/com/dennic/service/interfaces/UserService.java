package com.dennic.service.interfaces;

import com.dennic.entity.User;
import com.dennic.dto.UserData;
import com.dennic.service.ServiceException;

public interface UserService {
    User authorization (String login, String password) throws ServiceException;

    boolean registration (UserData user) throws ServiceException;
}
