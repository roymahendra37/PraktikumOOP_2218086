/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPraktikum;

/**
 *
 * @author royma
 */
public class TambahSewa extends StudioMusik{
    //atribut tambahan
    protected int tambah;
    public int biasa, lengkap;
 
    //menghitung harga tambah biaya studio biasa
    @Override
    public int hitBiaya(){
        tambah = hitBiaya(biasa, lengkap);
        return tambah;
    }
}
