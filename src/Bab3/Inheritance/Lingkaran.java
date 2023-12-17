/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab3.Inheritance;

/**
 *
 * @author royma
 */
public class Lingkaran {
    //atribut
    int r;
    double phi, luas;
    
    //constructor
    public Lingkaran(){
        r = 7;
        phi = 3.14;
    }
    //method
    void Deskripsi(){
        System.out.println("Ini adalah hasil menghiting");
    }
    //method menghitung luas
    double HitLuasLingkaran(){
        //L = phi r2
        luas = (phi*r*r);
        return luas;
    }
}
