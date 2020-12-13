package com.dennic.service;

public class ServiceException extends Exception {
    public ServiceException(Exception associatedException) {
        super(associatedException);
    }
}
