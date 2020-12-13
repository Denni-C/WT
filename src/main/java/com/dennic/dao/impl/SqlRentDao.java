package com.dennic.dao.impl;

import com.dennic.dao.DaoException;
import com.dennic.dao.SqlUtils;
import com.dennic.dao.connection.ConnectionProvider;
import com.dennic.dao.connection.ConnectionProviderException;
import com.dennic.dao.interfaces.RentDao;
import com.dennic.dto.RentCarStruct;
import com.dennic.entity.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlRentDao implements RentDao {
    private final ConnectionProvider connectionProvider;

    public SqlRentDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    @Override
    public void rentACar(RentCarStruct rentCarStruct) throws DaoException {
        try (Connection connection = connectionProvider.getConnection()) {
            String insertTestCommand = "INSERT INTO rent (ownerId, carId, startTime, endTime) VALUES (?, ?, ?, ?)";
            PreparedStatement insertTestStatement = connection.prepareStatement(
                    insertTestCommand, Statement.RETURN_GENERATED_KEYS);
            insertTestStatement.executeUpdate();
            insertTestStatement.setInt(1, rentCarStruct.getRent().getOwnerId());
            insertTestStatement.setInt(2, rentCarStruct.getRent().getCarId());
            insertTestStatement.setDate(3, rentCarStruct.getRent().getStartRentTime());
            insertTestStatement.setDate(4, rentCarStruct.getRent().getEndRentTime());

            rentCarStruct.getRent().setId(SqlUtils.getGeneratedId(insertTestStatement));

            String updateCarState = "UPDATE rent SET (is_rented = true) WHERE id = ?";
            PreparedStatement insertQuestionStatement = connection.prepareStatement(
                    updateCarState, Statement.RETURN_GENERATED_KEYS);
            insertQuestionStatement.setInt(1, rentCarStruct.getRent().getCarId());
            insertQuestionStatement.executeUpdate();


        } catch (ConnectionProviderException | SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Car> getCarList() throws ConnectionProviderException, SQLException {
        List<Car> cars = new ArrayList<>();
        try (Connection connection = connectionProvider.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet =
                    statement.executeQuery("SELECT id, mark, price, color FROM car WHERE is_rented = false");
            Car car;
            while(resultSet.next()){
                car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setMark(resultSet.getString("mark"));
                car.setPrice(resultSet.getInt("price"));
                car.setColor(resultSet.getString("color"));
                cars.add(car);
            }
        }
        return cars;
    }
}
