package com.company.model.entities;

import java.util.List;

public class Order {
    private int id;     //creating private fields
    private int products;
    private String adress;
    private String phone;
    private String name;

    public Order(int products, String adress, String phone, String name) {  //creating constructor with fields
        this.id = id;
        this.products = products;
        this.adress = adress;
        this.phone = phone;
        this.name = name;
    }

    //getters
    public String getName() {
        return name;
    }

    public int getProducts() {
        return products;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {   //method to output order
        return "Order{" +
                "id=" + id +
                ", products=" + products +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
