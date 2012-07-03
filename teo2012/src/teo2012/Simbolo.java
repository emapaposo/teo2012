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
    
    private String simbolo;
    private int cantidad;
    private double probabilidad;

    public Simbolo(String simbolo) {
        this.simbolo = simbolo;
        this.cantidad = 1;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    public void add() {
        this.cantidad++;
    }
    
    public void setProbabilidad(int total){
        this.probabilidad = cantidad / total;
    }
    
    public double getProbabilidad(){return this.probabilidad;}
}
