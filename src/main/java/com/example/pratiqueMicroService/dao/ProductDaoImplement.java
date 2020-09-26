package com.example.pratiqueMicroService.dao;

import com.example.pratiqueMicroService.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImplement implements ProductDao {

    public static List<Product> products = new ArrayList<>();

    static{
        products.add(new Product(1, "asipirateur",300, 150));
        products.add(new Product(2, "iphone",1300, 800));
        products.add(new Product(3, "ventilateur",200, 70));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if(product.getId()==id){
                return product;
            }
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }
}
