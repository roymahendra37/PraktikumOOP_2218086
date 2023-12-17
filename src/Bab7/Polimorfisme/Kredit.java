/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab7.Polimorfisme;

/**
 *
 * @author royma
 */
public class Kredit {
    void cekKartuKredit(String norek, String input){
        if(norek.equals(input)){
            System.out.println("Pembayaran kredit sukses");
        }else{
            System.out.println("Pembayaran Gagal, kata sandi salah");
        }
    }
}
