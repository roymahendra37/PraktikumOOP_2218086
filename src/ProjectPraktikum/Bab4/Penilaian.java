/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectPraktikum.Bab4;

import ProjectPraktikum.Bab3.*;

/**
 *
 * @author royma
 */
public class Penilaian {
    public String NIM, nama, kode_mk;
    private int NP1,NP2, NP3, NilaiPrak, UTS, UAS;
    double nilaiProses(){
        return((NP1*0.1)+(NP2*0.2)+(NP3*0.1)+(UTS*0.2)+(NilaiPrak*0.4));
    }
    double nilaiAkhir(){
        return (nilaiProses()*0.6)+(UAS*0.3);
    }
    double tampilNA(){
        return nilaiAkhir();
    }
    double nilaiKeaktifan(){
        return 0;
    }
    public int getNP1() {
        return NP1;
    }
    public int getNP2() {
        return NP2;
    }
    public int getNP3() {
        return NP3;
    }
    public int getNilaiPrak() {
        return NilaiPrak;
    }
    public int getUTS() {
        return UTS;
    }
    public int getUAS() {
        return UAS;
    }
    public void setNP1(int NP1) {
        this.NP1 = NP1;
    }
    public void setNP2(int NP2) {
        this.NP2 = NP2;
    }
    public void setNP3(int NP3) {
        this.NP3 = NP3;
    }
    public void setNilaiPrak(int NilaiPrak) {
        this.NilaiPrak = NilaiPrak;
    }
    public void setUTS(int UTS) {
        this.UTS = UTS;
    }
    public void setUAS(int UAS) {
        this.UAS = UAS;
    }

}
