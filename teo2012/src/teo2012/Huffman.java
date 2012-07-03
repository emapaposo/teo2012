/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teo2012;
import java.util.Vector;
import teo2012.Node;
/**
 *
 * @author emn
 */
public class Huffman {
 
    /**
    * 
    */
    private Vector<Node> arreglo=new Vector();
    
    public Huffman(Vector<Node> v1){
        arreglo=v1;
    }
            
    public void huffmanTree(){
        // Ordenar la lista de porbabilidades
        if (arreglo.size()>1){
            sort();
            Node izq= arreglo.lastElement();
            arreglo.removeElementAt(arreglo.size()-1);
            Node der= arreglo.lastElement();
            arreglo.removeElementAt(arreglo.size()-1);
            Node nuevo=new Node(izq, der, "NuevoNodo", (Math.round(izq.getValue() + der.getValue())));
            arreglo.add(nuevo);
            huffmanTree();
        }
    }
    
    public void printTree(Node test, String a){
        if (test.esHoja()) {
            
            System.out.println(a + ": " + test.getSymbol());
        }
        else{
            printTree(test.getLeft(),a+="0");
            a=a.substring(0, a.length()-1);
            printTree(test.getRight(),a+="1");
            a=a.substring(0, a.length()-1);
        }
            
    }
    
    public Vector<Node> getHuffmantree(){
        if (arreglo.size() >1){
            huffmanTree();
        }
        printTree(arreglo.elementAt(0),"");
        return arreglo;
    }
    
    
    private void sort(){
        Node aux=new Node();
        for (int i=0; i< arreglo.size()-1;i++){
             for (int j=i; j <arreglo.size();j++){
                if (arreglo.elementAt(i).getValue()< arreglo.elementAt(j).getValue()){
                    copy(arreglo.elementAt(j), aux);
                    copy(arreglo.elementAt(i),arreglo.elementAt(j));
                    copy(aux,arreglo.elementAt(i));
                }
             }
        }
    }
    
    private void copy(Node ori, Node aux){
          aux.setLeft(ori.getLeft());
          aux.setRight(ori.getRight());
          aux.setSymbol(ori.getSymbol());
          aux.setValue(ori.getValue());
                    
    }
 
    /**
    * 
    */
    public void unDoIt(){
    
    }

}
