package logica;

import java.io.Serializable;
import java.util.List;

public class Almacenado implements Serializable{
    private static final long serialVersionUID = 1L;

    private String origen;
    private String destino;
    private double tiempoEstimado;
    private int numParadasDescanso;
    private int numParadasGasolina;

    //CONSTRUCTOR
    public Almacenado() {
    	
    }
    //CONSTRUCTOR CON PARÁMETROS
    public Almacenado(String origen, String destino, double tiempoEstimado, int numParadasDescanso, int numParadasGasolina) {
    	this.origen = origen;
    	this.destino = destino;
    	this.tiempoEstimado = tiempoEstimado;
    	this.numParadasDescanso = numParadasDescanso;
    	this.numParadasGasolina = numParadasGasolina;
    }
    //GETTERS Y SETTERS

    /**
	 * @return the origen
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}

	/**
	 * @return the destino
	 */
	public String getDestino() {
		return destino;
	}

	/**
	 * @param destino the destino to set
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}

	/**
	 * @return the tiempoEstimado
	 */
	public double getTiempoEstimado() {
		return tiempoEstimado;
	}

	/**
	 * @param tiempoEstimado the tiempoEstimado to set
	 */
	public void setTiempoEstimado(double tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}

	/**
	 * @return the numParadasDescanso
	 */
	public int getNumParadasDescanso() {
		return numParadasDescanso;
	}

	/**
	 * @param numParadasDescanso the numParadasDescanso to set
	 */
	public void setNumParadasDescanso(int numParadasDescanso) {
		this.numParadasDescanso = numParadasDescanso;
	}

	/**
	 * @return the numParadasGasolina
	 */
	public int getNumParadasGasolina() {
		return numParadasGasolina;
	}

	/**
	 * @param numParadasGasolina the numParadasGasolina to set
	 */
	public void setNumParadasGasolina(int numParadasGasolina) {
		this.numParadasGasolina = numParadasGasolina;
	}

}
