package com.ghaza.pembayaran.controller;


import com.ghaza.pembayaran.entity.Pembayaran;
import com.ghaza.pembayaran.service.PembayaranService;
import com.ghaza.pembayaran.vo.ResponseTemplate;
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

@RestController
@RequestMapping("api/v1/pembayaran")
public class PembayaranController {
    @Autowired
    private PembayaranService pembayaranService;

    @GetMapping
    public List<Pembayaran> getAll(){
        return pembayaranService.getAll();
    }
    @PostMapping
    public void insert(@RequestBody Pembayaran pembayaran){
        pembayaranService.insert(pembayaran);
    }

    @GetMapping(path = "{id}")
    public Pembayaran getPembayaranById(@PathVariable("id") Long Id){
        return pembayaranService.getPembayaranById(Id);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable ("id") Long Id){
        pembayaranService.delete(Id);
    }

    @PutMapping(path = "{id}")
    public void update(@PathVariable ("id") Long id,
                       @RequestParam(required = false) String mode_pembayaran,
                       @RequestParam(required = false) String nomor_referensi,
                       @RequestParam(required = false) String tgl_bayar){
        pembayaranService.update(id, mode_pembayaran, nomor_referensi, tgl_bayar);
    }

    @GetMapping(path = "/order/{id}")
    public ResponseTemplate getPembayaranWithOrderById(@PathVariable("id") Long id){
        return pembayaranService.getPembayaranWithOrderById(id);
    }


}