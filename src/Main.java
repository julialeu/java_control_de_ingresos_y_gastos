import java.util.Iterator;
import java.util.Scanner;

/*Como se ve, he creado una serie de nétodos privados
 para simplificar el código y hacerlo más legible.*/

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		Usuario usuario1 = new Usuario();

		setUsersName(entrada, usuario1);
		setUsersAge(entrada, usuario1);
		setUsersDni(entrada, usuario1);

		Cuenta cuenta1 = new Cuenta(usuario1);

		showEnterOption();
		/*Mientras no se marque 0, no saldremos del bucle while. Se llama al
		 método processAction. */
		 
		int accion = Integer.parseInt(entrada.nextLine());
		while (accion != 0) {
			processAction(entrada, cuenta1, accion);
			showEnterOption();
			accion = chooseAnOption(entrada);
		}

		System.out.println("Fin del programa.\nGracias por utilizar la aplicación.");
	}
	//los tres primeros métodos son para pedir los datos para la creación del usuario
	private static void setUsersDni(Scanner entrada, Usuario usuario1) {
		System.out.println("Introduce tu dni: ");
		String dni = entrada.nextLine();
		boolean isDniValid = usuario1.setDNI(dni);

		while (!isDniValid) {

			System.out.println("El formato del dni no es válido. Introduzca de nuevo el dni.");
			dni = entrada.nextLine();

			isDniValid = usuario1.setDNI(dni);
		}
	}
	
	private static void setUsersAge(Scanner entrada, Usuario usuario1) {
		System.out.println("Introduce tu edad: ");
		int edad = Integer.parseInt(entrada.nextLine());
		usuario1.setEdad(edad);
	}

	private static void setUsersName(Scanner entrada, Usuario usuario1) {
		System.out.println("Introduce tu nombre: ");
		String nombre = entrada.nextLine();
		usuario1.setNombre(nombre);
	}
	/* método para elegir las opciones del menú y comprobar que el número
	 está comprendido dentro del intervalo de la variable regex.*/
	  
	private static int chooseAnOption(Scanner entrada) {
		int accion;
		String opcion = entrada.nextLine();

		String regex = "^[0-5]{1}$";
		boolean isOpcionCorrect = opcion.matches(regex);

		while (!isOpcionCorrect) {

			System.out.println("La acción elegida no es válida. Introduce una acción válida.");
			opcion = entrada.nextLine();
			isOpcionCorrect = opcion.matches(regex);
		}

		accion = Integer.parseInt(opcion);
		return accion;
	}
	//Método que tiene la estructura switch para llamar a los métodos de cada case
	private static void processAction(Scanner entrada, Cuenta cuenta1, int accion) {
		switch (accion) {
		case 5:
			showBalance(cuenta1);
			break;

		case 2:
			addNewIncome(entrada, cuenta1);
			break;

		case 1:
			addSpending(entrada, cuenta1);
			break;

		case 4:
			showIncomes(cuenta1);
			break;

		case 3:
			showSpendings(cuenta1);
			break;

		}
	}
	/* Método que recorre el arraylist Gastos. Usamos el método Iterator
	Si no hay ningún gasto, lo indicamos por pantalla.*/
	private static void showSpendings(Cuenta cuenta1) {
		System.out.println("Aquí tienes la lista de tus gastos: ");

		Iterator iterator = cuenta1.getGastos().iterator();

		if (cuenta1.getGastos().size() == 0) {
			System.out.println("No hay gastos en tu cuenta.");
		}

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	/* Método que recorre el arraylist Ingresos. Usamos el método Iterator
	Si no hay ningún ingreso, lo indicamos por pantalla.*/
	private static void showIncomes(Cuenta cuenta1) {
		System.out.println("Aquí tienes la lista de tus ingresos: ");

		Iterator iterator = cuenta1.getIngresos().iterator();

		if (cuenta1.getIngresos().size() == 0) {
			System.out.println("No hay ingresos en tu cuenta.");
		}

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	/*Método para añadir gastos.
	 con un while validamos que el importe es de tipo double.*/
	 
	
	private static void addSpending(Scanner entrada, Cuenta cuenta1) {
		System.out.println("Introduce el importe del gasto.");

		boolean isAmountValid = false;
		double gasto = 0;

		while (!isAmountValid) {
			try {
				gasto = Double.parseDouble(entrada.nextLine());
				isAmountValid = true;
			} catch (Exception error) {
				System.out.println("La cantidad no es válida. Introduce el gasto correctamente");
			}
		}

		System.out.println("Introduce el concepto del gasto.");
		String conceptoGasto = entrada.nextLine();

		try {
			cuenta1.addGastos(conceptoGasto, gasto);

			System.out.println("Tu nuevo saldo disponible es " + cuenta1.getSaldo() + "€");
		} catch (GastoException error) {
			System.out.println("No hay saldo suficiente para añadir el gasto.");
		}
	}
	//Método para mostrar el saldo total de la cuenta
	private static void showBalance(Cuenta cuenta1) {
		double saldo = cuenta1.getSaldo();
		System.out.println("Tienes " + saldo + "€ de saldo en tu cuenta.");
	}
	
	/*Método para añadir gastos.
	 con un while validamos que el importe es de tipo double.*/
	private static void addNewIncome(Scanner entrada, Cuenta cuenta1) {
		System.out.println("Introduce una cantidad a ingresar.");

		boolean isAmountValid = false;
		double ingreso = 0;

		while (!isAmountValid) {
			try {
				ingreso = Double.parseDouble(entrada.nextLine());
				isAmountValid = true;
			} catch (Exception error) {
				System.out.println("La cantidad no es válida. Introduce el ingreso correctamente");
			}
		}

		System.out.println("Introduce el concepto del ingreso.");
		String concepto = entrada.nextLine();

		double nuevoSaldo = cuenta1.addIngresos(concepto, ingreso);

		System.out.println("Has ingresado " + ingreso + "€. Tu nuevo saldo es " + nuevoSaldo + "€.");
	}
	//método para mostrar el menú por pantalla.
	private static void showEnterOption() {
		System.out.println("\nRealiza una nueva acción");
		System.out.println("1 Introduce un nuevo gasto");
		System.out.println("2 Introduce un nuevo ingreso");
		System.out.println("3 Mostrar gastos");
		System.out.println("4 Mostrar ingresos");
		System.out.println("5 Mostrar saldo");
		System.out.println("0 Salir");
	}

}
