package com.example.demo1;

public class Ogrenci {
    private String tcNo;
    private String ad;
    private String telefon;
    private String cinsiyet;
    private String bolum;

    public Ogrenci(String tcNo, String ad, String telefon, String cinsiyet, String bolum) {
        this.tcNo = tcNo;
        this.ad = ad;
        this.telefon = telefon;
        this.cinsiyet = cinsiyet;
        this.bolum = bolum;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }
}