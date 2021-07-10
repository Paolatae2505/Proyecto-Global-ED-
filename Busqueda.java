import java.io.File;
import java.util.*;

public class Busqueda {
    public Stack<String> historial = new Stack<>();

    public void compara(List<File> docs, String consulta) {
        historial.push(consulta);
        /*Se crea arbol rojinegro que contiene al documento como valor
         * y a sim como key */
        Map<Double, File> simPorDoc = new TreeMap<>();
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
    public void imprimirHistorial(){
        historial.forEach(System.out::println);
    }

    ///**CACHÉ (PAO)*/

}
