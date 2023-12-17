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
public class ThrowException {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int jmlkaki;
        System.out.println("Berapa jumlah kaki kerbau : ");
        try{
            System.out.println("jumlah kaki : ");
            jmlkaki = input.nextInt();
            if(jmlkaki!=4){
                throw new NullPointerException("Terjadi Kesalahan Nih!");
            }else{
                System.out.println("Benar Jumlah Kaki Kerbau 4");
            }
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }
}
