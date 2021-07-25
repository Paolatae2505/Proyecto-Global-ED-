import javax.swing.*;
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
        //CloockWorkPrincess princess  /// NOT USE
        
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("-----------BIENVENID@-------------");
        System.out.println("--------Clockwork Princess--------");
        System.out.println("--------------MENÚ---------------");
        System.out.println("1.Buscar -------------------------");
        System.out.println("2.Consultar Historial-------------");
        System.out.println("3.Salir---------------------------");
        System.out.println("Elija una opción ----------------");
        System.out.println("----------------------------------");
        System.out.println(" ");

    }

    public static List<File> getFiles(Scanner entrada) {
        String path = "";
        File directorio = null;
        boolean allow = false;
        String imageDir1 = "";
        while (!allow) {
            //System.out.println("Digite la ruta del directorio: ");
            //entrada.nextLine();
            try {
                path = JOptionPane.showInputDialog("Digite la ruta del directorio:", "Ruta");
                path = path.trim();
            } catch (NullPointerException e) {
                imageDir1 = "Imagenes Interfaz/rose.jpg";

                JOptionPane.showMessageDialog(null, "Usted cancelo la ejecución", "Clockwork Princess OFF",
                        JOptionPane.INFORMATION_MESSAGE, new ImageIcon(imageDir1));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            directorio = new File(path);
            if (directorio.isDirectory() && directorio.exists()) {
                allow = true;
            } else {
                allow = false;
                JOptionPane.showMessageDialog(null, "Su directorio no existe",
                        "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
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
        Map<String, List<String>> cache = new HashMap<>();
        Scanner entrada = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        String consulta;
        String subPattern = "";
        boolean iniciar = false;
        boolean isRunning = true;
        int choose;
        int len;
        String chooseCadena;
        String imageDir = "";
        while (isRunning) {
            if (!iniciar) {
                docs = getFiles(entrada);
                while (docs.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Su esta vacío",
                            "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
                    getFiles(entrada);
                }
                iniciar = true;
            } else {
                menu(); /// run  Menu Interfaz Yo
                while (!in.hasNextInt()) {
                    imageDir = "Imagenes Interfaz/rosa.jpg";
                    JOptionPane.showMessageDialog(null, "<Da un Numero>", "Clockwork Princess ON",
                            JOptionPane.INFORMATION_MESSAGE, new ImageIcon(imageDir));
                    in.nextLine();
                }

                choose = in.nextInt();
                switch (choose) {
                    case 1:

                    System.out.println("Digite su busqueda: "); /// Digitar la busqueda Vic
                     consulta = entrada.nextLine();

                        len = consulta.length();
                        while (len > 200) {
                            // System.out.println("Tu busqueda excede 200 palabras");
                            JOptionPane.showMessageDialog(null, "Tu busqueda excede 200 palabras",
                                    "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
                            System.out.println("Ingrese su busqueda :");
                            // = entrada.nextLine();
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
                        imageDir = "Imagenes Interfaz/takerose.jpg";
                        //JOptionPane.showMessageDialog(null,"Adios!");

                        JOptionPane.showMessageDialog(null, "Adios!", "Clockwork Princess off",
                                JOptionPane.INFORMATION_MESSAGE, new ImageIcon(imageDir));
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Esa no es una opción",
                                "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
                        imageDir = "Imagenes Interfaz/rosa.jpg";
                        JOptionPane.showMessageDialog(null, "Vuelve a intentarlo", "Clockwork Princess ON",
                                JOptionPane.INFORMATION_MESSAGE, new ImageIcon(imageDir));
                        break;
                }
            }
        }
    }
}
