package br.com.api.products.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.products.model.ProductModel;
import br.com.api.products.service.ProductService;

@RestController
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ProductModel productModel){
        return productService.saveChange(productModel, "update");
    }


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductModel productModel){
        return productService.saveChange(productModel, "save");
    }

    @GetMapping("/list")
    public Iterable<ProductModel> listAll(){
        return productService.findAll();
    }

    @GetMapping("/")
    public String route(){
        return "API is running!";
    }

}
