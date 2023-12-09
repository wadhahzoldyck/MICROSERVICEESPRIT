package com.example.produitservice.service;

import com.example.produitservice.entity.Product;
import com.example.produitservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceProduct implements IServiceProduct {

    private final ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {

        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(Long id, Product updatedProductData) {
        Product productToUpdate = productRepository.findById(id).orElse(null);

        if (productToUpdate != null && updatedProductData != null) {

            productToUpdate = productRepository.save(productToUpdate);
        } else {
            return null;
        }

        return productToUpdate;
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null){
           productRepository.delete(product);
        }

    }
}
