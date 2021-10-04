package com.karyawan.karyawan.service;

import com.karyawan.karyawan.model.karyawan;
import com.karyawan.karyawan.repository.KaryawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("KaryawanService")
public class KaryawanServiceImpl implements KaryawanService{

    @Autowired
    KaryawanRepository KaryawanRepository;

    public List<karyawan> findAll() {
        List<karyawan> kry = KaryawanRepository.findAll();
        return kry;
    }

    public karyawan findByKode(String kode) {
        karyawan kry;
        try{
            kry = KaryawanRepository.findByKode(kode);
        }catch (EmptyResultDataAccessException e){
            System.out.println(e);
            kry = null;
        }
        return kry;
    }

    public List<karyawan> searchKaryawan(String keyword, String startDate, String endDate) {
        List<karyawan> kry = KaryawanRepository.searchKaryawan(keyword, startDate, endDate);
        return kry;
    }

    public void save(karyawan kry) {
        synchronized (this) {
            KaryawanRepository.save(kry);
        }
    }

    public void deleteByKode(String kode) {
        synchronized (this) {
            KaryawanRepository.deleteByKode(kode);
        }
    }

    public void update(karyawan kry) {
        synchronized (this) {
            KaryawanRepository.update(kry);
        }
    }
}

