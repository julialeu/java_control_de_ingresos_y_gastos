
public class Ingreso extends Dinero {
	
	/* Creo la clase Ingreso que hereda de la clase Dinero
	   y el método constructor con los parámetros que pide la pac */
	
	public Ingreso(double ingreso, String description) {
		this.dinero = ingreso;
		this.description = description;
	}
	
	@Override
	public String toString()
	{
		return "Ingreso: " + getDescription() + " " + getDinero() + " €";
	}

	

}
