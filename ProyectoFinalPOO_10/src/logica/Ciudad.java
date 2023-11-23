package logica;

public class Ciudad {
	//ATRIBUTOS
	private String nombre;
	private double latitud;
	private double longitud;
	//MÉTODO CONSTRUCTOR
	public Ciudad() {
		
	}
	public Ciudad(String nombre, double latitud, double longitud) {
		
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the latitud
	 */
	public double getLatitud() {
		return latitud;
	}
	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	/**
	 * @return the longitud
	 */
	public double getLongitud() {
		return longitud;
	}
	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public double calcularDistancia(double lat1, double lat2, double lon1, double lon2) {
		final double RADIO = 6371; //radio de la tierra en kilómetros
		//convertimos las longitudes y latitudes a radianes
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);
		lon1 = Math.toRadians(lon1);
		lon2 = Math.toRadians(lon2);
		//calculamos las diferencias entre latitud y longitud
		double dlat = lat2 - lat1;
		double dlon = lon2 - lon1;
		//vamos a calcular la distancia usando la formula de HARVESINE
		double a = Math.sin(dlat/2) * Math.sin(dlat/2) + Math.cos(lat1) * Math.cos(lat2) * Math.sin(dlon/2) * Math.sin(dlon/2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		//DISTANCIA EN KILÓMETROS
		return RADIO * c;
	}
}
