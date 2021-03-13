package com.company.model.repositories.order;

import com.company.model.entities.Order;

import java.util.List;

public interface IOrderRepository {// interface for OrderRepository
    void createOrder(Order order); // method that create order
    List<Order> getOrder(int id); // method that get order that was created
}