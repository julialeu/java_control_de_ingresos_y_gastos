import org.junit.Assert;
import org.junit.Test;

public class IngresoTest {
	
	@Test
	public void testIngresoParametersAreSetCorrectly() {
		Ingreso ingreso1 = new Ingreso (1219.87, "Nómina");
		
		Assert.assertEquals(1219.87, ingreso1.getDinero(), 0.001);
		Assert.assertEquals("Nómina", ingreso1.getDescription());
		Assert.assertEquals("Ingreso: Nómina 1219.87 €", ingreso1.toString());
	}

}
pwd