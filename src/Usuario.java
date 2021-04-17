public class Usuario {
	
	// defino los atributos de la clase conforme a la pac
	private String nombre;
	private int edad;
	private String DNI;

	// esto es el método constructor de la clase
	public Usuario() {

	}
	
	//creo los getters y setters según la pac
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
		
		/*método para comprobar que el formato
		 del dni es válido. Si la variable booleana es true
		 se da valor al atributo DNI
		 */

		String regex = "^[0-9]{8}-?[a-zA-Z]{1}$";
		
		/*Declaro la varible string regex que contiene la
		 expresión válida de DNI incluyendo todas las letras
		 del alfabeto, tanto mayúsculas como minúsculas
		 */

		boolean isDniValid = DNI.matches(regex);

		if (!isDniValid) {

			return false;
		}

		this.DNI = DNI.toUpperCase();

		return true;

	}
	
	public String getDNI() {

		return DNI;
	}
	@Override
	public String toString() {

		return "Nombre: " + this.getNombre() + ", Edad: " + this.getEdad() + ", DNI:" + this.getDNI();
	}

}
