package com.tabeldata.bootcamp.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Produckdto {
@Data
@AllArgsConstructor
@NoArgsConstructor
    public static class FindAllProduck{
        private Integer id ;
        private String namaProduk;
        private Integer jumlahProduk;
        private BigDecimal hargaProduk;
        private String warna;
        private Date waktu;
}
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FindbyId{
        private Integer id ;
        private String namaProduk;
        private Integer jumlahProduk;
        private BigDecimal hargaProduk;
        private String warna;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FindbyName {
        private Integer id;
        private String namaProduk;
        private Integer jumlahProduk;
        private BigDecimal hargaProduk;
        private String warna;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateProduk {
        private Integer id;
        private String namaProduk;
        private Integer jumlahProduk;
        private BigDecimal hargaProduk;
        private String warna;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InsertProduk {
        private Integer id;
        private String namaProduk;
        private Integer jumlahProduk;
        private BigDecimal hargaProduk;
        private String warna;
        private List<ProdukRinci> produkRinci;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProdukRinci {
        private Integer id ;
        private Integer idProduk;
        private String ukuran;
    }
//    @Data
//    @AllArgsConstructor
//    @NoArgsConstructor
//    public static class findrinci {
//        private Integer id ;
//        private Integer idProduk;
//        private String ukuran;
//    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DeletedProduk {
        private Integer id;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class save {
        private Integer id;
        private String namaProduk;
        private Integer jumlahProduk;
        private BigDecimal hargaProduk;
        private String warna;
        private Date waktu;
    }
}
