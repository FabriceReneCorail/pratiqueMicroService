package com.example.pratiqueMicroService.controller;

import com.example.pratiqueMicroService.Model.Product;
import com.example.pratiqueMicroService.dao.ProductDao;
import com.example.pratiqueMicroService.exceptions.ProduitIntrouvableException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductDao productDao;
    //Produits

    @GetMapping(value ="Produits")
    public List<Product> listeProduits(){
        return productDao.findAll();
    }

    //Produits/{id}
    @GetMapping(value = "Produits/{id}")
    public Product afficherUnProduit(@PathVariable int id) throws ProduitIntrouvableException {

        Product product = productDao.findById(id);

        if(product == null) throw new ProduitIntrouvableException("le produit n'existe pas");

        return product;
    }

    @PostMapping (value = "ajouterProduit")
    public ResponseEntity <Void> ajouterProduit(@RequestBody Product product){
        Product product1 = productDao.save(product);
        if(product == null){
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product1.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(value ="Test/Produits/{prixLimit}")
    List <Product> afficherSelection(@PathVariable int prixLimit){
        return productDao.findByPrixGreaterThan(prixLimit);
    }

    @GetMapping(value = "Tri/Produits/{prixFiltre}")
    List<Product> afficherSelectionMinus(@PathVariable int prixFiltre){
        return productDao.findByPrixLessThan(prixFiltre);
    }
}
