

import java.io.File;
import java.net.URI;

public class Ejercicio0 {
    public static void main(String[] args) {
        String path = "\\nmain\\n";
        File ejem = new File("..\\nuser\\ndocs");
       // URI uri = new URI();

        //El constructor de la clase File, tiene 4 opciones distintas de definir un objeto tipo File.
        File ejemplo = new File(ejem,"string"); //Crea un archivo File procedente de la ruta de otro archivo File (parent), y un string del path del hijo (child).
        File ejemplo1 = new File("pathname"); //Podemos declararlo solamente introduciendo el Path donde se va a situar.
        File ejemplo2 = new File(path,path); //Podemos declararlo igual que el primer ejemplo pero en vez de poner sus Files familiares, introducimos su path por string.
        File ejemplo3 = new File(""); //Podemos inicializarlo tmb a partir de un objeto URI, un enlace.
    }
}
