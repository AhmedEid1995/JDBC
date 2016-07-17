package eg.edu.alexu.csd.oop.calculator;

import static org.junit.Assert.*;

import org.junit.Before;

public class Test {
	//CalculatorDummyEngine c= new CalculatorDummyEngine();
	CalculatorDummyEngine c=CalculatorDummyEngine.getInstance();
	@Before 
	public void initialize() {
		CalculatorDummyEngine.destoryInstance();
	}

	@org.junit.Test
	public void test1() {
		c.input("5+6");
		
		c.input("3+4");
		
		c.input("2+2");
		
		c.input("8+5");
		
		assertEquals("8+5", c.current());
		assertEquals(null, c.next());
		assertEquals("2+2", c.prev());
		assertEquals(Double.parseDouble("4.0"),
				Double.parseDouble(c.getResult()), 1e-19);
		assertEquals("3+4", c.prev());
		assertEquals("5+6", c.prev());
		assertEquals(null, c.prev());
		assertEquals("3+4", c.next());
		assertEquals("5+6", c.prev());
		assertEquals(null, c.prev());
		c.input("5+6");
		
		c.input("3+4");
		
		c.input("2+2");
		
		c.input("8+5");
		
		c.input("9+6");
		
		c.input("8+19");
		
		assertEquals(null, c.next());
		for (int counter = 0; counter < 5; counter++) {
			c.prev();
		}
		assertEquals(null, c.prev());
		
		try{
			c.input("fff + 5");
			c.getResult();
			fail("had to crash");
		}catch(RuntimeException e){}
	
	}
	@org.junit.Test
	public void testSaveLoad() {
		try {
			c.load();
			fail("had to crash");
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block

		}
		c.save();
		try {
			c.load();
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			fail("wrong craSh :D :D");
		}
		c.input("5+6");
		c.input("3+4");
		c.input("2+2");
		c.input("8+5");
		c.input("7+6");
		c.load();
		assertEquals(null, c.current());
		c.input("5+6");
		c.input("3+4");
		c.input("2+2");
		c.input("8+5");
		c.input("7+6");
		c.save();
		c.input("3+3");
		c.load();
		assertEquals("7+6", c.current());
		assertEquals(null, c.next());
		assertEquals("8+5", c.prev());
		c.save();
		c.input("3");
		assertEquals(null, c.next());
		c.load();
	}
	
	
	@org.junit.Test
	public void testSaveLoad2() {
		c.input("1+1");
		c.input("1+2");
		c.input("1+3");
		c.input("1+4");
		c.input("1+5");
		c.input("1+6");
		c.input("1+7");
		c.prev();
		c.prev();
		c.prev();
		assertEquals("5.0", c.getResult());
		assertEquals("1+3", c.prev());
		assertEquals("1+4", c.next());
		c.save();
		c.load();
		assertEquals("1+4", c.current());
	}
}