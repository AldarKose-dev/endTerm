package com.company.view;

import com.company.model.database.IDB;
import com.company.model.database.DatabaseConnection;
import com.company.model.repositories.order.IOrderRepository;
import com.company.model.repositories.order.OrderRepository;
import com.company.model.repositories.product.IProductRepository;
import com.company.model.repositories.product.ProductRepository;
import com.company.view.Application;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        IDB db = DatabaseConnection.getInstance();    //create object of database connection with singleton
        IOrderRepository orderRepository = new OrderRepository(db);  //create object of order repository
        IProductRepository productRepository = new ProductRepository(db); //create object of product repository
        Application application = new Application(orderRepository, productRepository); //calling constructor and sending repository
                                                                                       // objects that we crated before
        application.start();   //calling method start from class application to run the program
    }
}

