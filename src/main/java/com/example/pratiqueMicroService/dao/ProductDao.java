package com.example.pratiqueMicroService.dao;

import com.example.pratiqueMicroService.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ProductDao extends JpaRepository<Product ,Integer> {
    Product findById(int id);

    List <Product> findByPrixGreaterThan(int prixLimit);

    List<Product> findByPrixLessThan(int prixFiltre);
}
