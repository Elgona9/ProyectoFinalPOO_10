package persistencia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import logica.Almacenado;

public class Archivos {
    public ArrayList<Almacenado> leer() throws IOException, ClassNotFoundException{
    	ArrayList<Almacenado> list = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream("Ruta.ser");
        try(ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);){    
            while (true) {
            	Almacenado ruta = (Almacenado) objectInputStream.readObject();
            	list.add(ruta);
            	}
            }catch (EOFException e) {
            }catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return list;
        }

    public void guardar(Almacenado obj)throws IOException, ClassNotFoundException{
        ArrayList<Almacenado> list = new ArrayList<>();
        try {
            list= leer();
        }catch(Exception e) {
        	
        }list.add(obj);
        FileOutputStream fileOutputStream = new FileOutputStream("Ruta.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        if(!list.isEmpty()){
            for(int i = 0; i < list.size(); i++){
                objectOutputStream.writeObject(list.get(i));
            }
        }
        objectOutputStream.close();
    }
}