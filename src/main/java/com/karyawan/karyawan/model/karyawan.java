package com.karyawan.karyawan.model;

public class karyawan {
    String kode;
    String nama;
    String tglMasuk;
    String hp;
    int limitRembers;
    String createdAt;
    String updatedAt;

    public karyawan(String kode, String nama, String tglMasuk, String hp, int limitRembers, String createdAt, String updatedAt) {
        this.kode = kode;
        this.nama = nama;
        this.tglMasuk = tglMasuk;
        this.hp = hp;
        this.limitRembers = limitRembers;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTglMasuk() {
        return tglMasuk;
    }

    public void setTglMasuk(String tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public int getLimitRembers() {
        return limitRembers;
    }

    public void setLimitRembers(int limitRembers) {
        this.limitRembers = limitRembers;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "karyawan{" +
                "kode='" + kode + '\'' +
                ", nama='" + nama + '\'' +
                ", tglMasuk='" + tglMasuk + '\'' +
                ", hp='" + hp + '\'' +
                ", limitRembers=" + limitRembers +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
