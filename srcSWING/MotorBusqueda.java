import java.io.File;
import java.io.FilenameFilter;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * Implementacion Main Motor de Busqueda 
 * @author Baron Herrera Victoria
 * @author Vargas Bravo Paola
 * @version 1.0 (17 de Julio 2021)
 * @since Estructuras de datos 2021-2.
 * @see Busqueda clase busqueda de palabras
 */

public class MotorBusqueda{

    public static void menu(CloockWorkPrincess princess) {
        /** 
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
        */
        princess.setBounds(0,0,450,655);
        princess.setResizable(false);
        princess.setVisible(true);
        princess.setLocationRelativeTo(null);
    }

    public static List<File> getFiles(Scanner entrada) {
        String path = "";
        File directorio = null;
        boolean allow = false;
        String imageDir1 = "";
        while (!allow) {
            //System.out.println("Digite la ruta del directorio: ");
               //entrada.nextLine();
               try{
                path = JOptionPane.showInputDialog("Digite la ruta del directorio:", "Ruta");
                path = path.trim();
               }catch(NullPointerException e){
                imageDir1="C:\\Users\\Paola Vargas Bravo\\OneDrive\\Documentos\\Estructuras de Datos\\Imagenes Interfaz\\rose.jpg";
                  //JOptionPane.showMessageDialog(null,"Usted cancelo la ejecución");
                  JOptionPane.showMessageDialog(null,"Usted cancelo la ejecución", "Clockwork Princess OFF",
                  JOptionPane.INFORMATION_MESSAGE, new ImageIcon(imageDir1));
               }catch(Exception ex){
                 System.out.println(ex.getMessage());
               }
           
            directorio = new File(path);
            if (directorio.isDirectory() && directorio.exists()) {
                allow = true;
            } else {
                allow = false;
                //System.out.println("Su directorio no existe ");
                //JOptionPane.showMessageDialog(null,"Su directorio no existe");
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
        Stack<String> historial = new Stack<>();
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
        CloockWorkPrincess princess = new CloockWorkPrincess();
        String imageDir = "";
        while (isRunning) {
            if (!iniciar) {
                docs = getFiles(entrada);
                while (docs.isEmpty()) {
                    System.out.println("Tu directorio está vacío!");
                    getFiles(entrada);
                }
                iniciar = true;
            } else {
                menu(princess);
               /**  while (!in.hasNextInt()) {
                    //System.out.println("<Da un Numero>");
                    imageDir="C:\\Users\\Paola Vargas Bravo\\OneDrive\\Documentos\\Estructuras de Datos\\Imagenes Interfaz\\rosa.jpg";
                    // System.out.println("Esa no es una opción");
                    // System.out.println("Vuelve a intentarlo");
                    JOptionPane.showMessageDialog(null, "<Da un Numero>", "Clockwork Princess ON",
                    JOptionPane.INFORMATION_MESSAGE, new ImageIcon(imageDir));
                    in.nextLine();
                }
                */
                chooseCadena =  princess.showText();
                //System.out.println(chooseCadena);
                choose = Integer.parseInt(chooseCadena);//in.nextInt();
                System.out.println(choose);
                switch (choose){
                    case 1:
                        System.out.println("Digite su busqueda: ");
                        consulta = entrada.nextLine();
                        len = consulta.length();
                        while (len > 200) {
                           // System.out.println("Tu busqueda excede 200 palabras");
                           JOptionPane.showMessageDialog(null, "Tu busqueda excede 200 palabras",
              "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
                            //System.out.println("Ingrese su busqueda :");
                            // = entrada.nextLine();
                            consulta = JOptionPane.showInputDialog("Ingrese su busqueda :");
                            len = consulta.length();
                        }
                        historial.push(consulta);
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
                        new Busqueda().imprimeHistorial(historial);
                        break;

                    case 3:
                        isRunning = false;
            imageDir="C:\\Users\\Paola Vargas Bravo\\OneDrive\\Documentos\\Estructuras de Datos\\Imagenes Interfaz\\takerose.jpg";
                        //JOptionPane.showMessageDialog(null,"Adios!");
                        JOptionPane.showMessageDialog(null, "Adios!", "Clockwork Princess off",
                JOptionPane.INFORMATION_MESSAGE, new ImageIcon(imageDir));
                        break;
                    default:
                      JOptionPane.showMessageDialog(null, "Esa no es una opción",
                     "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
             imageDir="C:\\Users\\Paola Vargas Bravo\\OneDrive\\Documentos\\Estructuras de Datos\\Imagenes Interfaz\\rosa.jpg";
                       // System.out.println("Esa no es una opción");
                       // System.out.println("Vuelve a intentarlo");
                       JOptionPane.showMessageDialog(null, "Vuelve a intentarlo", "Clockwork Princess ON",
                       JOptionPane.INFORMATION_MESSAGE, new ImageIcon(imageDir));
                      // JOptionPane.showMessageDialog(null,"Vuelve a intentarlo");
                        break;
                }
            }
        }
    }
}
