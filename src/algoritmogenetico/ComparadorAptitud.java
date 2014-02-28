package algoritmogenetico;

import java.util.Comparator;

public class ComparadorAptitud implements Comparator<Cromosoma> {
    @Override
    public int compare(Cromosoma o1, Cromosoma o2) {
        if(o1.aptitud - o2.aptitud>0)
        return 1;
        
        else if(o1.aptitud - o2.aptitud<0)
            return -1;
        
        else
            return 0;
    }
}
