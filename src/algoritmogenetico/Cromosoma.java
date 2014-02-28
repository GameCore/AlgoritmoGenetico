package algoritmogenetico;

import java.util.Random;

public class Cromosoma {
    double aptitud;
    int[] genes;
    boolean reproducir;
    public static int tamaño_genes = 30;
    int x,y,z;
    public Cromosoma(boolean aleatorio) {
        
         
        
        x=numaleatorio();
        y=numaleatorio();
        z=numaleatorio();
        
 

    }

    void evaluar() {
         double numerador =(2*Math.pow(x,2)) + (3*y) - (Math.pow(z,2));
         double denominador = Math.pow(x+y+z,2);
         double f = numerador/denominador;
         //f*=100;
            aptitud = f;
    }
    
    int numaleatorio(){
        int num;
    Random r = new Random();
        num =r.nextInt(50)*-1;
        num+=r.nextInt(50);
        return num;
    }

}
