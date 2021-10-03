package com.karyawan.karyawan.repository;

import com.karyawan.karyawan.model.karyawan;

import java.util.List;

public interface KaryawanRepository {
    List<karyawan> findAll();
    karyawan findByKode(String kode);
    List<karyawan> searchKaryawan(String keyword, String startDate, String endDate);
    void save(karyawan kry);
    void deleteByKode(String kode);
    void update(karyawan kry);
}
