
public abstract class Dinero {
	
	// aquí he creado los atributos de la clase abstracta Dinero
	protected double dinero;
	protected String description;
	
	
	/* y aquí he creado los métodos getters y setters de cada
	 *  uno de los atributos de la clase dinero
	 */
	public double getDinero() {
		
		return dinero;
	}
	
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
