package teo2012;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author emn
 */
public class Secuencia {
    
    private Vector simbolos;
    private int totalDeSimbolos;
    private int cant_bits = 8;
    private int[] alfas;
    private int cantAlfas;
    
    public Vector getSimbolos(){ return this.simbolos; }
    
    public Secuencia(File path) throws IOException{      
        File file = new File(path.getAbsolutePath());
        Scanner input = new Scanner(file);
        simbolos = new Vector();
        this.totalDeSimbolos = 0;
        while (input.hasNext()) {
            String nextToken = input.next();
            //System.out.print(nextToken + " ");
            addToSimbolos(nextToken);
            this.totalDeSimbolos++;
        }
        //System.out.println(this.totalDeSimbolos);
        input.close();
        FileOutputStream fout = new FileOutputStream (path.getParent() + "/galaga.exe.txt");
        for (int i = 0; i < this.simbolos.size(); i++){
            ((Simbolo) this.simbolos.get(i)).setProbabilidad(this.totalDeSimbolos);
            new PrintStream(fout).println (((Simbolo) this.simbolos.get(i)).getSimbolo()+":"+((Simbolo) this.simbolos.get(i)).getProbabilidad());
        }
        fout.close();
    }
    
    public Secuencia(){
        simbolos = new Vector();
    }
    
    public void fromGalaga(String path) throws FileNotFoundException{
        File file = new File(path);
        Scanner input = new Scanner(file);
        this.totalDeSimbolos = 0;
        while (input.hasNext()) {
            String nextToken = input.next();
            //System.out.print(nextToken + " ");
            addSimboloFromGalaga(nextToken);
        }
        //System.out.println(this.totalDeSimbolos);
        input.close();
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
    
    public int getCantidadSimbolos(){ return this.totalDeSimbolos; }
    
    public int[] codificar(String path, Huffman h) throws FileNotFoundException{
        File file = new File(path);
        Scanner input = new Scanner(file);
        int buffer = 0;
        int cant_digitos = 0;
        int cant_simbolos = 0;
        //Bits para guardar en el alpha component;
        Vector aux = new Vector();
        while (input.hasNext()){// && cant_simbolos < 10) {
            String nextToken = input.next(); 
            String codigo = h.getCode(nextToken);
            int n = codigo.length();
            int indice = 0;
            while (n > 0){
                buffer = buffer << 1;
                if (codigo.charAt(indice) == '1'){
                    buffer = buffer | 1;
                }
                indice++;
                cant_digitos++;
                if (cant_digitos == cant_bits){
                    //System.out.println("Buffer = " + buffer + " " + cant_simbolos);
                    //alfas[cant_simbolos] = buffer;
                    aux.add(new Integer(buffer));
                    cant_simbolos++;
                    buffer = 0;
                    cant_digitos = 0;
                }
                n--;  
            }
            
        }
        input.close();
        if ((cant_digitos < cant_bits) && (cant_digitos > 0)){
            buffer = buffer << (cant_bits - cant_digitos);
            //System.out.println("Buffer = " + buffer);
            //alfas[cant_simbolos] = buffer;
            aux.add(new Integer(buffer));
        }
        this.cantAlfas = aux.size();
        //System.out.println("cantalfas: "+ this.cantAlfas);
        alfas = new int[this.cantAlfas];
        for (int i = 0; i < this.cantAlfas; i++){
            alfas[i] = ((Integer) aux.get(i)).intValue(); }
        return alfas;
    }
    
    public int getCantidadAlfas(){ return this.cantAlfas; }

    private void addSimboloFromGalaga(String nextToken) {
        String[] temp;
        String delimiter = ":";
        temp = nextToken.split(delimiter);
        Simbolo s = new Simbolo(temp[0]);
        double aDouble = Double.parseDouble(temp[1]);
        s.setProbabilidadFinal(aDouble);
        simbolos.add(s);
    }
        
}
