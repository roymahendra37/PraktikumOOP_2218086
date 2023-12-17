/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPraktikum;

/**
 *
 * @author royma
 */
public class BatalSewa extends Denda implements Admin {
    //atribut
    public int durasi;
    private String nama, tlp;
    
    //setter atribut nama
    public void dataNama(String nama) {
        this.nama = nama;
    }
    //setter atribut tlp
    public void dataTlp(String tlp) {
        this.tlp = tlp;
    }
    //getter atribut nama
    public String cetakNama() {
        return nama;
    }
    //getter atribur tlp
    public String cetakTlp() {
        return tlp;
    }
    
    //mendefinisikan abstract method untuk menghitung denda
    @Override
    public int hitDenda(){
        return durasi * getDenda();
    }
    //mendefinisikan abstract method pada interface untuk mencetak admin
    @Override
    public String Admin(){
        return admin;
    }
}
