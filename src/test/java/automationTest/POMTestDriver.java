package automationTest;

import org.junit.Test;

public class POMTestDriver {

	/*There are many different ways to set this up dependent upon the context of the mission*/
	
	@Test
	public void testFire(){
		System.out.println("This is fireFox");
		POMTest pt = new POMTest();
		pt.loginTest("firefox");
	}
	
	@Test
	public void testIE() {
		System.out.println("This is IE");
		POMTest pt = new POMTest();
		pt.loginTest("ie");
	}
	
	
}
