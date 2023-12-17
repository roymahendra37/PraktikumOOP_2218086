/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab6.Abstract;

/**
 *
 * @author royma
 */
public class LayangLayang extends BangunDatar {
    double d1,d2, a, b;

    public LayangLayang() {
        d1 = 5;
        d2 = 6;
        a = 12;
        b = 35;
    }
    
    @Override
    double luas(){
        return (0.5 * d1 * d2);
    }
    
    @Override
    double keliling(){
        return (2 * (a + b));
    }
}
