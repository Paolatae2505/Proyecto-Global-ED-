import java.io.File;
import java.util.*;

public class Busqueda {

    //// MÉTODOS ///

    public void compara(List<File> docs, String consulta) {
        /*Se crea arbol rojinegro que contiene al documento como valor
         * y a sim como key */
        Map<Double, File> simPorDoc = new TreeMap<Double, File>();
        for (File doc : docs) {
            simPorDoc.put(new TFIDF().sim(docs, consulta, doc), doc);
        }
        /*Obtengo el arbol de reversa para imprimir los 10 con el
         * sim más alto*/
        Set set = simPorDoc.entrySet();
        Iterator iterator = ((Set) set).iterator();

        // Imprimir elementos en reversa
        int i = 0;
        while (iterator.hasNext() && i < 10) {
            Map.Entry em = (Map.Entry) iterator.next();
            System.out.println(em.getValue());
            i++;
        }
    }

    //**HISTORIAL(VIC)*/

    ///**CACHÉ (PAO)*/

}
