package algoritmogenetico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class AlgGenetico {
    boolean haTerminado;
    public ArrayList<Cromosoma> poblacion;
    int tamaño_poblacion;
    public AlgGenetico(int tamaño_poblacion){
        this.tamaño_poblacion = tamaño_poblacion;
        poblacion = new ArrayList<Cromosoma>();
    }

    void inicializar_poblacion() {
        for(int i =0;i<tamaño_poblacion;i++){
            poblacion.add(GenerarCromosoma());
        }
    }

    void evaluar_poblacion() {
        for(int i = 0;i<poblacion.size();i++){
            poblacion.get(i).evaluar();            
        }
    }

    void seleccionar_poblacion() {
      /*  Collections.sort(poblacion,new ComparadorAptitud());
        Collections.reverse(poblacion);*/
        burbujaPoblacion();
        for(int i = 0 ;i<100;i++){
            poblacion.get(i).reproducir = true;
        }
    }

    void reproducir_poblacion() {
        
        ArrayList<Cromosoma> aptosReproduccion = new ArrayList<Cromosoma>();
        for(Cromosoma e: poblacion){
            if(e.reproducir){
                aptosReproduccion.add(e);
            }
        }
        /*for(int i =0;i<aptosReproduccion.size()-1;i++){
            Cromosoma a = poblacion.get(i);
            Cromosoma b = poblacion.get(i+1);
            Cromosoma hijo = reproducir(a,b);
            poblacion.add(hijo);
        }*/
        for(int i =0;i<aptosReproduccion.size();i++){
            for(int j = i+1;j<aptosReproduccion.size();j++){
                Cromosoma a = poblacion.get(i);
                Cromosoma b = poblacion.get(j);                
                Cromosoma hijo = reproducir(a,b);
                hijo.evaluar();
                poblacion.add(hijo);
            }
        }
    }

    void mutar_poblacion() {
       
        Random condicion=new Random();
        for(Cromosoma e: poblacion){
     double condicion2 = condicion.nextDouble();
     int condicion1 = condicion.nextInt(49);
     double condicionAleatoria =condicion1+condicion2;
        
      if(e.x<49.999 && e.y<49.999 && e.z<49.999){
          if(e.x>-49.999 && e.y>-49.999 && e.z>-49.999){
                
              if(e.x > condicionAleatoria){
                e.x+=0.001;
                }
               else{
                 e.x-=0.001;
                   }
     
           if(e.y > condicionAleatoria){ 
               e.y+=0.001;
           }
           else{
           e.y-=0.001;
           }
           
           if(e.z > condicionAleatoria){ 
               e.z+=0.001;
           }
           else{
               e.z-=0.001;
           }
           
      }
     }     
    }
   }
    


    private Cromosoma GenerarCromosoma() {
        return new Cromosoma(true);
    }

    

    private Cromosoma reproducir(Cromosoma ana, Cromosoma beto) {
        Cromosoma hijo = new Cromosoma(false);

           hijo.x = (ana.x+beto.x)/2;
           hijo.y = (ana.y+beto.y)/2;
           hijo.z = (ana.z+beto.z)/2;
        
        return hijo;
    }

    void reemplazar_poblacion() {
        Random eliminar = new Random();
        
      /*  Collections.sort(poblacion,new ComparadorAptitud());
        Collections.reverse(poblacion);*/
        int a; 
        
        
        while(poblacion.size() > 1000 ){
            a = poblacion.size();
            a=eliminar.nextInt(a);
            
            poblacion.remove(a);
        }
    }
    
    void burbujaPoblacion(){
  ArrayList<Cromosoma>  poblacionAux = new ArrayList<Cromosoma>();
        for(int i = 0; i< poblacion.size();i++){
            for(int j = 1+1;j<poblacion.size();j++){
                if(poblacion.indexOf(i)> poblacion.indexOf(j) ){
                    poblacion.indexOf(poblacion.get(i));
                    int aux = poblacion.indexOf(i);
                   poblacionAux.add( poblacion.get(i));
                    poblacion.set(i,poblacion.get(j));
                    poblacion.set(aux, poblacionAux.get(aux)) ; 
                   
          }
        }
      }
    }
    
}
    
        

