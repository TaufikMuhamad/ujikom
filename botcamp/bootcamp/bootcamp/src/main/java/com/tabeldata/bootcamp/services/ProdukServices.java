package com.tabeldata.bootcamp.services;

import com.tabeldata.bootcamp.Dao.ProdukDao;
import com.tabeldata.bootcamp.Dto.Produckdto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProdukServices {

    @Autowired
    private ProdukDao dao;

    public List<Produckdto.FindAllProduck> findAll(){
        return dao.findAllProduck();

}
    public Optional<Produckdto.FindbyId> findbyId(Integer idProduk){
            return dao.findbyId(idProduk);
    }
    public List<Produckdto.FindbyName> findbyName(String namaProduk){
        return dao.findbyname(namaProduk);
    }
    public void updateproduk(Integer id,Produckdto.UpdateProduk Request){
         dao.updateproduk(id, Request);
    }
    @Transactional
   public  void InsertProduk(Produckdto.InsertProduk insert){
        Integer idProduk =dao.insertProduk(insert);
        log.info("Request {}", insert);
        for (Produckdto.ProdukRinci data : insert.getProdukRinci()){
            if (!data.getUkuran().equals("S")) {
                data.setIdProduk(idProduk);
                dao.InsertProdukRinci(data);
            }
        }
    }
    public void Deleteproduk(Integer id){
         dao.Delete(id);
    }
    public void saveproduk(Produckdto.save save){
        dao.Save(save);

    }
//    public List<Produckdto.findrinci> findrincis(){
//        return dao.findRinci();
//    }
}
