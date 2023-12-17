/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab6.Abstract;

/**
 *
 * @author royma
 */
public class JajarGenjang extends BangunDatar{
    double a,t,b;
    public JajarGenjang() {
        a = 8;
        t = 3;
        b = 9;
    }
    
    @Override
    double luas(){
        return (a*t);
    }
    
    @Override
    double keliling(){
        return (2 * (a + b));
    }
}
