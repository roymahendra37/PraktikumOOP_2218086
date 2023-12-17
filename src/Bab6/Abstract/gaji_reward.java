/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bab6.Abstract;

/**
 *
 * @author royma
 */
public class gaji_reward extends gaji_abs_reward {
    double waktu, menit, tunj_bonus, gajipokok, tunj_anak, anak;
    
    @Override
    double tunjanganAnak(){
        if(anak == 1){
            tunj_anak = 0.10* gajipokok ;
        }
        else if (anak > 1){
            tunj_anak = 0.20 * gajipokok;
        }
        else{
            tunj_anak = 0;
        }
        return tunj_anak ;
    }
    @Override
    double lembur(){
        waktu = (menit/60);
        return (waktu*25000);
    }
}
