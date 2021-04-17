import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada;
		
		entrada = new Scanner (System.in);
		
		Usuario usuario1 = new Usuario();
		
		System.out.println("Introduce tu nombre: ");		
		String nombre = entrada.nextLine();	
		usuario1.setNombre(nombre);	
		
	
		System.out.println("Introduce tu edad: ");
		int edad = Integer.parseInt(entrada.nextLine());
		usuario1.setEdad(edad);
	
		
		System.out.println("Introduce tu dni: ");
		String dni = entrada.nextLine();
		boolean isDniValid = usuario1.setDNI(dni);
		
		while (!isDniValid) {	
			
			System.out.println("El formato del dni no es válido. Introduzca de nuevo el dni.");
			
			dni = entrada.nextLine();
			
			isDniValid = usuario1.setDNI(dni);
		}

		Cuenta cuenta1 = new Cuenta (usuario1);
		
		System.out.println("Realiza una nueva acción");
		System.out.println("1 Introduce un nuevo gasto");
		System.out.println("2 Introduce un nuevo ingreso");
		System.out.println("3 Mostrar gastos");
		System.out.println("4 Mostrar ingresos");
		System.out.println("5 Mostrar saldo");
		System.out.println("0 Salir");
		
		int accion = Integer.parseInt(entrada.nextLine());
		
		while (accion != 0) {
			
			System.out.println("Has elegido la acción " + accion);
			
			if (accion == 5) {
				
				double saldo = cuenta1.getSaldo();
				
				System.out.println("Tienes " + saldo + "€ de saldo en tu cuenta.");
			} 
			
			if (accion == 2) {
				
				System.out.println("Introduce una cantidad a ingresar.");
				
				double ingreso = Double.parseDouble(entrada.nextLine());
				
				System.out.println("Introduce el concepto del ingreso.");
				
				String concepto = entrada.nextLine();
				
				double nuevoSaldo = cuenta1.addIngresos(concepto, ingreso);
				
				System.out.println("Has ingresado " + ingreso + "€. Tu nuevo saldo es " + nuevoSaldo + "€.");
				
			}
			
			
			
			
			
			
			
			System.out.println("Realiza una nueva acción");
			String opcion = entrada.nextLine();
			
			String regex = "^[0-5]{1}$";
			boolean isOpcionCorrect = opcion.matches(regex);
			
			while(!isOpcionCorrect) {
				
				System.out.println("La acción elegida no es válida. Introduce una acción válida.");
				opcion = entrada.nextLine();
				isOpcionCorrect = opcion.matches(regex);
			}
			
			
			accion = Integer.parseInt(opcion);	
		}
		
		System.out.println("Fin del programa.\nGracias por utilizar la aplicación.");
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
