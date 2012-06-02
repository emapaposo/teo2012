/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teo2012;

/**
 *
 * @author emn
 */
public class Simbolo {
    
    private char simbolo;
    private int cantidad;

    public Simbolo(char simbolo) {
        this.simbolo = simbolo;
        this.cantidad = 1;
    }

    public int getCantidad() {
        return cantidad;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void add() {
        this.cantidad++;
    }
}
