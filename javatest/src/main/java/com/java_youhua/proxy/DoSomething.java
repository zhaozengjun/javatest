/**
 * 
 */
package com.java_youhua.proxy;

/**  
 * @ProjectName：javatest  
 * @TypeName：DoSomething  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class DoSomething implements IDoSomething {

	public DoSomething(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void dosomething(){
		System.out.println("just do it！");
	}
	
}
