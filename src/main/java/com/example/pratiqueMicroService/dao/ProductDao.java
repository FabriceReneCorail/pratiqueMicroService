package com.example.pratiqueMicroService.dao;

import com.example.pratiqueMicroService.Model.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> findAll();
    public Product findById (int id);
    public Product save(Product product);
}
