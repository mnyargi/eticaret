package com.example.melik.isbakdeneme;

public class Ilan {
    private static String ilanAdi,isverenAdi,kategori,ilanAciklama;

    public Ilan(String ilanAdi, String  ilanAciklama, String isverenAdi,String kategori) {
        super();
        this.ilanAdi = ilanAdi;
        this.ilanAciklama = ilanAciklama;
        this.isverenAdi = isverenAdi;
        this.kategori = kategori;
    }

    public static String getIsverenAdi() {
        return isverenAdi;
    }
    public static String getIlanAdi() {
        return ilanAdi;
    }
    public static String getIlanAciklama(){ return  ilanAciklama;}
    public static String getKategori(){ return kategori;}


    public void setIlanAdi(String ilanAdi) {
        this.ilanAdi = ilanAdi;
    }
    public void setIlanAciklama(String ilanAciklama) {
        this.ilanAciklama = ilanAciklama;
    }
    public void setIsverenAdi(String isverenAdi) {
        this.isverenAdi = isverenAdi;
    }
    public void setKategori(String kategori) { this.kategori= kategori; }

}
