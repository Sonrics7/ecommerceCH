package com.edu.ecommercech.EcommerceCH.controllers;

import com.edu.ecommercech.EcommerceCH.entities.Product;
import com.edu.ecommercech.EcommerceCH.exception.ProductAlreadyExistsException;
import com.edu.ecommercech.EcommerceCH.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Aqui se usa el controller Product, con ruta de api para llamar en postman, post, put, getmapping(id), getmapping(all)

@RestController
@RequestMapping(path = "api/ecommerce/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/")
    public ResponseEntity<Product> create(@RequestBody Product product) throws ProductAlreadyExistsException {
        return new ResponseEntity<>(this.productService.create(product), HttpStatus.OK);
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Long id) throws Exception {
        return new ResponseEntity<>(this.productService.update(product,id), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(this.productService.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<Product>> findAll(){
        return new ResponseEntity<>(this.productService.findAll(), HttpStatus.OK);
    }
}
