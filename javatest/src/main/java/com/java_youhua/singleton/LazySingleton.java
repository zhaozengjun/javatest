/**
 * 
 */
package com.java_youhua.singleton;

/**  
 * @ProjectName：javatest  
 * @TypeName：LazySingleton  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class LazySingleton {

	private static LazySingleton instance = null;
	
	private LazySingleton(){};
	
	public static synchronized LazySingleton getInstance(){
//		try {
//			Thread.sleep(1);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
	
}
