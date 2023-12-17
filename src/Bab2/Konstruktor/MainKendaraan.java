/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab2.Konstruktor;

/**
 *
 * @author royma
 */
public class MainKendaraan {
    public static void main(String[] args) {
        //membuat objek
        Kendaraan mobil = new Kendaraan();
        //mengubah property
        mobil.nama = "Pajero Sport";
        System.out.println("Nama Kendaraan : "+ mobil.nama);
       // mobil.nama = "Pajero Sport";
        System.out.println("Warna Kendaraan : "+ mobil.warna);
        System.out.println("Pabrikan Kendaraan : "+ mobil.pabrikan);
        System.out.println("Speed Kendaraan : "+ mobil.speed+"km/jam");
        System.out.println("Cara kendaraan bergerak : ");
        System.out.println("Saat maju : ");
        mobil.kendaraanMaju();
        System.out.println("Saat mundur : ");
        mobil.kendaraanMundur();
        System.out.println("Saat berhenti : ");
        mobil.kendaraanBerhenti();
    }
}
