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
			
			System.out.println("Realiza una nueva acción");
			
			accion = Integer.parseInt(entrada.nextLine());
			
			
		}
		
		System.out.println("Fin del programa.\nGracias por utilizar la aplicación.");
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
