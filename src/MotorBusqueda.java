import java.io.File;
import java.io.FilenameFilter;
import java.util.*;

/**
 * Implementacion Main Motor de Busqueda
 *
 * @author Baron Herrera Victoria
 * @author Vargas Bravo Paola
 * @version 1.0 (17 de Julio 2021)
 * @see Busqueda clase busqueda de palabras
 * @since Estructuras de datos 2021-2.
 */

public class MotorBusqueda {
    
    public static void menu() {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("-----------BIENVENID@-------------");
        System.out.println("-------------NEFILIM--------------");
        System.out.println("--------------MENÚ---------------");
        System.out.println("1.Buscar -------------------------");
        System.out.println("2.Consultar Historial-------------");
        System.out.println("3.Salir---------------------------");
        System.out.println("Elija una opción ----------------");
        System.out.println("----------------------------------");
        System.out.println(" ");
    }

    /**
     * Obtiene archivos txt de la carpeta ingresada por el usuario.
     *
     * @param entrada Scanner para recibir ruta del archivo.
     * @return Lista con archivos .txt
     */
    public static List<File> getFiles(Scanner entrada) {
        String path;
        File directorio = null;
        boolean allow = false;
        while (!allow) {
            System.out.println("Digite la ruta del directorio: ");
            path = entrada.nextLine();
            path = path.trim();
            directorio = new File(path);
            if (directorio.isDirectory() && directorio.exists()) {
                allow = true;
            } else {
                allow = false;
                System.out.println("Su directorio no existe ");
            }
        }
        File[] listFiles = directorio.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        });
        return Arrays.asList(listFiles);
    }


    public static void main(String[] args) {
        List<File> docs = new ArrayList<>();
        List<String> resultados;
        List<String> historial = new ArrayList<>();
        //Stack<String> historial = new Stack<>();
        Map<String, List<String>> cache = new HashMap<>();
        Scanner entrada = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        String consulta;
        String subPattern = "";
        boolean iniciar = false;
        boolean isRunning = true;
        int choose;
        int len;
        while (isRunning) {
            if (!iniciar) {
                docs = getFiles(entrada);
                while (docs.isEmpty()) {
                    System.out.println("Tu directorio está vacío!");
                    getFiles(entrada);
                }
                iniciar = true;
            } else {
                menu();
                while (!in.hasNextInt()) {
                    System.out.println("<Da un Numero>");
                    in.next();
                }
                choose = in.nextInt();
                switch (choose) {
                    case 1:
                        System.out.println("Digite su busqueda: ");
                        consulta = entrada.nextLine();
                        len = consulta.length();
                        while (len > 200) {
                            System.out.println("Tu busqueda excede 200 palabras");
                            System.out.println("Ingrese su busqueda :");
                            consulta = entrada.nextLine();
                            len = consulta.length();
                        }
                        historial.add(0, consulta);
                        if (cache.isEmpty()) {
                            System.out.println(" ");
                            resultados = new Busqueda().compara(docs, consulta);
                            System.out.println(" ");
                            System.out.println("Resultados : ");
                            System.out.println(" ");
                            for (String resultado : resultados) {
                                System.out.println(resultado);
                            }
                            cache.put(consulta, resultados);
                        } else {
                            resultados = new Busqueda().containsCache(cache, consulta);
                            if (resultados == null) {
                                System.out.println(" ");
                                resultados = new Busqueda().compara(docs, consulta);
                                System.out.println(" ");
                                System.out.println("Resultados : ");
                                System.out.println(" ");
                                for (String resultado : resultados) {
                                    System.out.println(resultado);
                                }
                                cache.put(consulta, resultados);
                            } else {
                                System.out.println(" ");
                                System.out.println("Resultados : ");
                                System.out.println(" ");
                                for (String resultado : resultados) {
                                    System.out.println(resultado);
                                }
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Historial:");
                        for (String h : historial) {
                            System.out.println(h);
                        }
                        break;

                    case 3:
                        isRunning = false;
                        System.out.println("Adios!");
                        break;
                    default:
                        System.out.println("Esa no es una opción");
                        System.err.println("Vuelve a intentarlo");
                        break;
                }
            }
        }
    }
}
