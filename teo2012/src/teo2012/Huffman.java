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
            Node ultimo= arreglo.lastElement();
            arreglo.removeElementAt(arreglo.size());
            Node anteUltimo= arreglo.lastElement();
            arreglo.removeElementAt(arreglo.size());
            Node nuevo=new Node(ultimo, anteUltimo, "NuevoNodo", ultimo.getValue() + anteUltimo.getValue());
            arreglo.add(nuevo);
            huffmanTree();
        }
    }
    
    public Vector<Node> getHuffmantree(){
        if (arreglo.size() >1){
            huffmanTree();
        }
        return arreglo;
    }
    
    
    private void sort(){
        Node aux=new Node();
        for (int i=0; i< arreglo.size();i++){
             for (int j=0; j <arreglo.size()-1;j++){
                if (arreglo.elementAt(i).getValue()> arreglo.elementAt(j).getValue()){
                    copy(arreglo.elementAt(i), aux);
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
          aux.setLeft(ori.getLeft());
                    
    }
 
    /**
    * 
    */
    public void unDoIt(){
    
    }

}
