//import java.util.regex.Pattern;

public class Usuario {

	private String nombre;
	private int edad;
	private String DNI;

	public Usuario() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean setDNI(String DNI) {

		String regex = "^[0-9]{8}-?[a-zA-Z]{1}$";

		boolean isDniValid = DNI.matches(regex);

		if (!isDniValid) {

			//return false;
		}

		this.DNI = DNI.toUpperCase();

		return true;

	}

	public String getDNI() {

		return DNI;
	}

	public String toString() {

		return "Nombre: " + this.getNombre() + ", Edad: " + this.getEdad() + ", DNI:" + this.getDNI();
	}

}
