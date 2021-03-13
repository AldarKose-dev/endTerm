package com.company.model.repositories.order;

import com.company.model.database.IDB;
import com.company.model.entities.Order;

import java.sql.*;
import java.util.ArrayList; // для того, чтобы мы могли использовать ArrayList
import java.util.List;

public class OrderRepository implements IOrderRepository { // class that responsible for main logic of order
    private IDB db;

    public OrderRepository(IDB db) {
        this.db = db;
    } //constructor

    @Override
    public void createOrder(Order order) {  //method to create order
        Connection connection = null; //creating reference to connection
        try {
            connection = db.getConnection();  //establish connection
            String insertOrder = "INSERT INTO \"orders\"(products, adress, phone, name) VALUES(?, ?, ?, ?)";  // making sql statement
                                                                                                              //and insert values with prepare statement
            PreparedStatement insertOrderStatement = connection.prepareStatement(insertOrder);
            insertOrderStatement.setInt(1, order.getProducts()); //inserting values instead of '?'
            insertOrderStatement.setString(2, order.getAdress());
            insertOrderStatement.setString(3, order.getPhone());
            insertOrderStatement.setString(4, order.getName());
            insertOrderStatement.execute();  //executing query
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();   //close connection
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public List<Order> getOrder(int id) {  //method to output order that as just created
        Connection connection = null;
        List<Order> orderDetails = new ArrayList<>();  //create an array of order
        try {
            connection = db.getConnection();  //establish connection
            String sql = "SELECT * FROM \"orders\" WHERE order_id = ? ORDER BY order_id";  //make sql statement to get a row
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();  //executing query
            while (resultSet.next()) {   // receive data from database
                orderDetails.add(new Order(resultSet.getInt(2), resultSet.getString(3), //adding created object to array
                        resultSet.getString(4),resultSet.getString(5)));
            }
            return orderDetails;  //return this array
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    }
