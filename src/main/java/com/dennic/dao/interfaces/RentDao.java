package com.dennic.dao.interfaces;

import com.dennic.dao.DaoException;
import com.dennic.dao.connection.ConnectionProviderException;
import com.dennic.dto.RentCarStruct;
import com.dennic.entity.Car;

import java.sql.SQLException;
import java.util.List;

public interface RentDao {
    void rentACar(RentCarStruct rentCarStruct) throws DaoException;
    List<Car> getCarList() throws ConnectionProviderException, SQLException;
}
