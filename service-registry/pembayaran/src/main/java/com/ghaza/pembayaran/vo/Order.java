package com.ghaza.pembayaran.vo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Order {

    private Long id;
    private Long produkId;
    private int jumlah;
    private String tanggal;
    private String status;
    private double total;

    public Order(){

    }
    public Order(Long id, Long produkId, int jumlah, String tanggal, String status, double harga){
        this.id = id;
        this.produkId = produkId;
        this.jumlah = jumlah;
        this.tanggal = tanggal;
        this.status = status;
        this.total = harga;

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProdukId() {
        return produkId ;
    }

    public void setProdukId(Long produkId) {
        this.produkId = produkId;
    }

    public int getJumlah() {
        return jumlah ;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    public String getTanggal() {
        return tanggal;
    }
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", productId=" + produkId + ", jumlah=" + jumlah + ", tanggal=" + tanggal + ", status=" + status +", total=" + total + '}';
    }

}