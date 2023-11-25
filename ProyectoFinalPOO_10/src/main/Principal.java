package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import gui.Bienvenida;

public class Principal {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Bienvenida window = new Bienvenida();
                    JFrame frame = window.getFrame();
                    frame.setVisible(true); // Mostrar la ventana Bienvenida
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}