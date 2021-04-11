import java.util.regex.Pattern;

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

		String regex = "^[0-9]{8}-?[a-zA-Z]{1}";

		/*
		 * Pattern patron = Pattern.compile(regex); boolean esDniValido =
		 * Pattern.matcher(DNI).matches();
		 */

		boolean isDniValid = DNI.matches(regex);

		if (!isDniValid) {

			return false;
		}

//		if (DNI.length() < 9 || DNI.length() > 10) {
//			return false;
//		}
//
//		for (int i = 0; i < 8; i++) {
//			char c = DNI.charAt(i);
//
//			if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8'
//					&& c != '9') {
//				return false;
//			}
//
//		}
//
//		if (DNI.length() == 10) {
//			char separador = DNI.charAt(8);
//			if (separador != '-') {
//				return false;
//			}
//		}
//
//		char ultimoCaracter = DNI.charAt(DNI.length() - 1);
//		if (Character.isLetter(ultimoCaracter) == false) {
//			return false;
//		}
//		if (ultimoCaracter == 'Ñ') {
//			return false;
//		}

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
