/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab8.Interface;

/**
 *
 * @author royma
 */
public class Pesawat extends kendaraan implements Berjalan, Terbang {
    public Pesawat(String merek){
        super(merek);
    }
    
    @Override
    void carabergerak(){
        System.out.println("Pesawat bergerak dalam udara dengan menggunakan mesin-mesin yang memungkintkan untuk terbang");
    }
    
    @Override
    void kecepatanMax(){
        System.out.println("900km/h");
    }
    @Override
    public void berjalan(){
        System.out.println("Pesawat "+getMerek()+" berjalan maju melalui roda yang bersentuhan langsung dengan tanah");
    }
    
    @Override
    public void terbang(){
        System.out.println("Pesawat "+getMerek()+" mesin berkecepatan tinggi, baling2 dan sayap aerodinamic memungkinkannya pesawat lepas landas,terbang");
    }
}
