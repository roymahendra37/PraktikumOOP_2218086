/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab7.Polimorfisme;

/**
 *
 * @author royma
 */
public class Emoney implements dapatDiscan{
    @Override
    public void scanQris(){
        System.out.println("Pembayaran lewat QRcode : 91257237523752375");
        System.out.println("Pembayaran Berhasil !!!!!!!!");
    }
}
