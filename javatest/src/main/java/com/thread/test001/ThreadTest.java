/**
 * 
 */
package com.thread.test001;

/**  
 * @ProjectName：javatest  
 * @TypeName：Thread1  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-3-18 下午2:26:03  
 * @creater：zhao_zengjun  
 * @updateDate：2014-3-18 下午2:26:03  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class ThreadTest {
	public static void main(String[] args) {
		new Thread(new Thread1()).start();
		new Thread(new Thread2()).start();
	}
	
}
