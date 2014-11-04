/**
 * 
 */
package com.java_youhua.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**  
 * @ProjectName：javatest  
 * @TypeName：JdkHandler  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class JdkHandler implements InvocationHandler {

	private Object object;
	
	public JdkHandler(Object object){
		this.object = object;
	}
	
	public Object bind(){
		return Proxy.newProxyInstance(
				DoSomething.class.getClassLoader(), 
				DoSomething.class.getInterfaces(), 
				this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("1111");
		Object o = method.invoke(object, args);
		System.out.println("2222");
		return o;
	}

}
