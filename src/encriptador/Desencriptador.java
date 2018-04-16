/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/**
 *
 * @author House
 */
public class Desencriptador {
          public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, Exception {
         String tipoCifrado = "DES/ECB/PKCS5Padding";
         File file = new File("encriptado.txt");
         File llave = new File("llave.txt");
         byte[] array = GestionadorArchivo.abrirArchivo(file);
         SecretKey key = GestionadorArchivoKey.abrirArchivo(llave);
         byte[] desencriptado = decrypt(array, key, tipoCifrado);
         File archivoDesencriptado = new File("desencriptado.png");
         FileOutputStream output = new FileOutputStream(archivoDesencriptado);
         output.write(desencriptado);
         output.close();
    }
    private static byte[] decrypt(byte[] inpBytes,
        SecretKey key, String xform) throws Exception {
        Cipher cipher = Cipher.getInstance(xform);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(inpBytes);
    }
        
        
        
}
