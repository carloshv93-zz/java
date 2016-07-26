package archivos;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Archivos {
    public static void main(String[] args) {
        File archivo=new File("Salida.txt");
        FileWriter writer=null;
        try {
            archivo.createNewFile();//Si y solo si archivo no existe 
            writer=new FileWriter(archivo,true);
            writer.append("Carlos Herrera\n");
            writer.append("CaracolFeroz\n");
            writer.append("Like y Suscribete\n");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }finally{
            if(writer!=null){
                try {
                    writer.close();
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }

}
