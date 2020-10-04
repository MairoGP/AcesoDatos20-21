import java.io.File;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        //Primero introducimos por consola el nombre de la carpeta a buscar
        System.out.print("Introduce el nombre de directorio que quieres buscar: ");
        //Guardamos los datos de entrada mediante la clase Scanner
        Scanner entradaEscaner = new Scanner(System.in);
        String entradaTeclado = entradaEscaner.nextLine();

        //Seleccionamos el directorio origen desde donde se va a buscar la carpeta pedida.
        File origenDeBusqueda = new File("D:\\Desktop");
        //Lanzamos un método creado para localizar la carpeta
        File carpetaABuscar = encontrarCarpeta(origenDeBusqueda,entradaTeclado);

        if(carpetaABuscar == null){
            System.out.println("No se encontró la carpeta");
        }else{
            mostrarCarpeta(carpetaABuscar);
        }
    }

    public static void mostrarCarpeta(File carpeta){
        //Este método muestra todos los archivos de todas las carpetas dentro de la carpeta pasada por parámetro.
        File carpetaBuscar = carpeta;
        File[] subArchivos = carpeta.listFiles();
        for (int i = 0; i < subArchivos.length; i++) {
            if(subArchivos[i].isFile()){
                System.out.println("    Archivo: "+subArchivos[i].getName());
            } else if (subArchivos[i].isDirectory()){
                System.out.println("Carpeta: "+subArchivos[i].getName());
                mostrarCarpeta(subArchivos[i]);
            }
        }
    }

    public static File encontrarCarpeta (File origen, String nombreCarpeta){
        //Este método va a buscar de forma recursiva en las carpetas de la ruta de origen hasta dar con la
        // carpeta deseada
        File carpetaABuscar = origen;
        File[] listadoDeArchivos = carpetaABuscar.listFiles();

        for (int i = 0; i < listadoDeArchivos.length; i++) {
            if(listadoDeArchivos[i].isDirectory()){
                String carpeta = listadoDeArchivos[i].getName();
                if(carpeta.equals(nombreCarpeta)){
                    return listadoDeArchivos[i];
                }else{
                    encontrarCarpeta(listadoDeArchivos[i],nombreCarpeta);
                }
            }
        }
        return null;
    }
}
