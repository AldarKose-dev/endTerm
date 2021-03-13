package com.company.model.entities;

public class Product {
    // product table
    private int product_id;
    private String name;
    private int price;
    private String category;
    private String color;
    private String brand;
    private String size;
    private String gender;
    //constructor


    public Product(int product_id, String name, int price, String category, String color, String brand, String size, String gender) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.color = color;
        this.brand = brand;
        this.size = size;
        this.gender = gender;
    }

//getters and setters
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getName() {
        return name;
    }


    // toString method to print all values
    @Override
    public String toString() {
        return "Product{" +
                "id=" + product_id +
                ", name='" + name + "'" +
                ", price=" + price +
                ", category='" + category + "'" +
                ", color='" + color + "'" +
                ", brand='" + brand + "'" +
                ", size='" + size + "'" +
                ", gender='" + gender + "'" +
                "}";
    }
}