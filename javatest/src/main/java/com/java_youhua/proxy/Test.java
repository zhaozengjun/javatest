/**
 * 
 */
package com.java_youhua.proxy;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class Test {
	
	public static void main(String[] args) {
		
//		DoSomething doSomething = new DoSomething();
//		doSomething.dosomething();
		
		
		IDoSomething doSomething = new DoSmethingProxy();
		doSomething.dosomething();
		
	}
	
}
