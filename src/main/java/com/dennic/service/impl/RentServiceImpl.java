package com.dennic.service.impl;

import com.dennic.dao.DaoException;
import com.dennic.dao.DaoFactory;
import com.dennic.dao.connection.ConnectionProviderException;
import com.dennic.dto.RentCarStruct;
import com.dennic.entity.Car;
import com.dennic.service.ServiceException;
import com.dennic.service.interfaces.RentService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentServiceImpl implements RentService {
    @Override
    public void rentACar(RentCarStruct rentCarStruct) throws ServiceException {
        try {
            DaoFactory.getInstance().getRentDao().rentACar(rentCarStruct);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Car> getCarList() throws ServiceException {
        List<Car> cars = new ArrayList<>();
        try {
            DaoFactory.getInstance().getRentDao().getCarList();

        } catch (SQLException | ConnectionProviderException throwables) {
            throw new ServiceException(throwables);
        }
        return cars;
    }
}
