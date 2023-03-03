package com.revature.controllers;


import com.revature.models.Product;
import com.revature.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"}, allowCredentials = "true")
@RequestMapping(value = "/products")
public class ProductController {
    private ProductService pService;

    @Autowired
    public ProductController(ProductService pService){
        this.pService = pService;
    }


    public ResponseEntity<Product> findByProductName(@PathVariable String productName){
        Optional<Product> productOptional = pService.findByProductName(productName);

        if(productOptional.isPresent()){
            Product extractedProduct = productOptional.get();
            return ResponseEntity.ok(extractedProduct);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping(value="/newproduct")
    public ResponseEntity addProduct(@RequestBody Product p) {
        Optional<Product> productOptional = pService.findByProductName(p.getProductName());

        if(productOptional.isPresent()){
            return ResponseEntity.status(406).body("This product already exists");
        }
        Product newProduct = pService.save(p);

        if(newProduct == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.accepted().body(newProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(this.pService.getAll());
    }



}
