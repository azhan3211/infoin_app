package com.r.seminarevent.Model;

/**
 * Created by Unknown on 3/16/2018.
 */

public class SeminarEventData {

    private String nama, tanggal, waktu;

    public SeminarEventData(String nama, String tanggal, String waktu) {
        this.nama = nama;
        this.tanggal = tanggal;
        this.waktu = waktu;
    }

    public String getNama() {
        return nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getWaktu() {
        return waktu;
    }
}
