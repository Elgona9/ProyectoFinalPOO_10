/**
 * NOMBRE DEL PROGRAMA: PLANIFICADOR DE RUTAS
 * AUTORES: DAVID RIVEROS, NICOLAS JIMENEZ Y SEBASTIAN RANGEL
 * FECHA ENTREGA PROYECTO: 27 DE NOVIEMBRE DE 2023
 * VERSION: 0.01
 */
package logica;

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
	/**
	 * @param capacidadTanque the capacidadTanque to set
	 */
	public void setCapacidadTanque(double capacidadTanque) {
		this.capacidadTanque = capacidadTanque;
	}
	@Override
	public double calcularTiempo(double distancia) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @return the capacidadTanque
	 */

	@Override
	public List<String> sugerirDescanso(double tiempo) {
		// TODO Auto-generated method stub
		return null;
	}

}
