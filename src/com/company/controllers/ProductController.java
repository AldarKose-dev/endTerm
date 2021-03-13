package com.company.controllers;

import com.company.model.entities.Product;
import com.company.model.repositories.product.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductController {
    private final IProductRepository productRepository;

    public ProductController(IProductRepository productRepository) {
        this.productRepository = productRepository;
    } //constructor

    public void displayProducts() {  //method that output all data from table products
        List<Product> products = productRepository.getProducts(); //create array to make an output
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public void displaySortedProducts(String input) {  //method that output sorted products
        List<Product> products = productRepository.getSortedProducts(input); //create array
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }


}
