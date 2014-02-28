package algoritmogenetico;

public class ClasePrincipal {
    
    public static void main(String[] args) {
        AlgGenetico ag = new AlgGenetico(1000);
        ag.inicializar_poblacion();
        int numero_generaciones = 1;
        while(numero_generaciones <= 100){
            ag.evaluar_poblacion();
            ag.seleccionar_poblacion();
            ag.reproducir_poblacion();
            ag.mutar_poblacion();
            ag.evaluar_poblacion();
            ag.reemplazar_poblacion();
            numero_generaciones++;
        }    
        for(Cromosoma e: ag.poblacion)
            imprimir(e);
    }

    private static void imprimir(Cromosoma cromosoma) {
        System.out.printf("aptitud: %d\n",cromosoma.aptitud);
     
        for(int i = 0; i<cromosoma.genes.length;i++){
            if(i>0) 
                System.out.print(",");            
                System.out.printf("%d",cromosoma.genes[i]);
        }
        
        System.out.println();
    }
}
