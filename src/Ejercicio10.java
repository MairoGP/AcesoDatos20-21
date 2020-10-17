import javax.print.attribute.standard.JobKOctets;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Ejercicio10 {
    public static class Book implements Serializable {
        private String autor;
        private String nombre;
        private String editorial;
        private Date fecha;

        @Override
        public String toString() {
            return "Libro: " +nombre + "\n"+
                    "Autor: " + autor +"\n" +
                    "Editorial: " + editorial + '\n' +
                    "Fecha=" + fecha.toString() +"\n";
        }

        public Book() {

        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setEditorial(String editorial) {
            this.editorial = editorial;
        }

        public void setFecha(String fecha) {
            DateFormat format = new SimpleDateFormat("DD/MM/YY");
            try {
                this.fecha = format.parse(fecha);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        Book(String autor, String nombre, String editorial, String fecha ){
            this.autor = autor;
            this.nombre = nombre;
            this.editorial = editorial;
            this.setFecha(fecha);
        }

        public String getAutor() {
            return autor;
        }

        public String getNombre() {
            return nombre;
        }

        public String getEditorial() {
            return editorial;
        }

        public String getFecha() {
            return fecha.toString();
        }
    }

    public static void main(String[] args) {
        //Creamos los objetos de la clase Book
        Book libro1 = new Book("Miguel de Cervantes","El Cojote","DelRios","10/03/1989");
        Book libro2 = new Book("Eduar Mullen","La farola de la esquina","MundoMondo","22/08/2019");
        Book libro3 = new Book("Lorena Clashkay","Historias de luna","ClashMod","02/12/2020");
        Book libro4 = new Book("Mandelero Jons","Oeste vs Este","MetroPoul","14/4/2030");

        ArrayList<Book> libros = new ArrayList<>();
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);

        File carpeta = new File("Temp");
        File librosDatos = new File(carpeta.getPath(),"BooFile.dat");
        try{
            if(!carpeta.exists()){
                System.out.println("La carpeta Temp no existe.");
                if(carpeta.mkdirs()){
                    librosDatos.createNewFile();
                    //Creada la carpeta y el archivo.
                }else{
                    System.out.println("Error al crear la carpeta.");
                };
            }else{
                System.out.println("Detectada Temp, creandro archivo.");
                librosDatos.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        escribirObjetosDat(librosDatos,libros);
        ArrayList<Book> librosLeidos = leearObjetosDat(librosDatos);
        if(librosLeidos != null) {
            for (int i = 0; i < librosLeidos.size(); i++) {
                System.out.println(librosLeidos.get(i).toString());
            }
        }
    }

    private static ArrayList<Book> leearObjetosDat(File librosDatos) {
        ArrayList<Book> libros = new ArrayList<>();
        try{
            Book aux;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(librosDatos));
            while((aux=(Book)ois.readObject()) != null){
                libros.add(aux);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(EOFException e){
            return libros;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void escribirObjetosDat(File librosDatos, ArrayList<Book> libros) {
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(librosDatos));
            for(int i=0;i<libros.size();i++){
                oos.writeObject(libros.get(i));
            }
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
