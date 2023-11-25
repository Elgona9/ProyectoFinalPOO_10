package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import gui.Bienvenida;

import javax.swing.SwingConstants;

public class Principal {

	Bienvenida Welcome = new Bienvenida();
	private JFrame frame;
	
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
	
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 255, 255));
		frame.setBounds(100, 100, 790, 658);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(-18, 430, 802, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblOrigen = new JLabel("Ciudad Origen");
		lblOrigen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblOrigen.setBounds(10, 458, 123, 24);
		frame.getContentPane().add(lblOrigen);
		
		JComboBox comboBox_Origen = new JComboBox();
		comboBox_Origen.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		comboBox_Origen.setModel(new DefaultComboBoxModel(new String[] {"Santarem", "Leira", "Castelo", "Coimbra", "Guarda", "Aveiro"}));
		comboBox_Origen.setMaximumRowCount(6);
		comboBox_Origen.setBounds(33, 492, 100, 30);
		frame.getContentPane().add(comboBox_Origen);
		
		JLabel lblDestino = new JLabel("Ciudad Destino");
		lblDestino.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDestino.setBounds(153, 458, 128, 24);
		frame.getContentPane().add(lblDestino);
		
		JComboBox comboBox_Destino = new JComboBox();
		comboBox_Destino.setModel(new DefaultComboBoxModel(new String[] {"Santarem", "Leira", "Castelo", "Coimbra", "Guarda", "Aveiro"}));
		comboBox_Destino.setMaximumRowCount(6);
		comboBox_Destino.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		comboBox_Destino.setBounds(157, 492, 100, 30);
		frame.getContentPane().add(comboBox_Destino);
		
		JLabel lblP1 = new JLabel("Parada 1");
		lblP1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblP1.setBounds(295, 458, 70, 24);
		frame.getContentPane().add(lblP1);
		
		JComboBox comboBox_P1 = new JComboBox();
		comboBox_P1.setModel(new DefaultComboBoxModel(new String[] {"Ninguna", "Santarem", "Leira", "Castelo", "Coimbra", "Guarda", "Aveiro"}));
		comboBox_P1.setMaximumRowCount(7);
		comboBox_P1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		comboBox_P1.setBounds(278, 492, 100, 30);
		frame.getContentPane().add(comboBox_P1);
		
		JLabel lblP2 = new JLabel("Parada 2");
		lblP2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblP2.setBounds(412, 458, 70, 24);
		frame.getContentPane().add(lblP2);
		
		JComboBox comboBox_P2 = new JComboBox();
		comboBox_P2.setModel(new DefaultComboBoxModel(new String[] {"Ninguna", "Santarem", "Leira", "Castelo", "Coimbra", "Guarda", "Aveiro"}));
		comboBox_P2.setMaximumRowCount(7);
		comboBox_P2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		comboBox_P2.setBounds(401, 492, 100, 30);
		frame.getContentPane().add(comboBox_P2);
		
		JComboBox comboBox_P3 = new JComboBox();
		comboBox_P3.setModel(new DefaultComboBoxModel(new String[] {"Ninguna", "Santarem", "Leira", "Castelo", "Coimbra", "Guarda", "Aveiro"}));
		comboBox_P3.setMaximumRowCount(7);
		comboBox_P3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		comboBox_P3.setBounds(527, 492, 100, 30);
		frame.getContentPane().add(comboBox_P3);
		
		JComboBox comboBox_P4 = new JComboBox();
		comboBox_P4.setModel(new DefaultComboBoxModel(new String[] {"Ninguna", "Santarem", "Leira", "Castelo", "Coimbra", "Guarda", "Aveiro"}));
		comboBox_P4.setMaximumRowCount(7);
		comboBox_P4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		comboBox_P4.setBounds(650, 492, 100, 30);
		frame.getContentPane().add(comboBox_P4);
		
		JLabel lblP3 = new JLabel("Parada 3");
		lblP3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblP3.setBounds(539, 458, 70, 24);
		frame.getContentPane().add(lblP3);
		
		JLabel lblP4 = new JLabel("Parada 4");
		lblP4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblP4.setBounds(656, 458, 70, 24);
		frame.getContentPane().add(lblP4);
		
		JButton btnNewButton_2_1_1 = new JButton("Viajar");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String origen = (String) comboBox_Origen.getSelectedItem();
				String destino= (String) comboBox_Destino.getSelectedItem();
				MostrarRuta mn = new MostrarRuta(origen, destino);
				mn.setVisible(true);			
				frame.dispose();
			}
		});
		
		btnNewButton_2_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_2_1_1.setActionCommand("Salir");
		btnNewButton_2_1_1.setBounds(236, 542, 102, 35);
		frame.getContentPane().add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2_1_1_1 = new JButton("Salir");
		btnNewButton_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome.cerrarVentana();
			}
		});
		btnNewButton_2_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_2_1_1_1.setActionCommand("Salir");
		btnNewButton_2_1_1_1.setBounds(434, 542, 102, 35);
		frame.getContentPane().add(btnNewButton_2_1_1_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(219, 0, 2, 432);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(0, 206, 221, 2);
		frame.getContentPane().add(separator_2);
		
		JLabel lblMedioDeTransporte = new JLabel("Medio De Transporte");
		lblMedioDeTransporte.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMedioDeTransporte.setBounds(24, 210, 176, 24);
		frame.getContentPane().add(lblMedioDeTransporte);
		
		JComboBox comboBox_MT = new JComboBox();
		comboBox_MT.setModel(new DefaultComboBoxModel(new String[] {"Caminando", "Bicicleta", "Moto", "Carro"}));
		comboBox_MT.setMaximumRowCount(4);
		comboBox_MT.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		comboBox_MT.setBounds(45, 238, 123, 30);
		frame.getContentPane().add(comboBox_MT);
		
	
		
		JLabel lblmapa = new JLabel();
		lblmapa.setBounds(272, 19, 440, 401);

		try {
		    // Se carga un gif y se maneja la excepcion en dado caso que no abra
		    ImageIcon img_1 = new ImageIcon(getClass().getResource("/Imagen/pmapa.png"));
		    Image imgIns = img_1.getImage();
		    
		    // Ajustar la imagen al tamaño del JLabel
		    Image newImg = imgIns.getScaledInstance(lblmapa.getWidth(), lblmapa.getHeight(), Image.SCALE_SMOOTH);
		    
		    ImageIcon finalImageIcon = new ImageIcon(newImg);
		    lblmapa.setIcon(finalImageIcon);
		    
		    frame.getContentPane().add(lblmapa);
		} catch (Exception e) {
		    e.printStackTrace();
		    JOptionPane.showMessageDialog(null, "Error cargando la imagen: " + e.getMessage());
		}
	}
}