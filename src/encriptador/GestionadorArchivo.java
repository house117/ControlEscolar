/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author House
 */
public class GestionadorArchivo {
       public static void guardarArchivito(byte[] b, String Name) throws FileNotFoundException, IOException{
        File file = new File(Name);
        FileOutputStream output = new FileOutputStream(file);
        ObjectOutputStream writer = new ObjectOutputStream(output);
        writer.writeObject(b);
        writer.close();
        output.close();
        
    }
    public static byte[] abrirArchivo(File selected) throws FileNotFoundException, IOException, ClassNotFoundException{
        //File file = new File("miArchivo.txt");
        File file = selected;
        FileInputStream input = new FileInputStream(file);
        ObjectInputStream reader = new ObjectInputStream(input);
        
        byte[] resultado = (byte[])reader.readObject();
        reader.close();
        input.close();
        return resultado;
    }
    /*
    public static Buscaminas abrirArchivo() throws FileNotFoundException, IOException, ClassNotFoundException{
        File file = new File("miArchivo.txt");
        FileInputStream input = new FileInputStream(file);
        ObjectInputStream reader = new ObjectInputStream(input);
        
        Buscaminas resultado = (Buscaminas)reader.readObject();
        reader.close();
        input.close();
        return resultado;
    }*/
}
