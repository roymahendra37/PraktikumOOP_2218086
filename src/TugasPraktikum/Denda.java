/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPraktikum;

/**
 *
 * @author royma
 */
public abstract class Denda {
    //atribut
    private int denda;
    
    //konstruktor
    public Denda() {
        this.denda = 5000;
    }
    
    //method getter
    public int getDenda() {
        return denda;
    }
    
    //method abstract
    abstract int hitDenda();
}
