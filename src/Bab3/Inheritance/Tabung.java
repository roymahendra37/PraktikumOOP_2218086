/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab3.Inheritance;

/**
 *
 * @author royma
 */
public class Tabung extends Lingkaran {
    int t;
    double volume,luaspermukaan;
    
    public Tabung(){
        t = 20;
    }
    
    void Keterangan(){
        Deskripsi();
        System.out.println("Menghitung volume tabung");
    }
    
    double HitvolumeTabung(){
        volume = ((phi*r*r)*t);
        return volume;
    }
}
