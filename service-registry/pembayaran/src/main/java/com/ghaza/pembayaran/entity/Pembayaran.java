package com.ghaza.pembayaran.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_pembayaran")
public class Pembayaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long order_Id;
    private String mode_pembayaran;
    private String nomor_referensi;
    private String tgl_bayar;
    private double total_bayar;

    public Pembayaran(){

    }
    public Pembayaran(Long id, Long order_Id, String mode_pembayaran, String nomor_referensi, String tgl_bayar, double total_bayar){
        this.id = id;
        this.order_Id = order_Id;
        this.mode_pembayaran = mode_pembayaran;
        this.nomor_referensi = nomor_referensi;
        this.tgl_bayar = tgl_bayar;
        this.total_bayar = total_bayar;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(Long order_Id) {
        this.order_Id = order_Id;
    }
    public String getMode_Pembayaran() {
        return mode_pembayaran;
    }

    public void setMode_Pembayaran(String mode_pembayaran) {
        this.mode_pembayaran = mode_pembayaran;
    }
    public String getNomor_Referensi() {
        return nomor_referensi;
    }

    public void setNomor_Referensi(String nomor_referensi) {
        this.nomor_referensi = nomor_referensi;
    }
    public String getTgl_Bayar() {
        return tgl_bayar;
    }

    public void setTgl_Bayar(String tgl_bayar) {
        this.tgl_bayar = tgl_bayar;
    }
    public double getTotal_Bayar() {
        return total_bayar;
    }

    public void setTotal_Bayar(double total_bayar) {
        this.total_bayar = total_bayar;
    }

    @Override
    public String toString() {
        return "Pembayaran{" + "id=" + id + ", order_Id=" + order_Id + ", mode_pembayaran=" + mode_pembayaran + ", nomor_referensi=" + nomor_referensi + ", tgl_bayar=" + tgl_bayar + ", total_bayar=" + total_bayar + '}';
    }

}