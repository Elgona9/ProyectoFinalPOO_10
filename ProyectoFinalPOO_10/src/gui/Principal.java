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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import gui.Bienvenida;
import gui.MostrarRuta;
import logica.MetodoTransporte;
import logica.APie;
import logica.Almacenado;
import logica.Bicicleta;
import logica.Moto;
import logica.Carro;
import logica.Ciudad;
import persistencia.Archivos;

import javax.swing.SwingConstants;

public class Principal {

	Bienvenida Welcome = new Bienvenida();
	private JFrame frame;
	private JLabel puntoMapa = new JLabel(new ImageIcon(getClass().getResource("/Imagen/ubicacion.png")));

	public JFrame getFrame() {
		return frame;
	}
	/**
	 * Create the application.
	 */
	
	
	public Principal() {
	
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(117, 207, 241));
		frame.setBounds(100, 100, 788, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOrigen = new JLabel("Ciudad Origen");
		lblOrigen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblOrigen.setBounds(58, 30, 128, 24);
		frame.getContentPane().add(lblOrigen);
			// Crear Lugar para la Ubicacion
			JLabel lblUbicacionS = new JLabel("");
			lblUbicacionS.setVerticalAlignment(SwingConstants.TOP);
			lblUbicacionS.setBounds(383, 224, 45, 25);
			frame.getContentPane().add(lblUbicacionS);
			
			JLabel lblUbicacionC = new JLabel("");
		    lblUbicacionC.setVerticalAlignment(SwingConstants.TOP);
		    lblUbicacionC.setBounds(527, 166, 45, 25);
		    frame.getContentPane().add(lblUbicacionC);
		    
		    JLabel lblUbicacionG = new JLabel("");
		    lblUbicacionG.setVerticalAlignment(SwingConstants.TOP);
		    lblUbicacionG.setBounds(564, 111, 45, 25);
		    frame.getContentPane().add(lblUbicacionG);
		    
		    JLabel lblUbicacionL = new JLabel("");
		    lblUbicacionL.setVerticalAlignment(SwingConstants.TOP);
		    lblUbicacionL.setBounds(350, 183, 45, 25);
		    frame.getContentPane().add(lblUbicacionL);
		    
		    JLabel lblUbicacionCo = new JLabel("");
		    lblUbicacionCo.setVerticalAlignment(SwingConstants.TOP);
		    lblUbicacionCo.setBounds(406, 148, 45, 25);
		    frame.getContentPane().add(lblUbicacionCo);
		    
		    JLabel lblUbicacionA = new JLabel("");
		    lblUbicacionA.setVerticalAlignment(SwingConstants.TOP);
		    lblUbicacionA.setBounds(394, 97, 45, 25);
		    frame.getContentPane().add(lblUbicacionA);
	
			JComboBox comboBox_Origen = new JComboBox();
			comboBox_Origen.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			comboBox_Origen.setModel(new DefaultComboBoxModel(new String[] {"Santarem", "Leira", "Castelo", "Coimbra", "Guarda", "Aveiro"}));
			comboBox_Origen.setMaximumRowCount(6);
			comboBox_Origen.setBounds(58, 65, 128, 30);
			frame.getContentPane().add(comboBox_Origen);
	
			comboBox_Origen.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        String ciudadSeleccionada = (String) comboBox_Origen.getSelectedItem();
	
			        if ("Santarem".equals(ciudadSeleccionada)) {
			            // Muestra la imagen en el JLabel lblUbicacionS
			            ImageIcon img_1 = new ImageIcon(getClass().getResource("/Imagen/Ubicacion.png"));
			            Image imgIns = img_1.getImage();
			            // Ajustar la imagen al tamaño del JLabel
			            Image newImg = imgIns.getScaledInstance(lblUbicacionS.getWidth(), lblUbicacionS.getHeight(), Image.SCALE_SMOOTH);
			            ImageIcon finalImageIcon = new ImageIcon(newImg);
			            lblUbicacionS.setIcon(finalImageIcon);
	
			            lblUbicacionS.setVisible(true);  // Asegurarse de que el JLabel sea visible
			        } else {
			            // Oculta la imagen si la ciudad seleccionada no es "Santarem"
			            lblUbicacionS.setVisible(false);
			        }
			        if ("Leira".equals(ciudadSeleccionada)) {
			            // Muestra la imagen en el JLabel lblUbicacionS
			            ImageIcon img_1 = new ImageIcon(getClass().getResource("/Imagen/Ubicacion.png"));
			            Image imgIns = img_1.getImage();
			            // Ajustar la imagen al tamaño del JLabel
			            Image newImg = imgIns.getScaledInstance(lblUbicacionL.getWidth(), lblUbicacionL.getHeight(), Image.SCALE_SMOOTH);
			            ImageIcon finalImageIcon = new ImageIcon(newImg);
			            lblUbicacionL.setIcon(finalImageIcon);
	
			            lblUbicacionL.setVisible(true);  // Asegurarse de que el JLabel sea visible
			        } else {
			            // Oculta la imagen si la ciudad seleccionada no es "Santarem"
			        	lblUbicacionL.setVisible(false);
			        }
			        if ("Castelo".equals(ciudadSeleccionada)) {
			            // Muestra la imagen en el JLabel lblUbicacionS
			            ImageIcon img_1 = new ImageIcon(getClass().getResource("/Imagen/Ubicacion.png"));
			            Image imgIns = img_1.getImage();
			            // Ajustar la imagen al tamaño del JLabel
			            Image newImg = imgIns.getScaledInstance(lblUbicacionC.getWidth(), lblUbicacionC.getHeight(), Image.SCALE_SMOOTH);
			            ImageIcon finalImageIcon = new ImageIcon(newImg);
			            lblUbicacionC.setIcon(finalImageIcon);
	
			            lblUbicacionC.setVisible(true);  // Asegurarse de que el JLabel sea visible
			        } else {
			            // Oculta la imagen si la ciudad seleccionada no es "Santarem"
			        	lblUbicacionC.setVisible(false);
			        }
			        if ("Coimbra".equals(ciudadSeleccionada)) {
			            // Muestra la imagen en el JLabel lblUbicacionS
			            ImageIcon img_1 = new ImageIcon(getClass().getResource("/Imagen/Ubicacion.png"));
			            Image imgIns = img_1.getImage();
			            // Ajustar la imagen al tamaño del JLabel
			            Image newImg = imgIns.getScaledInstance(lblUbicacionCo.getWidth(), lblUbicacionCo.getHeight(), Image.SCALE_SMOOTH);
			            ImageIcon finalImageIcon = new ImageIcon(newImg);
			            lblUbicacionCo.setIcon(finalImageIcon);
	
			            lblUbicacionCo.setVisible(true);  // Asegurarse de que el JLabel sea visible
			        } else {
			            // Oculta la imagen si la ciudad seleccionada no es "Santarem"
			        	lblUbicacionCo.setVisible(false);
			        }
			        if ("Guarda".equals(ciudadSeleccionada)) {
			            // Muestra la imagen en el JLabel lblUbicacionS
			            ImageIcon img_1 = new ImageIcon(getClass().getResource("/Imagen/Ubicacion.png"));
			            Image imgIns = img_1.getImage();
			            // Ajustar la imagen al tamaño del JLabel
			            Image newImg = imgIns.getScaledInstance(lblUbicacionG.getWidth(), lblUbicacionG.getHeight(), Image.SCALE_SMOOTH);
			            ImageIcon finalImageIcon = new ImageIcon(newImg);
			            lblUbicacionG.setIcon(finalImageIcon);
	
			            lblUbicacionG.setVisible(true);  // Asegurarse de que el JLabel sea visible
			        } else {
			            // Oculta la imagen si la ciudad seleccionada no es "Santarem"
			        	lblUbicacionG.setVisible(false);
			        }
			        if ("Aveiro".equals(ciudadSeleccionada)) {
			            // Muestra la imagen en el JLabel lblUbicacionS
			            ImageIcon img_1 = new ImageIcon(getClass().getResource("/Imagen/Ubicacion.png"));
			            Image imgIns = img_1.getImage();
			            // Ajustar la imagen al tamaño del JLabel
			            Image newImg = imgIns.getScaledInstance(lblUbicacionA.getWidth(), lblUbicacionA.getHeight(), Image.SCALE_SMOOTH);
			            ImageIcon finalImageIcon = new ImageIcon(newImg);
			            lblUbicacionA.setIcon(finalImageIcon);
	
			            lblUbicacionA.setVisible(true);  // Asegurarse de que el JLabel sea visible
			        } else {
			            // Oculta la imagen si la ciudad seleccionada no es "Santarem"
			        	lblUbicacionA.setVisible(false);
			        }			        
			    }
			});

		
		JLabel lblDestino = new JLabel("Ciudad Destino");
		lblDestino.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDestino.setBounds(58, 111, 128, 24);
		frame.getContentPane().add(lblDestino);		
		
		JComboBox comboBox_Destino = new JComboBox();
		comboBox_Destino.setModel(new DefaultComboBoxModel(new String[] {"Santarem", "Leira", "Castelo", "Coimbra", "Guarda", "Aveiro"}));
		comboBox_Destino.setMaximumRowCount(6);
		comboBox_Destino.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		comboBox_Destino.setBounds(58, 146, 128, 30);
		frame.getContentPane().add(comboBox_Destino);
		
		   JLabel lblUbicacionS2 = new JLabel("");
		    lblUbicacionS2.setVerticalAlignment(SwingConstants.TOP);
		    lblUbicacionS2.setBounds(383, 224, 45, 25);
		    frame.getContentPane().add(lblUbicacionS2);
		    
		    JLabel lblUbicacionL2 = new JLabel("");
		    lblUbicacionL2.setVerticalAlignment(SwingConstants.TOP);
		    lblUbicacionL2.setBounds(350, 183, 45, 25);
		    frame.getContentPane().add(lblUbicacionL2);
		    
		    JLabel lblUbicacionC2 = new JLabel("");
		    lblUbicacionC2.setVerticalAlignment(SwingConstants.TOP);
		    lblUbicacionC2.setBounds(527, 166, 45, 25);
		    frame.getContentPane().add(lblUbicacionC2);
		    
		    JLabel lblUbicacionCo2 = new JLabel("");
		    lblUbicacionCo2.setVerticalAlignment(SwingConstants.TOP);
		    lblUbicacionCo2.setBounds(406, 148, 45, 25);
		    frame.getContentPane().add(lblUbicacionCo2);
		    
		    JLabel lblUbicacionG2 = new JLabel("");
		    lblUbicacionG2.setVerticalAlignment(SwingConstants.TOP);
		    lblUbicacionG2.setBounds(564, 111, 45, 25);
		    frame.getContentPane().add(lblUbicacionG2);
		    
		    JLabel lblUbicacionA2 = new JLabel("");
		    lblUbicacionA2.setVerticalAlignment(SwingConstants.TOP);
		    lblUbicacionA2.setBounds(394, 97, 45, 25);
		    frame.getContentPane().add(lblUbicacionA2);

		comboBox_Destino.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String ciudadSeleccionada2 = (String) comboBox_Destino.getSelectedItem();

		        if ("Santarem".equals(ciudadSeleccionada2)) {
		            // Muestra la imagen en el JLabel lblUbicacionS
		            ImageIcon img_1 = new ImageIcon(getClass().getResource("/Imagen/bander.png"));
		            Image imgIns = img_1.getImage();
		            // Ajustar la imagen al tamaño del JLabel
		            Image newImg = imgIns.getScaledInstance(lblUbicacionS2.getWidth(), lblUbicacionS2.getHeight(), Image.SCALE_SMOOTH);
		            ImageIcon finalImageIcon = new ImageIcon(newImg);
		            lblUbicacionS2.setIcon(finalImageIcon);

		            lblUbicacionS2.setVisible(true);  // Asegurarse de que el JLabel sea visible
		        } else {
		            // Oculta la imagen si la ciudad seleccionada no es "Santarem"
		        	lblUbicacionS2.setVisible(false);
		        }
		        if ("Leira".equals(ciudadSeleccionada2)) {
		            // Muestra la imagen en el JLabel lblUbicacionS
		            ImageIcon img_1 = new ImageIcon(getClass().getResource("/Imagen/bander.png"));
		            Image imgIns = img_1.getImage();
		            // Ajustar la imagen al tamaño del JLabel
		            Image newImg = imgIns.getScaledInstance(lblUbicacionL2.getWidth(), lblUbicacionL2.getHeight(), Image.SCALE_SMOOTH);
		            ImageIcon finalImageIcon = new ImageIcon(newImg);
		            lblUbicacionL2.setIcon(finalImageIcon);

		            lblUbicacionL2.setVisible(true);  // Asegurarse de que el JLabel sea visible
		        } else {
		            // Oculta la imagen si la ciudad seleccionada no es "Santarem"
		        	lblUbicacionL2.setVisible(false);
		        }
		        if ("Castelo".equals(ciudadSeleccionada2)) {
		            // Muestra la imagen en el JLabel lblUbicacionS
		            ImageIcon img_1 = new ImageIcon(getClass().getResource("/Imagen/bander.png"));
		            Image imgIns = img_1.getImage();
		            // Ajustar la imagen al tamaño del JLabel
		            Image newImg = imgIns.getScaledInstance(lblUbicacionC2.getWidth(), lblUbicacionC2.getHeight(), Image.SCALE_SMOOTH);
		            ImageIcon finalImageIcon = new ImageIcon(newImg);
		            lblUbicacionC2.setIcon(finalImageIcon);

		            lblUbicacionC2.setVisible(true);  // Asegurarse de que el JLabel sea visible
		        } else {
		            // Oculta la imagen si la ciudad seleccionada no es "Santarem"
		        	lblUbicacionC2.setVisible(false);
		        }
		        if ("Coimbra".equals(ciudadSeleccionada2)) {
		            // Muestra la imagen en el JLabel lblUbicacionS
		            ImageIcon img_1 = new ImageIcon(getClass().getResource("/Imagen/bander.png"));
		            Image imgIns = img_1.getImage();
		            // Ajustar la imagen al tamaño del JLabel
		            Image newImg = imgIns.getScaledInstance(lblUbicacionCo2.getWidth(), lblUbicacionCo2.getHeight(), Image.SCALE_SMOOTH);
		            ImageIcon finalImageIcon = new ImageIcon(newImg);
		            lblUbicacionCo2.setIcon(finalImageIcon);

		            lblUbicacionCo2.setVisible(true);  // Asegurarse de que el JLabel sea visible
		        } else {
		            // Oculta la imagen si la ciudad seleccionada no es "Santarem"
		        	lblUbicacionCo2.setVisible(false);
		        }
		        if ("Guarda".equals(ciudadSeleccionada2)) {
		            // Muestra la imagen en el JLabel lblUbicacionS
		            ImageIcon img_1 = new ImageIcon(getClass().getResource("/Imagen/bander.png"));
		            Image imgIns = img_1.getImage();
		            // Ajustar la imagen al tamaño del JLabel
		            Image newImg = imgIns.getScaledInstance(lblUbicacionG2.getWidth(), lblUbicacionG2.getHeight(), Image.SCALE_SMOOTH);
		            ImageIcon finalImageIcon = new ImageIcon(newImg);
		            lblUbicacionG2.setIcon(finalImageIcon);

		            lblUbicacionG2.setVisible(true);  // Asegurarse de que el JLabel sea visible
		        } else {
		            // Oculta la imagen si la ciudad seleccionada no es "Santarem"
		        	lblUbicacionG2.setVisible(false);
		        }
		        if ("Aveiro".equals(ciudadSeleccionada2)) {
		            // Muestra la imagen en el JLabel lblUbicacionS
		            ImageIcon img_1 = new ImageIcon(getClass().getResource("/Imagen/bander.png"));
		            Image imgIns = img_1.getImage();
		            // Ajustar la imagen al tamaño del JLabel
		            Image newImg = imgIns.getScaledInstance(lblUbicacionA2.getWidth(), lblUbicacionA2.getHeight(), Image.SCALE_SMOOTH);
		            ImageIcon finalImageIcon = new ImageIcon(newImg);
		            lblUbicacionA2.setIcon(finalImageIcon);

		            lblUbicacionA2.setVisible(true);  // Asegurarse de que el JLabel sea visible
		        } else {
		            // Oculta la imagen si la ciudad seleccionada no es "Santarem"
		        	lblUbicacionA2.setVisible(false);
		        }			        
		    }
		});
		
		JComboBox comboBox_MT = new JComboBox();
		comboBox_MT.setModel(new DefaultComboBoxModel(new String[] {"Caminando", "Bicicleta", "Moto", "Carro"}));
		comboBox_MT.setMaximumRowCount(4);
		comboBox_MT.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		comboBox_MT.setBounds(58, 220, 128, 30);
		frame.getContentPane().add(comboBox_MT);
		
		JButton btnNewButton_2_1_1 = new JButton("Viajar");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {		    	
		        String origen = (String) comboBox_Origen.getSelectedItem();
		        String destino = (String) comboBox_Destino.getSelectedItem();
		        if (origen.equals(destino)) {
		            JOptionPane.showMessageDialog(frame, "La ciudad de origen no puede ser la misma que el destino.", "Error", JOptionPane.ERROR_MESSAGE);
		            return; // No realizar cálculos ni mostrar la ruta
		        }
		        Ciudad ciudad = new Ciudad();
		        double latOrigen = ciudad.obtenerLatitudPorCiudad(origen);
		        double lonOrigen = ciudad.obtenerLongitudPorCiudad(origen);
		        double latDestino = ciudad.obtenerLatitudPorCiudad(destino);
		        double lonDestino = ciudad.obtenerLongitudPorCiudad(destino);
		        double distanciaTotal = ciudad.calcularDistancia(latOrigen, latDestino, lonOrigen, lonDestino);

		        //Obtener las paradas seleccionadas
		        List<String> paradas = new ArrayList<>();
		        paradas.add(origen);
		        /*paradas.add((String) comboBox_P1.getSelectedItem());
		        paradas.add((String) comboBox_P2.getSelectedItem());
		        paradas.add((String) comboBox_P3.getSelectedItem());
		        paradas.add((String) comboBox_P4.getSelectedItem());*/
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
		btnNewButton_2_1_1.setBounds(10, 277, 102, 35);
		frame.getContentPane().add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2_1_1_1 = new JButton("Salir");
		btnNewButton_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome.cerrarVentana();
			}
		});
		btnNewButton_2_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_2_1_1_1.setActionCommand("Salir");
		btnNewButton_2_1_1_1.setBounds(148, 277, 102, 35);
		frame.getContentPane().add(btnNewButton_2_1_1_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(260, 0, 2, 427);
		frame.getContentPane().add(separator_1);
		
		JLabel lblMedioDeTransporte = new JLabel("Medio De Transporte");
		lblMedioDeTransporte.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMedioDeTransporte.setBounds(31, 187, 176, 24);
		frame.getContentPane().add(lblMedioDeTransporte);
		
		
		JLabel lblmapa = new JLabel();
		lblmapa.setBounds(306, 11, 440, 401);

		try {
		    // Se carga un gif y se maneja la excepcion en dado caso que no abra
		    ImageIcon img_1 = new ImageIcon(getClass().getResource("/Imagen/pmapa.png"));
		    Image imgIns = img_1.getImage();
		    
		    // Ajustar la imagen al tamaño del JLabel
		    Image newImg = imgIns.getScaledInstance(lblmapa.getWidth(), lblmapa.getHeight(), Image.SCALE_SMOOTH);
		    
		    ImageIcon finalImageIcon = new ImageIcon(newImg);
		    lblmapa.setIcon(finalImageIcon);
		    
		    frame.getContentPane().add(lblmapa);
		    
		    JButton btnMostrarRutaGuardada = new JButton("Mostrar ruta guardada");
		    btnMostrarRutaGuardada.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            Archivos archivo = new Archivos();
		            try {
		                ArrayList<Almacenado> rutasGuardadas = archivo.leer();
		                //Comprueba si hay rutas guardadas
		                if(!rutasGuardadas.isEmpty()) {
		                    //Seleccionar una ruta para mostrar (en este caso la última)
		                    Almacenado ruta = rutasGuardadas.get(rutasGuardadas.size() - 1); //MUESTRA LA ULTIMA RUTA GUARDADA
		                    //Muestra información de la ruta
		                    MostrarRuta mr = new MostrarRuta(ruta.getOrigen(), ruta.getDestino(), ruta.getTiempoEstimado(), ruta.getNumParadasDescanso(), ruta.getNumParadasGasolina());
		                    mr.setVisible(true);
		                }else {
		                    JOptionPane.showMessageDialog(null, "No hay rutas guardadas.");
		                }
		            } catch(ClassNotFoundException | IOException ex) {
		                ex.printStackTrace();
		                JOptionPane.showMessageDialog(null, "Hubo un error al leer las rutas guardadas.");
		            }
		        }
		    });
		    btnMostrarRutaGuardada.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		    btnMostrarRutaGuardada.setActionCommand("Salir");
		    btnMostrarRutaGuardada.setBounds(20, 323, 230, 35);
		    frame.getContentPane().add(btnMostrarRutaGuardada);
		    
		 
		    
		    
		    
		   
		} catch (Exception e) {
		    e.printStackTrace();
		    JOptionPane.showMessageDialog(null, "Error cargando la imagen: " + e.getMessage());
		}
	}
}