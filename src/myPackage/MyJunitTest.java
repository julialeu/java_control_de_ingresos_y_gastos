package myPackage;

import org.junit.Assert;
import org.junit.Test;

public class MyJunitTest {
	
	@Test
	public void  testMySumWorksFine() {
		System.out.println("Hola, mi primer test.");
		
		int suma = 1 + 1;
		
		Assert.assertEquals("Uno más uno es dos", suma, 2);
	}

}
