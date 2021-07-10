import java.io.*;
import java.util.Scanner;
import java.util.*;
public class GetFiles{
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        boolean op = false;
        String path = "";
        boolean exit = false;
        int choose = 0;
        String palabra = "";
        int len = 0;
        boolean allow = false;
        List<File> docs = new ArrayList<>();
        File dir = null;
        while(exit == false){
        if(op == false){
        //// VERIFICA SI EXISTE LA RUTA Y EL DIRECTORIO////////
         while(allow == false){
         System.out.println("Digite la ruta del directorio :");
         path = entrada.nextLine();
         dir = new File(path);
         if(dir.isDirectory() && dir.exists())
         allow = true;   /// Aqui se agrego algo ojo  Ve la foto de VIC BORRA ESTO ANTES DEL PULL OJOOOOO
         System.out.println("Su directorio no existe ");
         }
         ///// FILTRO PARA SOLO PASAR ARCHIVOS Y CON EXTENCIÓN TXT/////////
         File [] listFiles = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");//&& dir.isFile();
            }
        });
         docs = Arrays.asList(listFiles);
        op = true; 
        }else if(op == true){
         System.out.println("-----------BIENVENID@-------------");
         System.out.println("--------------MENÚ----------------");
         System.out.println("1.Buscar -------------------------");
         System.out.println("2.Consultar Historial-------------");
         System.out.println("3.Salir---------------------------");
         System.out.println("Elija una opción -----------------");
         System.out.println("----------------------------------");
         while(!in.hasNextInt()){  /// SOLO PASE NUMEROS Y NO CADENAS 
            System.out.println("<Da un Numero>");
            in.nextLine();
        } 
         choose = in.nextInt();
         switch(choose){
            case 1 :
            System.out.println("Digite su busqueda : ");
            palabra = entrada.nextLine();
            len = palabra.length();
            while(len>200){
                System.out.println("Tu busqueda excede 200 palabras");
                System.out.println("Ingrese su busqueda :");
                palabra = entrada.nextLine();
                len = palabra.length();
            }
            /// RECORRER TODA LA LISTA Y PONER SIMP
            /// TODOS LOS SIMPS DE LOS DOCUMENTOS METERLOS EN UNA ESTRUCTURA
            /// ORDENARLOS  *** PENSAR***
            /// METERLOS A OTRA ESTRUCT Y SACAR LOS 10 PRIMEROS 
            break;

            case 2 :

            break;

            case 3 :
            exit = true;
            break;

            default :
            System.out.println("Esa no es una opciòn");
            System.err.println("Vuelve a intentarlo");
            break;
         }

        }

    }

    }
}