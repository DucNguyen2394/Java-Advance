package com.assignments.mvcDesign.dao;

import com.assignments.mvcDesign.entity.Product;

import java.util.List;

public interface ProductDao {
    void create(Product product);
    Product getProductById(int id);
    List<Product> findAll();
    void update(Product product);
    boolean delete(int id);
}
