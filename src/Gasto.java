
public class Gasto extends Dinero {
	
	/* Creo la clase Gasto que hereda de la clase Dinero
	   y el método constructor con los parámetros que pide la pac */
	
	public Gasto(double gasto, String description) {
		this.dinero = gasto;
		this.description = description;
	}
	
	@Override
	public String toString()
	{
		return "Gasto: " + getDescription() + " " + getDinero() + " €";
	}
}
