package com.example.produitservice.controller;

import com.example.produitservice.entity.Product;
import com.example.produitservice.repository.ProductRepository;
import com.example.produitservice.service.IServiceProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("Product")
@RequiredArgsConstructor
public class ProductController {

    private final IServiceProduct iServiceProduct;
    private final ProductRepository productRepository;

    @PostMapping(value = "/addProduct", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Product> addProduct(
            @RequestParam("image") MultipartFile image,
            @RequestParam("nomProduit") String nomProduit,
            @RequestParam("description")  String description,
            @RequestParam("qte") int qte,
            @RequestParam("prix")  float prix
    ) throws IOException, SQLException {

     Product product = new Product();
     product.setDescription(description);
     product.setQte(qte);
     product.setPrix(prix);
     product.setNomProduit(nomProduit);

        if (!image.isEmpty()) {
            byte[] fileBytes = image.getBytes();

            // Convert the byte array to a Blob
            Blob blob = new SerialBlob(fileBytes);

            // Set the Blob to the Product's imageUrl property
            product.setImage(blob);

            Product addedProduct = iServiceProduct.addProduct(product);
            return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
        } else {
            // Handle case where no image is uploaded
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);        }
    }

    @GetMapping("/getAllProduct")
    public ResponseEntity<List<Product>> getAllProduct(){

        return new ResponseEntity<>(iServiceProduct.getAllProduct(),HttpStatus.OK);

    }
    @GetMapping("/getProduct/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){

        return new ResponseEntity<>(iServiceProduct.getProductById(id),HttpStatus.OK);

    }

    @PutMapping(value ="/updateProd/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Product> updateProd(@PathVariable Long id, @RequestParam("image") MultipartFile image,
                                              @RequestParam("nomProduit") String nomProduit,
                                              @RequestParam("description")  String description,
                                              @RequestParam("qte") int qte,
                                              @RequestParam("prix")  float prix) throws IOException, SQLException {
        Product existingProd = iServiceProduct.getProductById(id);
        if (existingProd != null) {

            existingProd.setDescription(description);
            existingProd.setQte(qte);
            existingProd.setPrix(prix);
            existingProd.setNomProduit(nomProduit);
            if (!image.isEmpty()) {
                byte[] fileBytes = image.getBytes();

                // Convert the byte array to a Blob
                Blob blob = new SerialBlob(fileBytes);

                // Set the Blob to the Product's imageUrl property
                existingProd.setImage(blob);
            }
            Product updatedProd = iServiceProduct.updateProduct(id, existingProd);
            return new ResponseEntity<>(updatedProd, HttpStatus.CREATED);
        } else {
            // Handle case where no image is uploaded
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @DeleteMapping("/deleteProd/{id}")
    public ResponseEntity<Void> deleteProd(@PathVariable Long id){
        iServiceProduct.deleteProduct(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
}
