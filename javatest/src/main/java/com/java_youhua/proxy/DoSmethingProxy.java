/**
 * 
 */
package com.java_youhua.proxy;

/**  
 * @ProjectName：javatest  
 * @TypeName：DoSmethingProxy  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class DoSmethingProxy implements IDoSomething {
	
	public DoSomething doSomething = null;

	@Override
	public void dosomething() {
		if (doSomething == null) {
			doSomething = new DoSomething();
		}
		doSomething.dosomething();
	}

}
