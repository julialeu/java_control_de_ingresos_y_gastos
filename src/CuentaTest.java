import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CuentaTest {
	
	@Test
	public void testCuentaSaldoInicialEsCero() {
		Usuario usuario1 = new Usuario();
		
		Cuenta cuenta1 = new Cuenta(usuario1);
		
		Assert.assertEquals(0, cuenta1.getSaldo(), 0.001);
	}
	
	
	@Test
	public void testElUsuarioDeLaCuentaSeGuarda() {
		Usuario usuario1 = new Usuario();
		Cuenta cuenta1 = new Cuenta(usuario1);
				
		Assert.assertEquals(usuario1, cuenta1.getUsuario());		
	}
	
	@Test
	public void testSePuedeAñadirIngresos() {
		Usuario usuario1 = new Usuario();
		Cuenta cuenta1 = new Cuenta(usuario1);
		
		double nuevoSaldo = cuenta1.addIngresos("Sepe", 902.04);
		
		Assert.assertEquals(902.04, nuevoSaldo, 0.001);
		
		
	}
	
	@Test
	public void testSePuedeAñadirUnGastoCuandoHaySuficienteDinero() throws GastoException {
		Usuario usuario1 = new Usuario();
		Cuenta cuenta1 = new Cuenta(usuario1);
		
		double nuevoSaldo = cuenta1.addIngresos("Nómina", 1000);
		Assert.assertEquals(1000, nuevoSaldo, 0.001);

		
		nuevoSaldo = cuenta1.addGastos("Hipoteca", 504.08);
		
		Assert.assertEquals(495.92, nuevoSaldo, 0.001);
		Assert.assertEquals(495.92, cuenta1.getSaldo(), 0.001);
		
	}
	
	
	@Test(expected = GastoException.class)
	public void testSeLanzaExcepcionCuandoGastoMayorQueIngreso() throws GastoException{
		
		Usuario usuario1 = new Usuario();
		Cuenta cuenta1 = new Cuenta(usuario1);
		
		double nuevoSaldo = cuenta1.addIngresos("Nómina", 1000);
		nuevoSaldo = cuenta1.addGastos("Derrama", 1200);
	}
	
	@Test
	public void testCuandoHayGastosSeDevuelvenBien() throws GastoException {
		Usuario usuario1 = new Usuario();
		Cuenta cuenta1 = new Cuenta(usuario1);
		
		cuenta1.addIngresos("Nómina", 1000);
		cuenta1.addGastos("Hipoteca", 504.08);
		
		List<Gasto> gastos = cuenta1.getGastos();
		
		Assert.assertEquals(1, gastos.size());
		
	}
	
	@Test
	public void testCuandoHayIngresosSeDevuelvenBien() throws GastoException {
		Usuario usuario1 = new Usuario();
		Cuenta cuenta1 = new Cuenta(usuario1);
		
		cuenta1.addIngresos("Nómina", 1000);
		cuenta1.addGastos("Hipoteca", 504.08);
		
		List<Ingreso> ingresos = cuenta1.getIngresos();
		
		Assert.assertEquals(1, ingresos.size());
		
	}
	
	@Test
	// When al user data is correct, toString should return the name, age and DNI
	public void testToString() throws GastoException {
		
		Usuario usuario1 = new Usuario();
		usuario1.setNombre("Julia");
		Cuenta cuenta1 = new Cuenta(usuario1);
		cuenta1.addIngresos("Nómina", 1000);
		cuenta1.addGastos("Hipoteca", 504.08);

		
		
		Assert.assertEquals("Se devuelven los datos correctamente", "Nombre: Julia, Saldo: 495.92 €",  cuenta1.toString());
	}


	
}
