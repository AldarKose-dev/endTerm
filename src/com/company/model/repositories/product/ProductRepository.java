package com.company.model.repositories.product;

import com.company.model.database.IDB;
import com.company.model.entities.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductRepository implements IProductRepository {
    private final IDB db;

    public ProductRepository(IDB db) {
        this.db = db;
    }


    public List<Product> getProducts() {  //method that gets data from table 'products'
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Product> products = new ArrayList<>();  //creating an array
        String sql="select * from products order by product_id";  //writing sql statement
        try {
            connection = db.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) { //receive data from database
                products.add(new Product( resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
                        resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),
                        resultSet.getString(7), resultSet.getString(8))); //creating object of product and
                                                                                               // inserting it into an array
            }
            return products;  //return this array
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                assert resultSet != null;
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }


    public List<Product> getSortedProducts(String sql) {  //this method sorts products by based on send query
        Connection connection = null;
        List<Product> products = new ArrayList<>();
        try {
            connection = db.getConnection();
            ResultSet resultSet = null;
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                products.add(new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
                        resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),
                        resultSet.getString(7), resultSet.getString(8)));
            }
            return products;
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                assert connection!= null;
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }

}