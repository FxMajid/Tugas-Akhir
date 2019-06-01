package com.example.tugasakhir.Model;

import java.util.List;

public class ResponseResponden {
    String kode, pesan;

    List <RespondenModel> jadi;

    public List<RespondenModel> getJadi() {
        return jadi;
    }

    public void setJadi(List<RespondenModel> jadi) {
        this.jadi = jadi;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }
}
