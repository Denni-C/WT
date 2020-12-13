package com.dennic.dao;

import com.dennic.dao.connection.ConnectionProvider;
import com.dennic.dao.impl.SqlRentDao;
import com.dennic.dao.impl.SqlUserDao;
import com.dennic.dao.interfaces.RentDao;
import com.dennic.dao.interfaces.UserDao;
import lombok.Getter;

@Getter
public class DaoFactory {
    @Getter
    private static DaoFactory instance;

    private static ConnectionProvider connectionProvider;

    private final UserDao userDao;
    private final RentDao rentDao;

    public static void init(ConnectionProvider connectionProvider) {
        DaoFactory.connectionProvider = connectionProvider;
        instance = new DaoFactory();
    }

    private DaoFactory() {
        userDao = new SqlUserDao();
        rentDao = new SqlRentDao(connectionProvider);
    }
}
