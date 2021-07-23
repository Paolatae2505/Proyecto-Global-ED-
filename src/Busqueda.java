import java.io.File;
import java.util.*;
import java.util.Map.Entry;

/**
 * Implementacion Clase busqueda de palabra
 *
 * @author Baron Herrera Victoria
 * @author Vargas Bravo Paola
 * @version 1.0 (17 de Julio 2021)
 * @since Estructuras de datos 2021-2.
 */

public class Busqueda {

    /**
     * Busca si una palabra esta en el cache
     *
     * @param docs     --Lista de documentos
     * @param consulta -- Palabra a buscar
     * @return Los 10 documentos con coincidencia mas alta
     */
    public List<String> compara(List<File> docs, String consulta) {
        List<String> resultado = new ArrayList<>();
        double sim;
        Map<String, Double> simPorDoc = new Hashtable<>();
        int j = 1;
        double r = docs.size();
        double porcentaje;
        for (File doc : docs) {
            porcentaje = (j / r) * 100;
            sim = new TFIDF().sim(docs, consulta, doc);
            System.out.printf("----- Progreso : %.2f", porcentaje);
            System.out.println("%-----");
            if (sim != 0) {
                simPorDoc.put(doc.getName(), sim);
            }
            j++;
        }
        if (simPorDoc.isEmpty()) {
            resultado.add("No hay coincidencias.");
        } else {
            //Regresar los valores más altos de sim en el árbol (max 10)
            Set<Entry<String, Double>> entradas = simPorDoc.entrySet();
            List<Entry<String, Double>> list = new ArrayList<>(entradas);
            list.sort(Entry.<String, Double>comparingByValue().reversed());

            int i = 0;
            for (Entry<String, Double> e : list) {
                if (i < 10) {
                    resultado.add(e.getKey());
                    i++;
                }
            }
        }
        return resultado;
    }

    /**
     * Busca si una palabra esta en el cache
     *
     * @param d        --- Cache con los termino y resultados
     * @param consulta -- Palabra a buscar
     * @return Resultados de busqueda de la Palabra
     */
    public List<String> containsCache(Map<String, List<String>> d, String consulta) {
        String key;
        if (d.containsKey(consulta)) {
            for (Map.Entry<String, List<String>> entry : d.entrySet()) {
                key = entry.getKey();
                if (key.equals(consulta)) {
                    return d.get(consulta);
                }
            }
        }
        return null;
    }

}
