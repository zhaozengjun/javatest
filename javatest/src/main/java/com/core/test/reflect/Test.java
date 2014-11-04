/**
 * 
 */
package com.core.test.reflect;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-4-8 下午4:42:11  
 * @creater：zhao_zengjun  
 * @updateDate：2014-4-8 下午4:42:11  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Test {

	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		
		try {
			Class class1 = Class.forName("java.lang.Date");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
