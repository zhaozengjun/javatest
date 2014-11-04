/**
 * 
 */
package com.junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**  
 * @ProjectName：javatest  
 * @TypeName：CalculatorTest1  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-7-3 下午6:06:04  
 * @creater：zhao_zengjun  
 * @updateDate：2014-7-3 下午6:06:04  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
@RunWith(Parameterized.class)
public class CalculatorTest1 {
	private static Calculator calculator = new Calculator();

	private int param;

	private int result;    

	@Parameters
	public static Collection data() {

		return Arrays.asList(new Object[][]{

				{2, 4},

				{0, 0},

				{-3, 9}

		});

	}

	public CalculatorTest1(int param, int result) {

		this.param = param;
		this.result = result;

	}
	/**
	 * Test method for {@link com.junit.Calculator#square(int)}.
	 */
	@Test
	public void testSquare() {
		calculator.square(param);

		assertEquals(result, calculator.getResult());
	}

}
