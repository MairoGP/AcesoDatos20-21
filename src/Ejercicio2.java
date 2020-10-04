import java.io.File;

public class Ejercicio2 {
    public static void main(String[] args) {
        //Obtenemos la ruta de la carpeta donde se está ejecutando el código
        String rutaCarpetaActual = System.getProperty("user.dir");
        //Instanciamos un objeto de la clase File con la ruta anterior.
        File carpetaActual = new File(rutaCarpetaActual);
        //Escribimos la ruta de la carpeta en la que nos encontramos.
        System.out.println(carpetaActual.getPath());
        //Si esta ruta existe, procedemos a comprobar que contiene.
        if(carpetaActual.exists()){
            //Mediente el método de la clase File .listFiles, obtenemos un array de Files con
            //lo que contiene la carpeta.
            File[] archivos = carpetaActual.listFiles();
            //Recorremos el array para comprobar que es una carpeta o que es un archivo.
            for (int i = 0; i < archivos.length; i++) {
                if(archivos[i].isDirectory()){
                    //Si nos encontramos con una carpeta, escribimos su nombre
                    System.out.println("Carpeta: " + archivos[i].getName());
                    //Obtenemos todos los archivos de esta carpeta para mostrarlos.
                    String[] archivosInferiores = archivos[i].list();
                    for (int j = 0; j < archivosInferiores.length; j++) {
                        //Volvemos a recorrer los archivos que tenga esta subcarpeta y lo mostramos.
                        System.out.println("    Archivo: " + archivosInferiores[j]);
                    }
                }else{
                    System.out.println("Archivo: "+ archivos[i].getName());
                }
            }
        } else{
            System.out.println("No se ha podido localizar la carpeta actual.");
        }
    }
}
