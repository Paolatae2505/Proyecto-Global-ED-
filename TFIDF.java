import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class TFIDF {
    // DOS METODOS
    /**
     * Calcular el TF
     * Calcular el IDF
     * Calcula la frecuencia de los terminos f(t,d)
     * Calcule todo el final
     * Pase cada palabra de un String a una lista esta lista la resivira f
     */
    // Metodos

    /**
     * Busca la frenceuncia de la palabra en un documento
     *
     * @param termino
     * @param documento COMO TAL UN DOC
     * @return
     */  // Maximo el jueves
    public static int f(String termino, File documento) throws IOException {
        String[] words = null;  //Intialize the word Array
        FileReader fr = new FileReader(documento);  //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
        int count = 0;
        String s = "";
        termino = termino.replaceAll("\\W+", "");
        while ((s = br.readLine()) != null) {
            words = s.split(" ");
            for (String word : words) {
                word = word.replaceAll("\\W+", "");
                if (word.equalsIgnoreCase(termino)) { // quita las minusculas y mayusculas
                    count++;
                }
            }
        }
        fr.close();
        return count;
    }

    /**
     * Calcula el TF de la palabra en cada documento (INDIVIDUAL)
     *
     * @param termino
     * @param d
     * @return
     */
    public double TF(String termino, File d) {
        double resultado = 0;
        int frecuencia = 0;
        try {
            frecuencia = f(termino, d);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception ei) {
            System.out.println(ei.getMessage());
        }
        if (frecuencia != 0) {
            resultado = ((Math.log10(frecuencia)) / (Math.log10(2))) + 1;
        } else {
            resultado = 0;   // si la frecuencia es 0 entonces el tf es 0
        }
        return resultado;
    }

    /**
     * Calcula el IDF de la plabra en todos los documentos (Global)
     *
     * @param termino
     * @return
     */
    public double IDF(String termino, List<File> docs) {
        double frecuencia = 0;
        int counter = 0;
        double resultado = 0;
        for (File doc : docs) {
            try {
                frecuencia = f(termino, doc);
            } catch (IOException exp) {
                System.out.println(exp.getMessage());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            if (frecuencia != 0) {
                counter++;
            }
        }
        if (counter == 0) {
            resultado = 0;
        } else {
            int n = docs.size();
            resultado = ((Math.log10(n / counter)) / (Math.log10(2)));
        }
        return resultado;
    }

    public double TF_IDF(double tf, double idf) {
        return tf * idf;
    }

    /**
     * ENTONCES PARA OBTENER CADA SIMP TIENES QUE IR ITERANDO EN
     * EL METODO COMPARAR ESTE SIMP CON LA LISTA.
     * ESTE METODO CALCULA SOLO EL SIMP DE CADA DOCUMENTO
     * @param d        para obtener la longuitud de la lista en d no por que itere en la lista d.
     * @param consulta recibe la consulta para separarla en terminos
     * @param doc      documento en el que se buscará el termino correspondiente
     * @return
     */
    public double sim(List<File> d, String consulta, File doc) {
        String[] terminos = consulta.split("\"\\\\s+|,\\\\s*|\\\\.\\\\s*\"");
        double tf, idf, tfIdf;
        double dividendo = 0;
        double divisor = 0;
        for (String termino : terminos) {
            idf = IDF(termino, d);
            tf = TF(termino, doc);
            tfIdf = TF_IDF(tf, idf);
            dividendo += tfIdf;
            divisor += Math.pow(tfIdf, 2);
        }
        if (divisor != 0.0) {
            return dividendo / Math.sqrt(divisor);
        } else return 0;
    }
}

