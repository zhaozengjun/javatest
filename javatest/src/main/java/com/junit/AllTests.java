/**
 * 
 */
package com.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**  
 * @ProjectName：javatest  
 * @TypeName：AllTests  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-7-3 下午6:00:51  
 * @creater：zhao_zengjun  
 * @updateDate：2014-7-3 下午6:00:51  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
@RunWith(Suite.class)
@SuiteClasses({ CalculatorTest.class , CalculatorTest1.class})
public class AllTests {

}
