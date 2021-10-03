package com.karyawan.karyawan.repository;

import com.karyawan.karyawan.model.karyawan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@Repository("KaryawanRepository")
public class KaryawanRepositoryImpl implements KaryawanRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<karyawan> findAll(){
        return jdbcTemplate.query("SELECT * FROM tbl_karyawan",
                (rs,rowNum)->
                        new karyawan(
                                rs.getString("kode_karyawan"),
                                rs.getString("nama_karyawan"),
                                rs.getString("tgl_masuk"),
                                rs.getString("no_hp"),
                                rs.getInt("limit_reimbursement"),
                                rs.getString("created_date"),
                                rs.getString("updated_date")
                        ));
    }

    public karyawan findByKode(String kode) {

        return jdbcTemplate.queryForObject("SELECT * FROM tbl_karyawan WHERE kode_karyawan = ?", new Object[]{kode},
                (rs,rowNum)->
                        new karyawan(
                                rs.getString("kode_karyawan"),
                                rs.getString("nama_karyawan"),
                                rs.getString("tgl_masuk"),
                                rs.getString("no_hp"),
                                rs.getInt("limit_reimbursement"),
                                rs.getString("created_date"),
                                rs.getString("updated_date")
                        ));
    }

    public List<karyawan> searchKaryawan(String keyword, String startDate, String endDate){
        return jdbcTemplate.query("SELECT * FROM tbl_karyawan WHERE nama_karyawan LIKE ? OR no_hp LIKE ? OR DATE(tgl_masuk) BETWEEN ? AND ?",
                preparedStatement -> {
                    preparedStatement.setString(1, "%" + keyword + "%");
                    preparedStatement.setString(2, "%" + keyword + "%");
                    preparedStatement.setString(3, startDate);
                    preparedStatement.setString(4, endDate);
                },
                (rs,rowNum)->
                        new karyawan(
                                rs.getString("kode_karyawan"),
                                rs.getString("nama_karyawan"),
                                rs.getString("tgl_masuk"),
                                rs.getString("no_hp"),
                                rs.getInt("limit_reimbursement"),
                                rs.getString("created_date"),
                                rs.getString("updated_date")
                        ));
    }

    public void save(karyawan kry){
        java.util.Date date=new java.util.Date();
        jdbcTemplate.update("INSERT INTO tbl_karyawan(kode_karyawan, nama_karyawan, tgl_masuk, no_hp,limit_reimbursement, created_date) VALUES (?,?,?,?,?,?)",
                kry.getKode(), kry.getNama(), kry.getTglMasuk(), kry.getHp(),
                kry.getLimitRembers(), date);
    }

    public void deleteByKode(String kode){
        jdbcTemplate.update("DELETE from tbl_karyawan WHERE kode_karyawan=?",kode);
    }

    public void update(karyawan kry){
        jdbcTemplate.update("UPDATE tbl_karyawan SET nama_karyawan = '"+kry.getNama()+"', tgl_masuk = '"+kry.getTglMasuk()+"', no_hp = '"+kry.getHp()+"', limit_reimbursement = '"+kry.getLimitRembers()+"' WHERE kode_karyawan = '"+kry.getKode()+"'");
    }

}
