package com.example.produitservice.service;

import com.example.produitservice.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IServiceProduct {

    Product addProduct(Product product);

    List<Product> getAllProduct();

    Product getProductById(Long id);

     Product updateProduct(Long id, Product updatedProductData);

    void deleteProduct(Long id);
}
