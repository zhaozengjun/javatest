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
public class InnerClassSingleton {

	private InnerClassSingleton(){
		
	}
	
	private static class SingletonHolder{
		private static InnerClassSingleton instance = new InnerClassSingleton();
	}
	
	public static InnerClassSingleton getInstance(){
		return SingletonHolder.instance;
	}
	
}
