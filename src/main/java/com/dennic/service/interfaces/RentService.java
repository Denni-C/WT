package com.dennic.service.interfaces;

import com.dennic.dto.RentCarStruct;
import com.dennic.entity.Car;
import com.dennic.service.ServiceException;

import java.util.List;

public interface RentService {
    void rentACar(RentCarStruct rentCarStruct) throws ServiceException;
    List<Car> getCarList() throws ServiceException;
}
