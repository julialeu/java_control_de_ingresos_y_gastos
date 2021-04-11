import org.junit.Assert;
import org.junit.Test;

public class UsuarioTest {
	@Test
	public void testPuedoAsignarYObtenerNombre() {
		
		Usuario usuario1 = new Usuario();
		usuario1.setNombre("Julia");
		
		String nombreActual = usuario1.getNombre();
		
		Assert.assertEquals("Se devuelve el nombre correcto", "Julia", nombreActual);
	}
	
	
	@Test
	public void testPuedoAsignarYObtenerEdad() {
		
		Usuario usuario1 = new Usuario();
		usuario1.setEdad(31);
		
		int edadActual = usuario1.getEdad();
		
		Assert.assertEquals("Se devuelve la edad correcto", 31 , edadActual);
	}
	
	@Test
	// When we set a valid DNI
	// - The setter should return true
	// - DNI should be setted
	public void testDNICorrectoSinGuion() {
		
		Usuario usuario1 = new Usuario();
		boolean esDniValido = usuario1.setDNI("25725326-X");
		
		Assert.assertTrue("Cuando el DNI es correcto, debería ser true", esDniValido);
		Assert.assertEquals("El DNI es el asignado" , "25725326-X",  usuario1.getDNI());
	}
	
	@Test
	// When we set a valid DNI with 
	// - The setter should return true
	// - DNI should be setted
	public void testDNICorrectoConGuion() {
		
		Usuario usuario1 = new Usuario();
		boolean esDniValido = usuario1.setDNI("25725326X");
		
		Assert.assertTrue("Cuando el DNI es correcto, debería ser true", esDniValido);
		Assert.assertEquals("El DNI es el asignado" , "25725326X",  usuario1.getDNI());
	}
	
	@Test
	// When we set a valid DNI with lowercase letter
	// - The setter should return true
	// - DNI should be setted
	public void testDNICorrectoConLetraMinuscula() {
		
		Usuario usuario1 = new Usuario();
		boolean esDniValido = usuario1.setDNI("25725326x");
		
		Assert.assertTrue("Cuando el DNI es correcto, debería ser true", esDniValido);
		Assert.assertEquals("El DNI es el asignado" , "25725326X",  usuario1.getDNI());
	}
	
	
	@Test
	// When we set a DNI with less than 8 characters
	// - The setter should return false
	// - DNI should be null
	public void testDNILongitudIncorrecta() {
		
		Usuario usuario1 = new Usuario();
		boolean esDniValido = usuario1.setDNI("27X");
		
		Assert.assertFalse("Cuando el DNI es demasiado corto, devuelve false", esDniValido);
		Assert.assertNull("El DNI debería de ser null" , usuario1.getDNI());
	}
	
	@Test
	// When we set a DNI with more than 10 characters
	// - The setter should return false
	// - DNI should be null
	public void testDNILongitudDemasiadoLarga() {
		
		Usuario usuario1 = new Usuario();
		boolean esDniValido = usuario1.setDNI("27555555555555X");
		
		Assert.assertFalse("Cuando el DNI es demasiado largo, devuelve false", esDniValido);
		Assert.assertNull("El DNI debería de ser null" , usuario1.getDNI());
	}
	
	@Test
	// When we set a DNI that has a letter in one of the first 9 characters
	// - The setter should return false
	// - DNI should be null
	public void testDNIHayUnaLetraEnLos8PrimerosCaracters() {
		
		Usuario usuario1 = new Usuario();
		boolean esDniValido = usuario1.setDNI("7A808059H");
		
		Assert.assertFalse("Al setear el DNI debería de devolver false", esDniValido);
		Assert.assertNull("El DNI debería de ser null" , usuario1.getDNI());
	}
	
	@Test
	// When we set a DNI that has not (-) symbol but an asterisk
	// - The setter should return false
	// - DNI should be null
	public void testGuionIsCorrect() {
		
		Usuario usuario1 = new Usuario();
		boolean esDniValido = usuario1.setDNI("72808059*H");
		
		Assert.assertFalse("Al setear el DNI debería de devolver false", esDniValido);
		Assert.assertNull("El DNI debería de ser null" , usuario1.getDNI());
	}
	
	@Test
	// When we set a DNI that has not a letter in the last possition
	// - The setter should return false
	// - DNI should be null
	public void testUltimoCaracterEsUnaLetra() {
		
		Usuario usuario1 = new Usuario();
		boolean esDniValido = usuario1.setDNI("72808059-9");
		
		Assert.assertFalse("Al setear el DNI debería de devolver false", esDniValido);
		Assert.assertNull("El DNI debería de ser null" , usuario1.getDNI());
	}
	
	@Test
	// When we set a DNI last letter is an Ñ
	// - The setter should return false
	// - DNI should be null
	public void testUltimoCaracterEsUnaLetraEñe() {
		
		Usuario usuario1 = new Usuario();
		boolean esDniValido = usuario1.setDNI("72808059-Ñ");
		
		Assert.assertFalse("Al setear el DNI debería de devolver false", esDniValido);
		Assert.assertNull("El DNI debería de ser null" , usuario1.getDNI());
	}
	
	
	@Test
	// When al user data is correct, toString should return the name, age and DNI
	public void testToString() {
		
		Usuario usuario1 = new Usuario();
		boolean esDniValido = usuario1.setDNI("25725326X");
		usuario1.setNombre("Julia");
		usuario1.setEdad(31);
		
		String labelDatosUsuario = usuario1.toString();

		
		Assert.assertEquals("Se devuelven los datos correctamente", "Nombre: Julia, Edad: 31, DNI:25725326X",  labelDatosUsuario);
	}

}
