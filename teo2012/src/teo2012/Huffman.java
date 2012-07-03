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
            
    public void huffmanTree(){
        // Ordenar la lista de porbabilidades
        if (arreglo.size()>1){
            sort();
            Node ultimo= arreglo.lastElement();
            arreglo.removeElementAt(arreglo.size());
            Node anteUltimo= arreglo.lastElement();
            arreglo.removeElementAt(arreglo.size());
            Node nuevo=new Node(ultimo, anteUltimo, "NuevoNodo", ultimo.getValue() + anteUltimo.getValue());
            arreglo.add(nuevo);
            huffmanTree();
        }
    }
    
    
    
    private void sort(){
        for (int =o)
    }
 
    /**
    * 
    */
    public void unDoIt(){
    
    }

}
