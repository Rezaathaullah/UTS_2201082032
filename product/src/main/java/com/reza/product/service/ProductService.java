/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reza.product.service;

import com.reza.product.entity.Product;
import com.reza.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author reza
 */
@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getALL(){
    
        return productRepository.findAll();
        
    }
    public Product getProductById(Long productId){
        return productRepository.findById(productId).get();
    }
    
    public void insert(Product product){
    productRepository.save(product);
    }
    @Transactional
    public void update (Long  productId, String kode, String nama, String satuan, double harga){
    Product product = productRepository.findById(productId)
            .orElseThrow(() -> new IllegalStateException("produk tidak ada"));
    
    if(kode != null && kode.length()>0
            && !Objects.equals(product.getKode(), kode)){
          product.setKode(kode);
    }
     if(kode != null && nama.length()>0
            && !Objects.equals(product.getNama(), nama)){
          product.setNama(nama);
    }
      if(kode != null && satuan.length()>0
            && !Objects.equals(product.getSatuan(), satuan)){
          product.setSatuan(satuan);
    }
       if(harga !=0
            && !Objects.equals(product.getHarga(), harga)){
          product.setHarga(harga);
    }
       
    }
    
    public void delete(Long productId){
        productRepository.deleteById(productId);
    } 
}
