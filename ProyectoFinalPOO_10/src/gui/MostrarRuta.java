package gui;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Disja;
import logica.Disjaapoyo;
import logica.Almacenado;
import persistencia.Archivos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import persistencia.Archivos;
import javax.swing.JTextArea;


public class MostrarRuta extends JFrame {
	private Map<String, List<String>> mapaConexiones = new HashMap<>();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	
	private int destinon;
	private int origenn;
	public MostrarRuta(String origen, String destino, double tiempo, int numParadasDescanso, int numParadasGasolina){
		
		Map<Integer, String> cityNames = new HashMap<>();
        cityNames.put(0, "Santarem");
        cityNames.put(1, "Leira");
        cityNames.put(2, "Castelo");
        cityNames.put(3, "Coimbra");
        cityNames.put(4, "Guarda");
        cityNames.put(5, "Aveiro");
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 661);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(117, 207, 241));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		 
		
		JLabel lblTiempoTotal = new JLabel("Tiempo Total");
		lblTiempoTotal.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTiempoTotal.setBounds(10, 121, 123, 24);
		contentPane.add(lblTiempoTotal);
		
		JLabel lblTiempoMostrar = new JLabel("New label");
		lblTiempoMostrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiempoMostrar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTiempoMostrar.setBounds(10, 155, 116, 24);
		lblTiempoMostrar.setText(String.format("%.2f horas", tiempo));
		contentPane.add(lblTiempoMostrar);
		
		JLabel lblParadasMostrar = new JLabel("New label");
		lblParadasMostrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblParadasMostrar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblParadasMostrar.setBounds(10, 245, 116, 24);
		lblParadasMostrar.setText(Integer.toString(numParadasDescanso));
		contentPane.add(lblParadasMostrar);
		
		
		
		JLabel lblGasolinaMostrar = new JLabel("New label");
		lblGasolinaMostrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblGasolinaMostrar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblGasolinaMostrar.setBounds(10, 331, 116, 24);
		if(numParadasGasolina == 0) {
			lblGasolinaMostrar.setText("N/A");
		}else {
			lblGasolinaMostrar.setText(Integer.toString(numParadasGasolina));
		}
		contentPane.add(lblGasolinaMostrar);
		
		JButton btnNewButton = new JButton("VOLVER");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal principal = new Principal();
		        principal.getFrame().setVisible(true);
		        dispose();
			}
		});
		
		btnNewButton.setBounds(10, 500, 120, 31);
		contentPane.add(btnNewButton);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Almacenado rutaAlmacenada = new Almacenado(origen, destino, tiempo, numParadasDescanso, numParadasGasolina);
				Archivos archivo = new Archivos();
				try {
					archivo.guardar(rutaAlmacenada);
		            JOptionPane.showMessageDialog(null, "La ruta ha sido guardada exitosamente!");
				}catch(ClassNotFoundException | IOException ex) {
					ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Hubo un error al guardar la ruta.");
				}
			}
		});
		
		btnGuardar.setBounds(10, 460, 120, 31);
		contentPane.add(btnGuardar);
		
		JLabel lblRuta = new JLabel("Ruta");
		lblRuta.setHorizontalAlignment(SwingConstants.CENTER);
		lblRuta.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRuta.setBounds(10, 366, 116, 31);
		contentPane.add(lblRuta);
		
				
		 Disja d = new Disja();
			origenn= obtenerIndiceCiudad(origen);
			destinon= obtenerIndiceCiudad(destino);
	        
	        Disjaapoyo disjaapoyo = new Disjaapoyo(5, origenn, destinon);
	        
	        String shortestPath = disjaapoyo.getShortestPath(d);
	        String[] pathParts = shortestPath.split(" -> ");
	        StringBuilder cityNamePath = new StringBuilder();
	        for (String part : pathParts) {
	            int cityNumber = Integer.parseInt(part);
	            String cityName = cityNames.get(cityNumber);
	            if (cityName != null) {
	                if (cityNamePath.length() > 0) {
	                    cityNamePath.append(" -> ");
	                }
	                cityNamePath.append(cityName);
	            }
	        }
	        JLabel lblRuta_1 = new JLabel("");
	        lblRuta_1.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	        lblRuta_1.setBounds(10, 400, 129, 24);
	        lblRuta_1.setText(cityNamePath.toString());
	        contentPane.add(lblRuta_1);
	        
	    	List<String> pathSegments= disjaapoyo.getShortestPathSegments(d);
			//mostrar La ruta dependiendo De las seleccionadas
			JLabel lblmostrar = new JLabel("");
			lblmostrar.setBounds(143, 10, 787, 600);
			contentPane.add(lblmostrar);
			mostrarGifs(pathSegments, lblmostrar);
			
			JTextArea txtrParadasDe = new JTextArea();
			txtrParadasDe.setFont(new Font("Times New Roman", Font.BOLD, 20));
			txtrParadasDe.setText("# Paradas de\r\n    descanso");
			txtrParadasDe.setBackground(new Color(117, 207, 241));
			txtrParadasDe.setBounds(10, 185, 123, 52);
			contentPane.add(txtrParadasDe);
			
			JTextArea txtrParadasDe_1 = new JTextArea();
			txtrParadasDe_1.setText("# Paradas de\r\n    gasolina");
			txtrParadasDe_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
			txtrParadasDe_1.setBackground(new Color(117, 207, 241));
			txtrParadasDe_1.setBounds(10, 274, 123, 52);
			contentPane.add(txtrParadasDe_1);
	   
	
	}
				
	
		
	private void mostrarGifCiudadDestino(String ciudadActual, String destino, JLabel lblmostrar) {
		 System.out.println("Ciudad Actual: " + ciudadActual + ", Destino: " + destino);
	    String num1 = obtenerCiudadDesdeNumero2(ciudadActual);
	    String num2 = obtenerCiudadDesdeNumero2(destino);

	    String nombreGif = num1 + "-" + num2 + ".gif";

	    // Directorio donde se encuentran los gifs en el proyecto (en el directorio de recursos)
	    String directorioRecursos = "/Imagen/";

	    try {
	        // Cargar el gif desde el recurso
	        ImageIcon iconoGif = new ImageIcon(getClass().getResource(directorioRecursos + nombreGif));

	        // Ajustar el tamaño del gif si es necesario
	        int lblWidth = lblmostrar.getWidth();
	        int lblHeight = lblmostrar.getHeight();
	        Image imgScaled = iconoGif.getImage().getScaledInstance(lblWidth, lblHeight, Image.SCALE_DEFAULT);
	        ImageIcon finalImageIcon = new ImageIcon(imgScaled);

	        // Mostrar el gif en el JLabel
	        lblmostrar.setIcon(finalImageIcon);
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error cargando el gif: " + e.getMessage());
	    }
	}
	
	public void mostrarGifs(List<String> pathSegments, JLabel lblmostrar) {
	    try {
	        // Iterar sobre cada segmento del camino
	        for (String pathSegment : pathSegments) {
	            // Dividir el segmento en nodos
	            String[] nodes = pathSegment.split(" -> ");
	            
	            // Mostrar los gifs para cada tramo del camino
	            for (int i = 0; i < nodes.length - 1; i++) {
	                String ciudadActual = obtenerCiudadDesdeNumero(nodes[i]);
	                String ciudadDestino = obtenerCiudadDesdeNumero(nodes[i + 1]);
	                
	                // Mostrar el gif para el tramo actual
	                mostrarGifCiudadDestino(ciudadActual, ciudadDestino, lblmostrar);
	                
	                // Puedes agregar algún tiempo de espera entre gifs si es necesario
	                Thread.sleep(1000); // espera de 12 segundos
	            }
	        }
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error en la espera: " + e.getMessage());
	    }
	}

	// Función para obtener el nombre de la ciudad a partir de su número
	private String obtenerCiudadDesdeNumero(String num) {
	    switch (num) {
	        case "0": return "Santarem";
	        case "1": return "Leira";
	        case "2": return "Castelo";
	        case "3": return "Coimbra";
	        case "4": return "Guarda";
	        case "5": return "Aveiro";
	        default: return ""; // Manejar el caso de número no válido si es necesario
	    }
	}
	private String obtenerCiudadDesdeNumero2(String a) {
	    switch (a) {
	        case "Santarem": return "1";
	        case "Leira": return "2";
	        case "Castelo": return "3";
	        case "Coimbra": return "4";
	        case "Guarda": return "5";
	        case "Aveiro": return "6";
	        default: return ""; // Manejar el caso de número no válido si es necesario
	    }
	}

	 private int obtenerIndiceCiudad(String ciudad) {
	        switch (ciudad) {
	            case "Santarem": return 0;
	            case "Leira": return 1;
	            case "Castelo": return 2;
	            case "Coimbra": return 3;
	            case "Guarda": return 4;
	            case "Aveiro": return 5;
	            default: return -1; // Valor por defecto para indicar error
	        }
	    }
}
