package persistencia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import gui.MostrarRuta;

public class Archivos {
    private DataOutputStream archivo = null;
    private DataInputStream entrada = null;
    MostrarRuta mr;

    public void abrir(String nombreArchivo) throws FileNotFoundException {
        try {
            archivo = new DataOutputStream(new FileOutputStream(nombreArchivo, true));
            entrada = new DataInputStream(new FileInputStream(nombreArchivo));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void cerrar() throws IOException {
        try {
            if (archivo != null) {
                archivo.close();
            }
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void escribirRuta(String origen, String destino, double tiempo, int numParadasDescanso, int numParadasGasolina) throws IOException {
        try {
            archivo.writeUTF(origen);
            archivo.writeUTF(destino);
            archivo.writeDouble(tiempo);
            archivo.writeInt(numParadasDescanso);
            archivo.writeInt(numParadasGasolina);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}