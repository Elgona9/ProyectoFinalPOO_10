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
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import gui.Bienvenida;
import gui.MostrarRuta;
import logica.MetodoTransporte;
import logica.APie;
import logica.Bicicleta;
import logica.Moto;
import logica.Carro;
import logica.Ciudad;

import javax.swing.SwingConstants;

public class Principal {

	Bienvenida Welcome = new Bienvenida();
	private JFrame frame;
	
	public JFrame getFrame() {
		return frame;
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
		
		JComboBox comboBox_MT = new JComboBox();
		comboBox_MT.setModel(new DefaultComboBoxModel(new String[] {"Caminando", "Bicicleta", "Moto", "Carro"}));
		comboBox_MT.setMaximumRowCount(4);
		comboBox_MT.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		comboBox_MT.setBounds(45, 238, 123, 30);
		frame.getContentPane().add(comboBox_MT);
		
		JButton btnNewButton_2_1_1 = new JButton("Viajar");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String origen = (String) comboBox_Origen.getSelectedItem();
		        String destino = (String) comboBox_Destino.getSelectedItem();
		        Ciudad ciudad = new Ciudad();
		        double latOrigen = ciudad.obtenerLatitudPorCiudad(origen);
		        double lonOrigen = ciudad.obtenerLongitudPorCiudad(origen);
		        double latDestino = ciudad.obtenerLatitudPorCiudad(destino);
		        double lonDestino = ciudad.obtenerLongitudPorCiudad(destino);
		        double distanciaTotal = ciudad.calcularDistancia(latOrigen, latDestino, lonOrigen, lonDestino);

		        // Obtener las paradas seleccionadas
		        List<String> paradas = new ArrayList<>();
		        paradas.add(origen);
		        paradas.add((String) comboBox_P1.getSelectedItem());
		        paradas.add((String) comboBox_P2.getSelectedItem());
		        paradas.add((String) comboBox_P3.getSelectedItem());
		        paradas.add((String) comboBox_P4.getSelectedItem());
		        paradas.add(destino);

		        for (int i = 0; i < paradas.size() - 1; i++) {
		            String ciudadActual = paradas.get(i);
		            String ciudadSiguiente = paradas.get(i + 1);

		            // Verificar si la parada actual y la siguiente no son "Ninguna"
		            if (!ciudadActual.equals("Ninguna") && !ciudadSiguiente.equals("Ninguna")) {
		                double latActual = ciudad.obtenerLatitudPorCiudad(ciudadActual);
		                double lonActual = ciudad.obtenerLongitudPorCiudad(ciudadActual);
		                double latSiguiente = ciudad.obtenerLatitudPorCiudad(ciudadSiguiente);
		                double lonSiguiente = ciudad.obtenerLongitudPorCiudad(ciudadSiguiente);

		                distanciaTotal += ciudad.calcularDistancia(latActual, latSiguiente, lonActual, lonSiguiente);
		            }
		        }

		        // Sumar la distancia directa entre el origen y la primera parada
		        if (!paradas.get(0).equals("Ninguna")) {
		            double latPrimeraParada = ciudad.obtenerLatitudPorCiudad(paradas.get(0));
		            double lonPrimeraParada = ciudad.obtenerLongitudPorCiudad(paradas.get(0));
		            distanciaTotal += ciudad.calcularDistancia(latOrigen, latPrimeraParada, lonOrigen, lonPrimeraParada);
		        }

		        // Sumar la distancia directa entre la última parada y el destino
		        if (!paradas.get(paradas.size() - 1).equals("Ninguna")) {
		            double latUltimaParada = ciudad.obtenerLatitudPorCiudad(paradas.get(paradas.size() - 1));
		            double lonUltimaParada = ciudad.obtenerLongitudPorCiudad(paradas.get(paradas.size() - 1));
		            distanciaTotal += ciudad.calcularDistancia(latUltimaParada, latDestino, lonUltimaParada, lonDestino);
		        }       
		        frame.dispose();
		        String medioTransporteSeleccionado = (String) comboBox_MT.getSelectedItem();
		        double tiempo = 0;
		        int numParadasGasolina = 0;
		        int numParadasDescanso = 0;

		        MostrarRuta mn;

		        // Crear instancia del medio de transporte seleccionado
		        switch (medioTransporteSeleccionado) {
		            case "Caminando":
		                MetodoTransporte caminando = new APie();
		                ((APie) caminando).setVelocidadPromedio(5);
		                tiempo = ((APie) caminando).calcularTiempo(distanciaTotal);
		                numParadasDescanso = ((APie) caminando).sugerirDescanso(tiempo);
		                mn = new MostrarRuta(origen, destino, tiempo, numParadasDescanso, numParadasGasolina);
		                mn.setVisible(true);
		                break;
		            case "Bicicleta":
		                MetodoTransporte bici = new Bicicleta();
		                ((Bicicleta) bici).setVelocidadPromedio(20);
		                tiempo = ((Bicicleta) bici).calcularTiempo(distanciaTotal);
		                numParadasDescanso = ((Bicicleta) bici).sugerirDescanso(tiempo);
		                mn = new MostrarRuta(origen, destino, tiempo, numParadasDescanso, numParadasGasolina);
		                mn.setVisible(true);
		                break;
		            case "Moto":
		                MetodoTransporte moto = new Moto();
		                ((Moto) moto).setVelocidadPromedio(80);
		                ((Moto) moto).setCapacidadTanque(15);
		                tiempo = ((Moto) moto).calcularTiempo(distanciaTotal);
		                numParadasGasolina = (int) ((Moto) moto).sugerirParadasGasolina(distanciaTotal);
		                numParadasDescanso = ((Moto) moto).sugerirDescanso(tiempo);
		                mn = new MostrarRuta(origen, destino, tiempo, numParadasDescanso, numParadasGasolina);
		                mn.setVisible(true);
		                break;
		            case "Carro":
		                MetodoTransporte carro = new Carro();
		                ((Carro) carro).setVelocidadPromedio(80);
		                ((Carro) carro).setCapacidadTanque(60);
		                tiempo = ((Carro) carro).calcularTiempo(distanciaTotal);
		                numParadasGasolina = (int) ((Carro) carro).sugerirParadasGasolina(distanciaTotal);
		                numParadasDescanso = ((Carro) carro).sugerirDescanso(tiempo);
		                mn = new MostrarRuta(origen, destino, tiempo, numParadasDescanso, numParadasGasolina);
		                mn.setVisible(true);
		                break;
		            default:
		                MetodoTransporte caminado = new APie();
		                ((APie) caminado).setVelocidadPromedio(5);
		                tiempo = ((APie) caminado).calcularTiempo(distanciaTotal);
		                mn = new MostrarRuta(origen, destino, tiempo, numParadasDescanso, numParadasGasolina);
		                mn.setVisible(true);
		        }
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