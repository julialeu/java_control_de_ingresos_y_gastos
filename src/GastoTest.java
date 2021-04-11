import org.junit.Assert;
import org.junit.Test;


public class GastoTest {

	@Test
	public void testGastoParametersAreSetCorrectly() {
		Gasto gasto1 = new Gasto(22.5, "Mercadona");
		
		Assert.assertEquals(22.5, gasto1.getDinero(), 0.001);
		Assert.assertEquals("Mercadona", gasto1.getDescription());
		Assert.assertEquals("Gasto: Mercadona 22.5 €", gasto1.toString());
	}
}
