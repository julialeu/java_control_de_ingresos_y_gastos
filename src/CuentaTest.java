import org.junit.Assert;
import org.junit.Test;

public class CuentaTest {
	
	@Test
	public void testSaldoInicialEsCero() {
		Usuario usuario1 = new Usuario();
		
		Cuenta cuenta1 = new Cuenta(usuario1);
		
		Assert.assertEquals(0, cuenta1.getSaldo(), 0.00001);
		
		
		
	}
	
	


	
	
}
