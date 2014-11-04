/**
 * 
 */
package com.random;

import java.util.Random;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-5-20 上午10:53:04  
 * @creater：zhao_zengjun  
 * @updateDate：2014-5-20 上午10:53:04  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Test {
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			Random random = new Random(System.nanoTime());
			System.out.println(random.nextInt());
		}
	}
}
