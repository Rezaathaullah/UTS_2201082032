/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reza.order.service;

import com.reza.order.VO.Product;
import com.reza.order.VO.ResponseTemplate;
import com.reza.order.entity.Order;
import com.reza.order.repository.OrderRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author reza
 */
@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping
    public List<Order> getALL(){
        return orderRepository.findAll();
        
    }
    public Order getOrderById(Long id){
        return orderRepository.findById(id).get();
    }
    
    public void insert(Order order){
    orderRepository.save(order);
    }
    @Transactional
    public void update (Long  orderId, Long produkId, Integer jumlah, String tanggal, String status){
    Order order = orderRepository.findById(orderId)
            .orElseThrow(() 
                    -> new IllegalStateException("order tidak ada"));
  
     if(jumlah != null) {
         order.setJumlah(jumlah);
    }   
     if(tanggal != null && tanggal.length()>0
            && !Objects.equals(order.getTanggal(), tanggal)){
          order.setTanggal(tanggal);
    }  
     if(status != null && status.length()>0
            && !Objects.equals(order.getStatus(), status)){
          order.setStatus(status);
    }  
     
  }
     public void delete(Long id){
         orderRepository.deleteById(id);
     }

    public void update(Long id, Integer jumlah, String tanggal, String status) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public ResponseTemplate getOrderWithProductById(Long id){
            ResponseTemplate responseTemplate = new ResponseTemplate();
            Order order = getOrderById(id);
            Product product = 
                    restTemplate.getForObject("http://localhost:9001/api/vl/product/"
                    +order.getProdukId(), Product.class);
            responseTemplate.setOrder(order);
            responseTemplate.setProduct(product);
            return responseTemplate;
    }
    
      
}
