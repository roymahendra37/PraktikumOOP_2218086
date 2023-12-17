/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab6.Abstract;

/**
 *
 * @author royma
 */
public class MainKendaraan {
    public static void main(String[] args) {
        Mobil m = new Mobil();
        System.out.println("Mobil " +m.Bergerak());
        Pesawat p = new Pesawat();
        System.out.println("Pesawat " +p.Bergerak());
        Kapal k = new Kapal();
        System.out.println("Kapal "+k.Bergerak());
    }
}
