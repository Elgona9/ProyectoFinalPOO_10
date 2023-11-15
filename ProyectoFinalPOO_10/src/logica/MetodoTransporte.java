/**
 * NOMBRE DEL PROGRAMA: PLANIFICADOR DE RUTAS
 * AUTORES: DAVID RIVEROS, NICOLAS JIMENEZ Y SEBASTIAN RANGEL
 * FECHA ENTREGA PROYECTO: 27 DE NOVIEMBRE DE 2023
 * VERSION: 0.01
 */
package logica;
//IMPORTAMOS PAQUETES ÚTILES
import java.util.List;

public abstract class MetodoTransporte {
	private double velocidadPromedio;
	private double gastoGasolina;
	
	//MÉTODO CONSTRUCTOR
	public MetodoTransporte() {
		
	}
	//MÉTODO CONSTRUCTOR CON PARÁMETROS
	public MetodoTransporte(double velocidadPromedio, double gastoGasolina) {
		this.velocidadPromedio = velocidadPromedio;
		this.gastoGasolina = gastoGasolina;
	}
	//GETTERS Y SETTERS
	public double getVelocidadPromedio() {
		return velocidadPromedio;
	}
	public void setVelocidadPromedio(double velocidadPromedio) {
		this.velocidadPromedio = velocidadPromedio;
	}
	public double getGastoGasolina() {
		return gastoGasolina;
	}
	public void setGastoGasolina(double gastoGasolina) {
		this.gastoGasolina = gastoGasolina;
	}
	//MÉTODOS ADICIONALES
	//MÉTODO PARA CALCULAR EL TIEMPO ESTIMADO DE VIAJE
	public abstract double calcularTiempo(double distancia);
	//MÉTODO PARA SUGERIR DESCANSOS
	public abstract List<String> sugerirDescanso(double tiempo);
}
