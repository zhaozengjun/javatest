/**
 * 
 */
package com.java_youhua.singleton;

/**  
 * @ProjectName：javatest  
 * @TypeName：Singleton  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class Singleton {

	private static Singleton instance = new Singleton();
	
	private Singleton(){
		
	};
	
	public static Singleton getInstance(){
//		try {
//			Thread.sleep(1);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return instance;
	}
	
}
