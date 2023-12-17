/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab9.Exception;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author royma
 */
public class Lat_exception {
    public static void main(String[] args) {
        try{
            int a,b ,hasil;
            Scanner keyboard = new Scanner(System.in);
            System.out.println("PROGRAM PEMBAGIAN");
            System.out.println("Masukkan angka ke 1 : ");
            a = Integer.parseInt(keyboard.next());
            System.out.println("Masukkan angka ke 2 : ");
            b = Integer.parseInt(keyboard.next());
            hasil = a/b;
            System.out.println("hasil : "+ Integer.toString(hasil));
        }catch(ArithmeticException c){
            JOptionPane.showMessageDialog(null, "NILAI PEMBAGI TIDAK BOLEH 0", "Warning",2);
        }catch(NumberFormatException d){
            JOptionPane.showMessageDialog(null, "INPUT YANG ANDA MASUKKAN BERUPA HURUF", "Warning",2);
        }finally{
            System.out.println("TERIMAKASIH SUDAH MENJALANKAN PROGRAM");
        }
    }
}
