/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reza.product.controller;

import com.reza.product.entity.Product;
import com.reza.product.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author reza
 */
@RestController
@RequestMapping("api/vl/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;
   
    @GetMapping
    public List<Product> getALL(){
        return productService.getALL();
    }
    
    @PostMapping
    public void insert(@RequestBody Product product){
           productService.insert(product);
    }
    
    @DeleteMapping(path = "{productId}" )
    public void delete(@PathVariable ("productId") Long productId){
        productService.delete(productId);
    }
    
    @PutMapping(path = "{productId}")
    public void update (@PathVariable("productId") Long productId,
          @RequestParam(required = false) String kode,  
          @RequestParam(required = false) String nama,  
          @RequestParam(required = false) String satuan, 
          @RequestParam(required = false) double harga) {
          productService.update(productId, kode, nama, satuan, harga);
    }
    
    @GetMapping(path = "{productId}")
    public Product getProductById(@PathVariable("productId") Long productId){
       return productService.getProductById(productId);
    }
}


