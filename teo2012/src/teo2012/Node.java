/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teo2012;

/**
 *
 * @author arturoiglesias
 */
public class Node {
    
    private Node left;
    private Node right;
    private String symbol;
    private double value;
    
    public Node (){

    }
    
    
    public Node (Node l, Node r, String s, double v){
        left=l;
        right=r;
        symbol=s;
        value=v;
    }
    
    public void setLeft(Node l){
        left=l;
    }
    
    public void setRight(Node r){
        right=r;
    }
    
    public void setSymbol(String s){
        symbol=s;
    }
    
    public void setValue(double v){
        value=v;
    }
    
    public Node getLeft(){
        return left;
    }
    
    public Node getRight(){
        return right;
    }
    
    public String getSymbol(){
        return symbol;
    }
    
    public double getValue(){
        return value;
    }
}
