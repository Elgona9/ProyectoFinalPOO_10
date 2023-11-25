/**
 * NOMBRE DEL PROGRAMA: PLANIFICADOR DE RUTAS
 * AUTORES: DAVID RIVEROS, NICOLAS JIMENEZ Y SEBASTIAN RANGEL
 * FECHA ENTREGA PROYECTO: 27 DE NOVIEMBRE DE 2023
 * VERSION: 0.01
 */
package logica;

import java.util.ArrayList;
import java.util.List;

public class Bicicleta extends MetodoTransporte {
	
	@Override
	public double calcularTiempo(double distancia) {
		// TODO Auto-generated method stub
		double tiempo = distancia/getVelocidadPromedio();
		return tiempo;
	}

	@Override
	public int sugerirDescanso(double tiempo) {
		// TODO Auto-generated method stub
		double tiempoEnMinutos = tiempo*60;
        List<String> sugerenciasDescanso = new ArrayList<>();
        //DEFINIMOS INTERVALOS DE TIEMPO PARA DESCANSOS (en minutos)
        int intervaloCorto = 60; //CADA 1 HORA
        int intervaloLargo = 120; // CADA 2 HORAS
        //CALCULAMOS EL NÚMERO DE DESCANSOS CORTOS Y LARGOS NECESARIOS
        int numDescansosCortos = (int) tiempoEnMinutos/intervaloCorto;
        int numDescansosLargos = (int) tiempoEnMinutos/intervaloLargo;
        
        //AÑADIMOS LAS SUGERENCIAS
        for (int i = 1; i <= numDescansosCortos; i++) {
            int tiempoDescanso = i * intervaloCorto;
            sugerenciasDescanso.add("Descanso corto de " + tiempoDescanso + " minutos");
        }

        for (int i = 1; i <= numDescansosLargos; i++) {
            int tiempoDescanso = i * intervaloLargo;
            sugerenciasDescanso.add("Descanso largo de " + tiempoDescanso + " minutos");
        }
		return sugerenciasDescanso.size();
	}
}
