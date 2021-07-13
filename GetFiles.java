import java.io.File;
import java.io.FilenameFilter;
import java.util.*;


public class GetFiles {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        double res = 0;
        String consulta = "";
        String path = "";
        boolean op = false;
        boolean exit = false;
        boolean allow = false;
        int choose = 0;
        int len = 0;
        Stack<String> historial = new Stack<>();
        Map<String, List<String>> cache = new HashMap<>();
        List<File> docs = new ArrayList<>();
        List<String> resultados = new ArrayList<>();
        File dir = null;
        while (exit == false) {
            if (op == false) {
                //// VERIFICA SI EXISTE LA RUTA Y EL DIRECTORIO////////
                while (allow == false) {
                    System.out.println("Digite la ruta del directorio :");
                    path = entrada.nextLine();
                    path = path.trim();
                    dir = new File(path);
                    if (dir.isDirectory() && dir.exists()) {
                        allow = true;
                    } else {
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
            } else if (op == true) {
                System.out.println("-----------BIENVENID@-------------");
                System.out.println("-------------NEFILIM--------------");
                System.out.println("--------------MENÚ---------------");
                System.out.println("1.Buscar -------------------------");
                System.out.println("2.Consultar Historial-------------");
                System.out.println("3.Salir---------------------------");
                System.out.println("Elija una opción ----------------");
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
                        historial.push(consulta);
                        if(cache.isEmpty() == true){
                            resultados = new Busqueda().compara(docs, consulta);
                            for (String resultado : resultados) {
                                System.out.println(resultado);
                            }
                            cache.put(consulta,resultados);
                        }else{
                        resultados = new Busqueda().containsCache(cache, consulta);
                        if(resultados == null){
                            resultados = new Busqueda().compara(docs, consulta);
                            for (String resultado : resultados) {
                                System.out.println(resultado);
                            }
                            cache.put(consulta,resultados);
                        }else{
                            for (String resultado : resultados) {
                                System.out.println(resultado);
                            } 
                        }
                        }
                        break;
                    case 2:
                        for (String s : historial) {
                            System.out.println(s);
                        }
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

