//Sebastián Rangel, Nicolas Jimenez, David Riveros
//14 de Noviembre de 2023
//Pantalla de Bienvenida

package gui;

import java.awt.Font;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;

public class Bienvenida {

    private JFrame frame;

    public JFrame getFrame() {
        return frame;
    }

    /**
     * Create the application.
     */
    public Bienvenida() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(117, 207, 241));
        frame.setBounds(100, 100, 496, 319);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Bienvenida.class.getResource("/Imagen/Intro.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        JLabel lbl_Bienvenida = new JLabel();
        lbl_Bienvenida.setBounds(21, 11, 172, 56);

        try {
            // Se carga un gif y se maneja la excepcion en dado caso que no abra
        	ImageIcon img_1 = new ImageIcon(getClass().getResource("/Imagen/Bienvenida.gif"));
    		Image imgIns = img_1.getImage();
    		ImageIcon finalImageIcon = new ImageIcon(imgIns);
    		lbl_Bienvenida.setIcon(finalImageIcon);
    		frame.getContentPane().add(lbl_Bienvenida);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error cargando la imagen: " + e.getMessage());
        }
        frame.getContentPane().add(lbl_Bienvenida);
        
        
        JLabel lbl_Animacion = new JLabel();
    	lbl_Animacion.setBounds(287, 11, 180, 246);
        try {
        	// Se carga un gif y se maneja la excepcion en dado caso que no abra
        	ImageIcon img_1 = new ImageIcon(getClass().getResource("/Imagen/Animacion.gif"));
    		Image imgIns = img_1.getImage();
    		ImageIcon finalImageIcon = new ImageIcon(imgIns);
    		lbl_Animacion.setIcon(finalImageIcon);
    		frame.getContentPane().add(lbl_Animacion);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error cargando la imagen: " + e.getMessage());
        }
        	frame.getContentPane().add(lbl_Animacion);

        //Boton para salir en la pantalla principal
        JButton btnNewButton_2_1 = new JButton("Salir");
		btnNewButton_2_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarVentana();
			}
		});
		btnNewButton_2_1.setActionCommand("Salir");
		btnNewButton_2_1.setBounds(153, 222, 102, 35);
		frame.getContentPane().add(btnNewButton_2_1);
		
		//Nombres
		JLabel lblNewLabel = new JLabel("SEBASTIÁN RANGEL");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 160, 267, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDavidRiveros = new JLabel("DAVID RIVEROS");
		lblDavidRiveros.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblDavidRiveros.setBounds(10, 78, 267, 35);
		frame.getContentPane().add(lblDavidRiveros);
		
		JLabel lblNicolasJimenez = new JLabel("NICOLAS JIMENEZ");
		lblNicolasJimenez.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNicolasJimenez.setBounds(10, 119, 267, 35);
		frame.getContentPane().add(lblNicolasJimenez);
		
		//Boton para entrar
		JButton btnNewButton_2_1_1 = new JButton("Entrar");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Principal principal = new Principal();
		        principal.getFrame().setVisible(true); // Mostrar la ventana Principal
		        frame.dispose(); // Cerrar la ventana de Bienvenida
		        try {
		            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Bienvenida.class.getResource("/Imagen/Intro.wav"));
		            Clip clip = AudioSystem.getClip();
		            clip.open(audioInputStream);
		            clip.start();
		        } catch (Exception e1) {
		            e1.printStackTrace();
		        }
		    }
		});
		btnNewButton_2_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_2_1_1.setActionCommand("Entrar");
		btnNewButton_2_1_1.setBounds(21, 222, 102, 35);
		frame.getContentPane().add(btnNewButton_2_1_1);
    }
    
    //Metodo para cerrar ventana
    public void cerrarVentana() {
		int valor = JOptionPane.showConfirmDialog(null, "Esta seguro que quiere cerrar la ventana?","ADVERTENCIA",
				JOptionPane.YES_NO_OPTION);
		if(valor == JOptionPane.YES_OPTION) {
			System.exit(0);
			
		}
	}
}
