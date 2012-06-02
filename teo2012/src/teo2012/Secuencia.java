/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teo2012;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author emn
 */
public class Secuencia {
    
    private Vector simbolos;
    
    public Secuencia(String path) throws FileNotFoundException{
        File file = new File(path);
        Scanner input = new Scanner(file);
        simbolos = new Vector();
        while (input.hasNext()) {
            String nextToken = input.next();
            System.out.print(nextToken + " ");
            //String nextLine = input.nextLine();
        }
        input.close();
    }
    
    private void addToSimbolos(String simbolo){
        
    }
    
}
