package transporte;

import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Buseta implements Serializable {

    private String _Modelo = "";
    private String _Marca = "";

    public Buseta(String marca, String modelo) {
        this._Marca = marca;
        this._Modelo = modelo;
    }

    public String getMarca() {
        return this._Marca;
    }

    public String getModelo() {
        return this._Modelo;
    }

    public void setModelo(String _Modelo) {
        this._Modelo = _Modelo;
    }

    public void setMarca(String _Marca) {
        this._Marca = _Marca;
    }

    @Override
    public String toString() {
        String buseta = "Buseta:";
        buseta += this._Marca + " " + this._Modelo;
        return buseta;
    }

    public static void main(String[] args) {
        File archivo = new File("Busetas.txt");
        FileOutputStream salida = null;
        FileInputStream entrada = null;
        ObjectOutputStream writer = null;
        ObjectInputStream reader = null;
        Buseta busetaTemp = null;
        ArrayList<Buseta> busetas = new ArrayList<>();
        try {
            System.out.println("Leyendo archivo");
            entrada = new FileInputStream(archivo);
            reader = new ObjectInputStream(entrada);
            busetas=(ArrayList<Buseta>) reader.readObject();
            for(Buseta variable:busetas){
                 System.out.println(variable.toString());
            }
        } catch (IOException | ClassNotFoundException ex) {
                    System.err.println(ex.getMessage());
        } 
        finally{
            if(entrada != null){
                try {
                    entrada.close();
                    if(reader != null){
                        reader.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Buseta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //--------------Escritura de archivo--------------------
        try {
            System.out.println("Escribiendo en archivo");
            archivo.createNewFile();
            salida = new FileOutputStream(archivo);
            writer = new ObjectOutputStream(salida);
            busetaTemp = new Buseta("Toyota", "C");
            busetas.add(busetaTemp);
            writer.writeObject(busetas);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                    if (writer != null) {
                        writer.close();
                    }
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }
}
