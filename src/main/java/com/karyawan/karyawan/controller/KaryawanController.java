package com.karyawan.karyawan.controller;

import com.karyawan.karyawan.model.karyawan;
import com.karyawan.karyawan.service.KaryawanService;
import com.karyawan.karyawan.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class KaryawanController {
    public static final Logger logger = LoggerFactory.getLogger(KaryawanController.class);

    @Autowired
    KaryawanService KaryawanService;

    // -------------------Find All-------------------------------------

    @GetMapping("/karyawan")
    public ResponseEntity<List<karyawan>> listAllKaryawan() {
        List<karyawan> kry = KaryawanService.findAll();
        if (kry.isEmpty()) {
            return new ResponseEntity<>(kry, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(kry, HttpStatus.OK);
    }

    // -------------------Find by Kode------------------------------------------

    @RequestMapping(value = "/karyawan/{kode}", method = RequestMethod.GET)
    public ResponseEntity<?> getKaryawan(@PathVariable("kode") String kode) {
        logger.info("Fetching with kode {}", kode);
        karyawan kry = KaryawanService.findByKode(kode);
        if (kry == null) {
            logger.error("kode {} not found.", kode);
            return new ResponseEntity<>(new CustomErrorType("kode " + kode  + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(kry, HttpStatus.OK);
    }

    // -------------------Searching------------------------------------------

    @GetMapping("/karyawan/filter")
    public ResponseEntity<?> filterKaryawan(@RequestParam String keyword, @RequestParam String start,@RequestParam String end) {
        if(start == "" || end == ""){
            start = "0000-00-00";
            end = "0000-00-00";
        }
        List<karyawan> kry = KaryawanService.searchKaryawan(keyword,start,end);
        return new ResponseEntity<>(kry, HttpStatus.OK);
    }

    // -------------------Create-------------------------------------------

    @RequestMapping(value = "/karyawan/", method = RequestMethod.POST)
    public ResponseEntity<?> createKaryawan(@RequestBody karyawan kry) {
        logger.info("Creating : {}", kry);

        KaryawanService.save(kry);
        return new ResponseEntity<>("Berhasil Disimpan!!", HttpStatus.CREATED);
    }

    // ------------------- Delete-----------------------------------------

    @RequestMapping(value = "/karyawan/{kode}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteKaryawan(@PathVariable("kode") String kode) {
        logger.info("Fetching & Deleting with kode {}", kode);

        karyawan cus = KaryawanService.findByKode(kode);
        if (cus == null) {
            logger.error("Unable to delete. kode {} not found.", kode);
            return new ResponseEntity<>(new CustomErrorType("Unable to delete. kode " + kode + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        KaryawanService.deleteByKode(kode);
        return new ResponseEntity<>("Berhasil di Hapus!!", HttpStatus.OK);
    }

    // ------------------- Update------------------------------------------------

    @RequestMapping(value = "/karyawan/{kode}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateKaryawan(@PathVariable("kode") String kode, @RequestBody karyawan kry) {
        logger.info("Updating with kode {}", kode);

        karyawan curren = KaryawanService.findByKode(kode);

        if (curren == null) {
            logger.error("Unable to update. kode {} not found.", kode);
            return new ResponseEntity<>(new CustomErrorType("Unable to update. kode " + kode + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        curren.setNama(kry.getNama());
        curren.setTglMasuk(kry.getTglMasuk());
        curren.setHp(kry.getHp());
        curren.setLimitRembers(kry.getLimitRembers());
        KaryawanService.update(kry);
        return new ResponseEntity<>("Berhasil di update!!", HttpStatus.OK);
    }
}
