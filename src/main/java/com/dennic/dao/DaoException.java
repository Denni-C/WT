package com.dennic.dao;

public class DaoException extends Exception {
    public DaoException(Exception associatedException) {
        super(associatedException);
    }
}
