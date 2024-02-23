package com.tabeldata.bootcamp.Dao;

import com.tabeldata.bootcamp.Dto.Produckdto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.basic.BasicTreeUI;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class ProdukDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Produckdto.FindAllProduck> findAllProduck(){
        String query = "select\n" +
                "\tid,\n" +
                "\tnama_produk as namaProduk,\n" +
                "\tjumla_produk as jumlahProduk,\n" +
                "\tharga_produk as hargaProduk,\n" +
                "\twarna ,\n" +
                "\twaktu\n" +
                "from\n" +
                "\tpublic.table_produk;";
        MapSqlParameterSource map = new MapSqlParameterSource();
        return jdbcTemplate.query(query, map, new BeanPropertyRowMapper<>(Produckdto.FindAllProduck.class));
    }
    public Optional<Produckdto.FindbyId> findbyId(Integer id) {
        String query = "select\n" +
                "\tid,\n" +
                "\tnama_produk as namaProduk,\n" +
                "\tjumla_produk as jumlahProduk,\n" +
                "\tharga_produk as hargaProduk,\n" +
                "\twarna\n" +
                "from\n" +
                "\tpublic.table_produk\n" +
                "\twhere id = :idProduk";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("idProduk", id);
        try {
            Produckdto.FindbyId data = jdbcTemplate.queryForObject(query, map, new BeanPropertyRowMapper<>(Produckdto.FindbyId.class));
            return Optional.of(data);

        } catch (Exception e) {
            return Optional.empty();
        }
    }
        public List<Produckdto.FindbyName> findbyname(String nama){
            String query = "select\n" +
                    "\tid,\n" +
                    "\tnama_produk as namaProduk,\n" +
                    "\tjumla_produk as jumlahProduk,\n" +
                    "\tharga_produk as hargaProduk,\n" +
                    "\twarna\n" +
                    "from\n" +
                    "\tpublic.table_produk\n" +
                    "\twhere nama_produk like :namaProduk";
            MapSqlParameterSource map = new MapSqlParameterSource();
            map.addValue("namaProduk","%" + nama + "%");
            return jdbcTemplate.query(query, map, new BeanPropertyRowMapper<>(Produckdto.FindbyName.class));
        }
        public void updateproduk(Integer id , Produckdto.UpdateProduk request){
        String query = "update\n" +
                "\ttable_produk\n" +
                "set\n" +
                "\tnama_produk = :namaProduk,\n" +
                "\tjumla_produk = :jumlahProduk,\n" +
                "\tharga_produk = :hargaProduk,\n" +
                "\twarna = :warnaProduk\n" +
                "\twhere id =:idProduk";
        MapSqlParameterSource map =new MapSqlParameterSource();
        map.addValue("namaProduk", request.getNamaProduk());
        map.addValue("jumlahProduk", request.getJumlahProduk());
        map.addValue("hargaProduk", request.getHargaProduk());
        map.addValue("warnaProduk", request.getWarna());
        map.addValue("idProduk", request.getId());
        jdbcTemplate.update(query, map);
        }
    public Integer insertProduk(Produckdto.InsertProduk insert) {
        String query = "insert\n" +
                "\tinto\n" +
                "\tpublic.table_produk\n" +
                "(\n" +
                "\tnama_produk,\n" +
                "\tjumla_produk,\n" +
                "\tharga_produk,\n" +
                "\twarna)\n" +
                "values(\n" +
                ":namaProduk,\n" +
                ":jumlahProduk,\n" +
                ":hargaProduk,\n" +
                ":warna);";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("namaProduk", insert.getNamaProduk());
        map.addValue("jumlahProduk", insert.getJumlahProduk());
        map.addValue("hargaProduk", insert.getHargaProduk());
        map.addValue("warna", insert.getWarna());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(query, map, keyHolder, new String[]{"id"});
        Integer generateId = keyHolder.getKey().intValue();
        return generateId;
    }
        public void InsertProdukRinci(Produckdto.ProdukRinci insert){
            String query = "INSERT INTO public.table_produk_rinci\n" +
                    "(ukuran, id_produk, i_id)\n" +
                    "VALUES(:ukuran, :idProduk, nextval('table_produk_rinci_i_id_seq'::regclass));";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("idProduk",insert.getIdProduk());
        map.addValue("ukuran", insert.getUkuran());
        jdbcTemplate.update(query, map);
        }
    public void Delete(Integer id){
        String query = "DELETE FROM public.table_produk\n" +
                "WHERE id = :idProduk;";
        MapSqlParameterSource map =new MapSqlParameterSource();
        map.addValue("idProduk",id);
        jdbcTemplate.update(query, map);

    }
    public Integer Save(Produckdto.save save) {
        String query = "INSERT INTO public.table_produk\n" +
                "(id, nama_produk, jumla_produk, harga_produk, warna, waktu)\n" +
                "VALUES(nextval('table_produk_id_seq'::regclass), :namaProduk, :jumlahProduk, :hargaProduk, :warna, :waktu)";
        MapSqlParameterSource map = new MapSqlParameterSource();
        log.info("waktu = {}",save.getWaktu());
        map.addValue("namaProduk", save.getNamaProduk());
        map.addValue("jumlahProduk", save.getJumlahProduk());
        map.addValue("hargaProduk", save.getHargaProduk());
        map.addValue("warna", save.getWarna());
        map.addValue("waktu", new Timestamp(save.getWaktu().getTime()));
        return jdbcTemplate.update(query,map);
    }
//    public List<Produckdto.findrinci> findRinci() {
//        String query = "SELECT ukuran, id_produk AS idProduk, i_id AS id FROM public.table_produk_rinci";
//        MapSqlParameterSource map = new MapSqlParameterSource();
//        return jdbcTemplate.query(query, map, new BeanPropertyRowMapper<>(Produckdto.findrinci.class));
//    }
    }

