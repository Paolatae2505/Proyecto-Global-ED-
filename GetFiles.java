import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;

public class GetFiles {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        String consulta = "";
        String path = "";
        boolean op = false;
        boolean exit = false;
        boolean allow = false;
        int choose = 0;
        int len = 0;
        List<File> docs = new ArrayList<>();
        File dir = null;
        String palabra = "";
        String pathWalk = "";
        while (exit == false) {
            if (op == false) {
                //// VERIFICA SI EXISTE LA RUTA Y EL DIRECTORIO////////
                while (allow == false) {
                    System.out.println("Digite la ruta del directorio :");
                    path = entrada.nextLine();
                       if (isSystemWindows()) {
                         pathWalk =  separatorsToWindows(path);
                       } else {
                         pathWalk = separatorsToUnix(path);
                       }
                    dir = new File(pathWalk);
                    if (dir.isDirectory() && dir.exists()) {
                        allow = true;
                    }else{
                        allow = false;
                        System.out.println("Su directorio no existe ");
                    }
                }
                ///// FILTRO PARA SOLO PASAR ARCHIVOS Y CON EXTENCIÓN TXT/////////
                File[] listFiles = dir.listFiles(new FilenameFilter() {
                    public boolean accept(File dir, String name) {
                        return name.toLowerCase().endsWith(".txt");//&& dir.isFile();
                    }
                });
                docs = Arrays.asList(listFiles);
                op = true;
            }else if (op == true){
                System.out.println("-----------BIENVENID@-------------");
                System.out.println("--------------MENÚ----------------");
                System.out.println("1.Buscar -------------------------");
                System.out.println("2.Consultar Historial-------------");
                System.out.println("3.Salir---------------------------");
                System.out.println("Elija una opción -----------------");
                System.out.println("----------------------------------");
                while (!in.hasNextInt()) {  /// SOLO PASE NUMEROS Y NO CADENAS
                    System.out.println("<Da un Numero>");
                    in.nextLine();
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
                        new Busqueda().compara(docs, consulta);
                        break;
                    case 2:
                        new Busqueda().imprimirHistorial();
                        break;

                    case 3:
                        exit = true;
                        System.out.println("Adios!");
                        break;
                    default:
                        System.out.println("Esa no es una opciòn");
                        System.err.println("Vuelve a intentarlo");
                        break;
                } // switch
            } /// else if
        }
    }
  }
    
