package com.example.tugasakhir.Model;

import java.util.List;

public class ResponsePetugas {

    String kode, pesan;

    List <PetugasModel> hasil;

    public List<PetugasModel> getHasil() {

        return hasil;
    }

    public void setHasil(List<PetugasModel> hasil) {
        this.hasil = hasil;
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
