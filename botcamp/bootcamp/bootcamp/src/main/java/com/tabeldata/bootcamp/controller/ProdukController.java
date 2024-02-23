package com.tabeldata.bootcamp.controller;

import com.tabeldata.bootcamp.Dto.CustomMessage;
import com.tabeldata.bootcamp.Dto.Produckdto;
import com.tabeldata.bootcamp.services.ProdukServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/Produk")
public class ProdukController {

    @Autowired
    private ProdukServices service;

    @GetMapping("/findAll")
    public List<Produckdto.FindAllProduck> findAll() {
        return service.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public Optional<Produckdto.FindbyId> findbyId(@PathVariable Integer id) {
        return service.findbyId(id);
    }

    @GetMapping("/findbyname/{nama}")
    public List<Produckdto.FindbyName> findbyname(@PathVariable String nama) {
        return service.findbyName(nama);
    }

    @PostMapping("/Update/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody Produckdto.UpdateProduk Update) {
        try {
            service.updateproduk(id, Update);
            return ResponseEntity.ok("Produk berhasil diperbarui.");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Terjadi kesalahan internal pada server.");
        }
    }

    @PostMapping("/Insert")
    public ResponseEntity<?> Insert(@RequestBody Produckdto.InsertProduk Insert) {
        try {
            service.InsertProduk(Insert);
            return ResponseEntity.ok(new CustomMessage(HttpStatus.OK, "Produk berhasil di Simpan"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomMessage(HttpStatus.
                    INTERNAL_SERVER_ERROR,
                    "Terjadi kesalahan pada server."));
        }
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        service.Deleteproduk(id);
        return ResponseEntity.status(200).body("Produk berhasil dihapus.");
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Produckdto.save save) {
        try {
            service.saveproduk(save);
            return ResponseEntity.ok("Produk berhasil disimpan");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Gagal menyimpan produk: " + e.getMessage());
        }

    }
//    @GetMapping("/findrinci")
//    public List<Produckdto.findrinci>findRinci() {
//        return service.findrincis();
//    }
}



