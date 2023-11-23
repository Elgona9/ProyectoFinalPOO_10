/**
 * NOMBRE DEL PROGRAMA: PLANIFICADOR DE RUTAS
 * AUTORES: DAVID RIVEROS, NICOLAS JIMENEZ Y SEBASTIAN RANGEL
 * FECHA ENTREGA PROYECTO: 27 DE NOVIEMBRE DE 2023
 * VERSION: 0.01
 */
package logica;

import java.util.ArrayList;
import java.util.List;

public class Carro extends MetodoTransporte {
	//ATRITUBOS NUEVOS
	private double capacidadTanque;
	//MÉTODO CONSTRUCTOR
	public Carro() {
		super();
	}
	//MÉTODO CONSTRUCTOR CON PARÁMETROS
	public Carro(double velocidadPromedio, double gastoGasolina, double capacidadTanque) {
		super(velocidadPromedio, gastoGasolina);
		this.capacidadTanque = capacidadTanque;
	}
	//GETTERS Y SETTERS
	public double getCapacidadTanque() {
		return capacidadTanque;
	}
	public void setCapacidadTanque(double capacidadTanque) {
		this.capacidadTanque = capacidadTanque;
	}
	//MÉTODOS
	@Override
	//CALCULAR TIEMPO
	public double calcularTiempo(double distancia) {
		// TODO Auto-generated method stub
		//Aquí calculamos el tiempo estimado del viaje
		return distancia/getVelocidadPromedio();
	}
	//OBTENER DESCANSOS
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
	//MÉTODO PARA CALCULAR LA EFICACIA DEL COMBUSTIBLE
	public double obtenerEficaciaCombustible() {
		double autonomia = capacidadTanque * getVelocidadPromedio();
		return autonomia / capacidadTanque;
	}
	//MÉTODO PARA CALCULAR LA DISTANCIA MÁXIMA ANTES DE QUE LA GASOLINA SE ACABE
	public double distanciaMaxima() {
		double distanciaMaxima;
		distanciaMaxima = capacidadTanque * obtenerEficaciaCombustible();
		return distanciaMaxima;
	}
	//MÉTODO PARA SUGERIR PARADAS PARA LLENAR COMBUSTIBLE
    public List<String> sugerirParadasGasolina(int distanciaTotal) {
        List<String> sugerenciasGasolina = new ArrayList<>();

    	int numParadasGasolina = (int) Math.ceil(distanciaTotal / distanciaMaxima());
    	
    	//PROCEDEMOS A AÑADIR LAS SUGERENCIAS
    	for (int i = 1; i <= numParadasGasolina; i++) {
    		int distanciaRecorrida = i * (int) distanciaMaxima();
    		sugerenciasGasolina.add("Parada para gasolina después de recorrer" + distanciaRecorrida + "kilómetros.");
    	}
    	return sugerenciasGasolina;
    }

}
