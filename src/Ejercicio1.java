import java.io.File;
import java.io.IOException;

public class Ejercicio1 {
    public static void main(String[] args) {
        //Con esta linea inicializamos una File, que mas tarde convertiremos en Carpeta. Esta carpeta se creará en la carpeta del proyecto.
        File desktop = new File("Pruebas");
        //Con este primer metodo ".exists" comprobamos si existe el directorio que queremos crear, si es false(no existe), procedemos a crealo.
        if (!desktop.exists()){
            //Una vez comprobado que exista, lo creamos con el método .mkdirs();
            if(desktop.mkdirs()){ //Este método devuelve true si se ha creado correctamente, y false al contrario.
                System.out.println("Carpeta creada");
                //Como se ha creado el directorio, creamos el archivo.
                crearArchivo(desktop.getPath());
            } else {
                System.out.println("Carpeta no creada");
            }
        } else{
            //Si encontramos que el directorio ya existe, procedemos a crear un archivo de texto dentro.
            System.out.println("El directorio ya existe");
            crearArchivo(desktop.getPath());
        }

    }
    //Como en el código main utilizamos dos veces crear un archivo, contruimos un método para solo llamarle y no copiar
    //su codigo 2 veces.
    private static void crearArchivo(String path){
        try {
            //Inicializamos el archivo de texto que vamos a crear, pasándole el path de su padre(la carpeta donde lo queremos), y su nombre.
            File ejemplo = new File(path,"texto.txt");
            if(ejemplo.createNewFile()){
                //El metodo createNewFile() devuelve true si se ha creado con exito y false al contrario.
                System.out.println("El archivo se ha creado");
            }else{
                System.out.println("El archivo no se ha creado, ya existe");
            }
        } catch (IOException e) {
            System.out.println("Se ha captado una excepción a la hora de crear el archivo.");;
        }
    }
}
