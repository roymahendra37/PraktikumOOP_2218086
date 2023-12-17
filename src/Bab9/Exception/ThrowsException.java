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
public class ThrowsException {
    static void Error() throws ClassNotFoundException{
        System.out.println("Ada yang error nih");
        throw new ClassNotFoundException("error sudah saya tangkap");
    }
    public static void main(String[] args) {
        try{
            ThrowsException.Error();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
