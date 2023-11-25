package gui;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
public class MostrarRuta extends JFrame {
	private Map<String, List<String>> mapaConexiones = new HashMap<>();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	

	public MostrarRuta(String origen, String destino, double tiempo, int numParadasDescanso, int numParadasGasolina){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 661);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//mostrar La ruta dependiendo De las seleccionadas
		JLabel lblmostrar = new JLabel("");
		lblmostrar.setBounds(143, 10, 787, 600);
		contentPane.add(lblmostrar);
		mostrarGifs(origen, destino, lblmostrar, new HashSet<>());

		 
		
		JLabel lblTiempoTotal = new JLabel("Tiempo Total");
		lblTiempoTotal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTiempoTotal.setBounds(10, 121, 123, 24);
		contentPane.add(lblTiempoTotal);
		
		JLabel lblTiempoMostrar = new JLabel("New label");
		lblTiempoMostrar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTiempoMostrar.setBounds(10, 155, 116, 24);
		lblTiempoMostrar.setText(String.format("%.2f horas", tiempo));
		contentPane.add(lblTiempoMostrar);
		
		JLabel lblParadas = new JLabel("# Paradas descanso");
		lblParadas.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblParadas.setBounds(10, 189, 123, 24);
		contentPane.add(lblParadas);
		
		JLabel lblParadasMostrar = new JLabel("New label");
		lblParadasMostrar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblParadasMostrar.setBounds(10, 223, 116, 24);
		lblParadasMostrar.setText(Integer.toString(numParadasDescanso));
		contentPane.add(lblParadasMostrar);
		
		JLabel lblGasolina = new JLabel("Gasolina");
		lblGasolina.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGasolina.setBounds(10, 257, 123, 24);
		contentPane.add(lblGasolina);
		
		JLabel lblGasolinaMostrar = new JLabel("New label");
		lblGasolinaMostrar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGasolinaMostrar.setBounds(10, 290, 116, 24);
		if(numParadasGasolina == 0) {
			lblGasolinaMostrar.setText("N/A");
		}else {
			lblGasolinaMostrar.setText(Integer.toString(numParadasGasolina));
		}
		contentPane.add(lblGasolinaMostrar);
		
		JButton btnNewButton = new JButton("VOLVER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal principal = new Principal();
		        principal.getFrame().setVisible(true);
		        dispose();
			}
		});
		
		btnNewButton.setBounds(10, 568, 85, 21);
		contentPane.add(btnNewButton);
		
	
	}
	
	private boolean existeConexionDirecta(String origen, String destino) {
        if(origen == "Santarem" && destino == "Leira") {
        	return true;
        } else if(origen == "Santarem" && destino == "Castelo") {
        	return true;
        }else if(origen == "Leira" && destino == "Santarem") {
        	return true;
        }else if(origen == "Leira" && destino == "Castelo") {
        	return true;
        }else if(origen == "Leira" && destino == "Coimbra") {
        	return true;
        }else if(origen == "Castelo" && destino == "Leira") {
        	return true;
        }else if(origen == "Castelo" && destino == "Coimbra") {
        	return true;
        }else if(origen == "Castelo" && destino == "Guarda") {
        	return true;
        }else if(origen == "Castelo" && destino == "Santarem") {
        	return true;
        }else if(origen == "Coimbra" && destino == "Leira") {
        	return true;
        }else if(origen == "Coimbra" && destino == "Castelo") {
        	return true;
        }else if(origen == "Coimbra" && destino == "Guarda") {
        	return true;
        }else if(origen == "Coimbra" && destino == "Aveiro") {
        	return true;
        }else if(origen == "Guarda" && destino == "Castelo") {
        	return true;
        }else if(origen == "Guarda" && destino == "Coimbra") {
        	return true;
        }else if(origen == "Aveiro" && destino == "Coimbra") {
        	return true;
        }else {
        return false;
        }
    }
	private List<String> obtenerCiudadesConectadas(String ciudad) {
	    List<String> ciudadesConectadas = new ArrayList<>();

	    if (existeConexionDirecta(ciudad, "Leira")) {
	        ciudadesConectadas.add("Leira");
	    }
	    if (existeConexionDirecta(ciudad, "Castelo")) {
	        ciudadesConectadas.add("Castelo");
	    }
	    if (existeConexionDirecta(ciudad, "Santarem")) {
	        ciudadesConectadas.add("Santarem");
	    }
	    if (existeConexionDirecta(ciudad, "Coimbra")) {
	        ciudadesConectadas.add("Coimbra");
	    }
	    if (existeConexionDirecta(ciudad, "Guarda")) {
	        ciudadesConectadas.add("Guarda");
	    }
	    if (existeConexionDirecta(ciudad, "Aveiro")) {
	        ciudadesConectadas.add("Aveiro");
	    }
	    // Agrega más verificaciones según sea necesario para otras ciudades

	    return ciudadesConectadas;
	}
	
	private void mostrarGifCiudadDestino(String ciudadActual, String destino, JLabel lblmostrar) {
	    String num1 = "";
	    String num2 = "";
	    if(ciudadActual.equals("Santarem")) {
	        num1 = "1";
	    } else if (ciudadActual.equals("Leira")) {
	        num1 = "2";
	    } else if (ciudadActual.equals("Castelo")) {
	        num1 = "3";
	    } else if (ciudadActual.equals("Coimbra")) {
	        num1 = "4";
	    } else if (ciudadActual.equals("Guarda")) {
	        num1 = "5";
	    } else if (ciudadActual.equals("Aveiro")) {
	        num1 = "6";
	    }

	    if(destino.equals("Santarem")) {
	        num2 = "1";
	    } else if (destino.equals("Leira")) {
	        num2 = "2";
	    } else if (destino.equals("Castelo")) {
	        num2 = "3";
	    } else if (destino.equals("Coimbra")) {
	        num2 = "4";
	    } else if (destino.equals("Guarda")) {
	        num2 = "5";
	    } else if (destino.equals("Aveiro")) {
	        num2 = "6";
	    }

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

	private void mostrarGifs(String ciudadActual, String destino, JLabel lblmostrar, Set<String> ciudadesVisitadas) {
	    try {
	        // Verificar si la ciudad actual ya ha sido visitada
	        if (ciudadesVisitadas.contains(ciudadActual)) {
	            return; // Evitar bucle infinito
	        }
	        ciudadesVisitadas.add(ciudadActual);

	        // Verificar si hay conexión directa
	        if (existeConexionDirecta(ciudadActual, destino)) {
	            // Mostrar gif de conexión directa
	            mostrarGifCiudadDestino(ciudadActual, destino, lblmostrar);
	        } else {
	            // Buscar ciudades conectadas y mostrar sus gifs
	            for (String ciudadConectada : obtenerCiudadesConectadas(ciudadActual)) {
	                // Mostrar gif de ciudad actual a ciudad conectada
	               
	                System.out.println(""+ciudadActual);

	                // Llamada recursiva para mostrar gifs de ciudad conectada a destino
	                mostrarGifs(ciudadConectada, destino, lblmostrar, ciudadesVisitadas);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error cargando la imagen: " + e.getMessage());
	    }
	}


	
}
