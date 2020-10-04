import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {
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

    private static void crearArchivo(String path){
        try {
            //Inicializamos el archivo de texto que vamos a crear, pasándole el path de su padre(la carpeta donde lo queremos), y su nombre.
            File ejemplo = new File(path,"texto.txt");
            if(ejemplo.createNewFile()){
                //El metodo createNewFile() devuelve true si se ha creado con exito y false al contrario.
                System.out.println("El archivo se ha creado");
                //Preguntamos al usuario sobre la nueva función añadida, que es si desea borrar este fichero de prueba
                System.out.print("Desea borrar el archivo recien creado?(Y/N): ");
                Scanner entrada = new Scanner(System.in);
                //Tomamos los datos introducidos por teclado
                String entradaTeclado = entrada.nextLine();
                if(entradaTeclado.equals("Y")){
                    //Si el método delete devuelve true, es que se ha eliminado con exito.
                    if(ejemplo.delete()){
                        System.out.println("Fichero borrado con existo");
                    }else{
                        System.out.println("No se pudo borrar el fichero");
                    }
                }
            }else{
                System.out.println("El archivo no se ha creado, ya existe");
            }
        } catch (IOException e) {
            System.out.println("Se ha captado una excepción a la hora de crear el archivo.");;
        }
    }

}