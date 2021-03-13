package com.company.model.repositories.product;

import com.company.model.entities.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getProducts();  //method that gets data from table 'product'
    List<Product> getSortedProducts(String input);  //method that gets sorted products
}
