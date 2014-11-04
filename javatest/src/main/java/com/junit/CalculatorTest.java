/**
 * 
 */
package com.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**  
 * @ProjectName：javatest  
 * @TypeName：CalculatorTest  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-7-3 下午5:40:44  
 * @creater：zhao_zengjun  
 * @updateDate：2014-7-3 下午5:40:44  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class CalculatorTest {

	private static Calculator calculator = new Calculator();
	
	/**
	 * @author：zhao_zengjun  
	 * @Title: setUp
	 * @throws java.lang.Exception
	 * void
	 * @throws
	 */
	@Before
	public void setUp() throws Exception {
		calculator.clear();
	}

	/**
	 * Test method for {@link com.junit.Calculator#add(int)}.
	 */
	@Test
	public void testAdd() {
		calculator.add(2);

        calculator.add(3);

        assertEquals(5, calculator.getResult());
	}

	/**
	 * Test method for {@link com.junit.Calculator#substract(int)}.
	 */
	@Test
	public void testSubstract() {
		calculator.add(10);

        calculator.substract(2);

        assertEquals(8, calculator.getResult());
	}

	/**
	 * Test method for {@link com.junit.Calculator#multiply(int)}.
	 */
	
	@Ignore("Multiply() Not yet implemented")
	@Test
	public void testMultiply() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.junit.Calculator#divide(int)}.
	 */
	@Test(expected = ArithmeticException.class)
	public void testDivide() {
		calculator.add(8);

        calculator.divide(0);

        assertEquals(4, calculator.getResult());
	}

}
