/**
 * NOMBRE DEL PROGRAMA: PLANIFICADOR DE RUTAS
 * AUTORES: DAVID RIVEROS, NICOLAS JIMENEZ Y SEBASTIAN RANGEL
 * FECHA ENTREGA PROYECTO: 27 DE NOVIEMBRE DE 2023
 * VERSION: 0.01
 */
package logica;

import java.util.ArrayList;
import java.util.List;

public class Bus extends MetodoTransporte {
	//NUEVOS ATRIBUTOS
	private double precioTiquete;
	
	/**
	 * @return the precioTiquete
	 */
	public double getPrecioTiquete() {
		return precioTiquete;
	}

	/**
	 * @param precioTiquete the precioTiquete to set
	 */
	public void setPrecioTiquete(double precioTiquete) {
		this.precioTiquete = precioTiquete;
	}

	@Override
	public double calcularTiempo(double distancia) {
		// TODO Auto-generated method stub
		return distancia/getVelocidadPromedio();
	}

	@Override
	public List<String> sugerirDescanso(double tiempo) {
		// TODO Auto-generated method stub
        List<String> sugerenciasDescanso = new ArrayList<>();
        //DEFINIMOS INTERVALOS DE TIEMPO PARA DESCANSOS (en minutos)
        int intervaloCorto = 120; //CADA 2 HORAS
        int intervaloLargo = 240; // CADA 4 HORAS
        //CALCULAMOS EL NÚMERO DE DESCANSOS CORTOS Y LARGOS NECESARIOS
        int numDescansosCortos = (int) tiempo/intervaloCorto;
        int numDescansosLargos = (int) tiempo/intervaloLargo;
        
        //AÑADIMOS LAS SUGERENCIAS
        for (int i = 1; i <= numDescansosCortos; i++) {
            int tiempoDescanso = i * intervaloCorto;
            sugerenciasDescanso.add("Descanso corto de " + tiempoDescanso + " minutos");
        }

        for (int i = 1; i <= numDescansosLargos; i++) {
            int tiempoDescanso = i * intervaloLargo;
            sugerenciasDescanso.add("Descanso largo de " + tiempoDescanso + " minutos");
        }
		return sugerenciasDescanso;
	}

}
