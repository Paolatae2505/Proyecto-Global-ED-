import java.io.File;
import java.util.*;
import java.util.Map.Entry;

public class Busqueda {

    public List<String> compara(List<File> docs, String consulta) {
        List<String> resultado = new ArrayList<>();
        double sim;
        /*Se crea mapa con key = nombre de archivo, value = sim */
        Map<String, Double> simPorDoc = new Hashtable<>();
        for (File doc : docs) {
            sim = new TFIDF().sim(docs, consulta, doc);
            if (sim != 0) {
                simPorDoc.put(doc.getName(), sim);
            }
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

    public void imprimeHistorial(Stack<String> historial) {
        Stack<String> imprimirHistorial = new Stack<String>();
        String s;
        while (!historial.isEmpty()) {
            s = historial.pop();
            imprimirHistorial.push(s);
        }

        for (String h : imprimirHistorial) {
            System.out.println(h);
        }
    }

    public List<String> containsCache(Map<String, List<String>> d, String consulta) {
        String key = "";
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
