/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPraktikum;

/**
 *
 * @author royma
 */
public class StudioMusik {
    //atribut
    String jam, tgl, bulan, tahun;
    private String nama, tlp;
    protected String JenisStudio;
    public int durasi, harga, total;

    //method
    public void dataNama(String Nama){
        this.nama = Nama;
    }
    public void dataTlp(String Tlp){
        this.tlp = Tlp;
    }
    public String cetakNama(){
        return nama;
    }
    public String cetakTlp(){
        return tlp;
    }
    
    //menghitung harga studio Biasa
    protected int hitBiasa(){
        harga = durasi * 45000;
        return harga;
    }
    //menghitung harga studio Lengkap
    protected int hitLengkap(){
        harga = durasi * 55000;
        return harga;
    }
    //method untuk overriding dan overloading
    protected int hitBiaya(){
        return 0;
    }
    //method untuk Tambah Sewa
    protected int hitBiaya(int biasa, int lengkap){
        harga = durasi * (biasa+lengkap);
        return harga;
    }
}
