package com.company.controllers;

import com.company.model.entities.Order;
import com.company.model.repositories.order.IOrderRepository;

import java.util.List;

public class OrderController {
    private IOrderRepository repository;
    public OrderController(IOrderRepository repository) {
        this.repository = repository;
    } //constructor
    public void createOrder(int products, String adress, String phone, String name) { //create method to create order and insert data
            repository.createOrder(new Order(products,adress,phone,name));  //send order to createOrder
        }
    public List<Order> getOrder(int id) {
        return repository.getOrder(id);
    }


}
