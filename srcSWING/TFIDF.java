import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
/**
 * Implementacion Clase para calcular el TF e IDF
 * @author Baron Herrera Victoria
 * @author Vargas Bravo Paola
 * @version 1.0 (17 de Julio 2021)
 * @since Estructuras de datos 2021-2.
 */
public class TFIDF{
    // Metodos
    /**
     * Busca la frenceuncia de la palabra en un documento
     * @param termino --- Termino a busar en el documento 
     * @param documento --- Documento para buscar termino
     * @return
     */  
    private int f(String termino, File documento) throws IOException {
        String[] words = null;  
        FileReader fr = new FileReader(documento);  
        BufferedReader br = new BufferedReader(fr);
        int count = 0;
        String s = "";
        termino = termino.replaceAll("\\W+", "");
        while ((s = br.readLine()) != null) {
            words = s.split(" ");
            for (String word : words) {
                word = word.replaceAll("\\W+", "");// Quita los caracteres especiales
                if (word.equalsIgnoreCase(termino)){ // Quita las minusculas y mayusculas
                    count++;
                }
            }
        }
        fr.close();
        return count;
    }

    /**
     * Calcula el TF de la palabra en un Documento
     * @param termino --- Temrino en el documento
     * @param doc ------- Documento
     * @return
     */
    private double TF(String termino, File doc) {
        double resultado = 0;
        int frecuencia = 0;
        try {
            frecuencia = f(termino, doc);
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
     * Calcula el IDF de la Palabra en todos los documentos
     * @param termino --- Termino a buscar
     * @param docs --- Lista de documentos
     * @return resultado IDF
     */
    private double IDF(String termino, List<File> docs) {
        double frecuencia = 0;
        double counter = 0;
        double resultado = 0;
        double div = 0;
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
            int n = docs.size() + 1;
            div = (n / counter);
            resultado = ((Math.log10(div)) / (Math.log10(2)));
        }
        return resultado;
    }

    /**
     * Calcula la multiplicacion del TF e IDF
     * @param tf --- resultado de tf
     * @param idf ---- resultado de idf 
     * @return multiplicacion de tf e idf 
     */

    private double TF_IDF(double tf, double idf) {
        return tf * idf;
    }

    /** 
     * Calcula el Sim de una palabra en un documento 
     * @param d --- Lista de documentos
     * @param consulta --- Consulta en documento
     * @param doc --- Documento a obtener sim
     * @return
     */
    public double sim(List<File> d, String consulta, File doc) {
        String[] terminos = consulta.split(" ");
        double tf = 0;
        double idf = 0;
        double tfIdf = 0;
        double dividendo = 0;
        double divisor = 0;
        double raiz = 0;
        for (String termino : terminos) {
            tf = TF(termino, doc);
            idf = IDF(termino, d);
            if (idf != 0 && tf != 0 || idf == 0 && tf != 0) {
                tfIdf = TF_IDF(tf, idf);
                dividendo = dividendo + tfIdf;
                divisor = divisor + Math.pow(tfIdf,2);
            } else {
                return 0;
            }
        }
        raiz = Math.sqrt(divisor);
        return ((dividendo) / (raiz));
    }
}
