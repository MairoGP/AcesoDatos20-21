
import java.io.*;

public class Ejercicio9 {
    public static void main(String[] args) {
        String[] titulos = {"Las tinieblas y el alba","Don Quijote de la Mancha",
                            "El señor de los anillos","El principito"};
        int[] anyoPublicacion = {2020,2019,2018,2017};

        File temporal = new File("Temp");
        File libros = new File(temporal.getPath(),"libros.dat");
        try {
            if(temporal.mkdirs()){
                System.out.println("Carpeta temporal creada con exito.");
                libros.createNewFile();
            }else{
                System.out.println("No se ha creado el archivo, puede que ya exista.");
            };
        } catch (IOException e) {
            e.printStackTrace();
        }

        escribirBinario(libros,titulos,anyoPublicacion);
        leerBinario(libros);
    }

    private static void leerBinario(File libros) {
        try{
            FileInputStream fis = new FileInputStream(libros.getPath());
             int valor = fis.read();
             while(valor != -1){
                 System.out.print((char) valor);
                 valor = fis.read();
             }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void escribirBinario(File fichero, String[] info, int[] anyo){
        try{
            FileOutputStream fos = new FileOutputStream(fichero.getPath(),true);
            String información="";
            for(int i=0;i< info.length;i++){
                información += info[i];
                if(i <= info.length){
                    información += anyo[i];
                }
            }
            byte[] codigo = información.getBytes();
            fos.write(codigo);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
