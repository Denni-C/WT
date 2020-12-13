package com.dennic.service;

import com.dennic.service.impl.RentServiceImpl;
import com.dennic.service.impl.UserServiceImpl;
import com.dennic.service.interfaces.RentService;
import com.dennic.service.interfaces.UserService;
import lombok.Getter;

@Getter
public class ServiceFactory {
    @Getter
    private static final ServiceFactory instance = new ServiceFactory();

    private final RentService rentService = new RentServiceImpl();
    private final UserService userService = new UserServiceImpl();
}
