import java.io.File;
import java.util.*;
import java.util.Map.Entry;
import javax.swing.*;
import java.awt.event.*;
/**
 * Implementacion Clase busqueda de palabra
 * @author Baron Herrera Victoria
 * @author Vargas Bravo Paola
 * @version 1.0 (17 de Julio 2021)
 * @since Estructuras de datos 2021-2.
 */

public class Busqueda extends JFrame {
    /**
     * Busca los 10 documentos de mayor coincidencia con la consulta.
     * @param docs     Recibe una lista de documentos.
     * @param consulta Palabra a buscar.
     * @return Lista con los 10 archivos que mejor coinciden con la consulta.
     */
    public List<String> compara(List<File> docs, String consulta, JProgressBar barra){
        barra.setVisible(true);
        List<String> resultado = new ArrayList<>();
        double sim;
        Map<String, Double> simPorDoc = new Hashtable<>();
        double j = 1;
        double r = docs.size();
        int porcentaje=0; //si no es int, marca error, si es int, no carga
        barra.setValue(0);
        try{
            for (File doc : docs) {
                porcentaje = (int) ((j / r) * 100);
                barra.setValue(porcentaje);
                Thread.sleep(1000);
                sim = new TFIDF().sim(docs, consulta, doc);
                System.out.printf("----- Progreso : %.2f", porcentaje);
                System.out.println("%-----");
                if (sim != 0) {
                    simPorDoc.put(doc.getName(), sim);
                }
            j++;
            } 
        }catch (Exception e) {
        }
        if (porcentaje >= 100)
            {
               barra.setVisible(false);
            } 
        if (simPorDoc.isEmpty()) {
            resultado.add("No hay coincidencias.");
            System.out.println("no esta bien");
        } else {
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
                if (key.equalsIgnoreCase(consulta)) {
                    return d.get(consulta);
                }
            }
        }
        return null;
    }

}

