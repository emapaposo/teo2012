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
    private int totalDeSimbolos;
    
    public Secuencia(String path) throws FileNotFoundException{
        File file = new File(path);
        Scanner input = new Scanner(file);
        simbolos = new Vector();
        this.totalDeSimbolos = 0;
        while (input.hasNext()) {
            String nextToken = input.next();
            //System.out.print(nextToken + " ");
            //String nextLine = input.nextLine();
            addToSimbolos(nextToken);
            this.totalDeSimbolos++;
        }
        input.close();
        for (int i = 0; i < this.simbolos.size(); i++){
            ((Simbolo) this.simbolos.get(i)).setProbabilidad(this.totalDeSimbolos);
            //System.out.println(((Simbolo) this.simbolos.get(i)).getProbabilidad());
        } 
    }
    
    private boolean simbolosContains(String simbolo){
        for (int i = 0; i < this.simbolos.size(); i++){
            if (((Simbolo) this.simbolos.get(i)).getSimbolo().equals(simbolo)){
                return true;
            }
        }
        return false;
    }
    
    private void addToSimbolos(String simbolo){
        if (!simbolosContains(simbolo)){
            Simbolo s = new Simbolo(simbolo);
            simbolos.add(s);
        }else{
            boolean seguir = true;
            for (int i = 0; i < this.simbolos.size() && seguir; i++){
                if (((Simbolo) this.simbolos.get(i)).getSimbolo().equals(simbolo)){
                    ((Simbolo) this.simbolos.get(i)).add();
                    seguir = false;
                }
            }
        }
    }
    
}
