/**
 * 
 */
package com.core.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**  
 * @ProjectName：javatest  
 * @TypeName：TraceHandler  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-4-9 下午3:53:32  
 * @creater：zhao_zengjun  
 * @updateDate：2014-4-9 下午3:53:32  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class TraceHandler implements InvocationHandler {
	
	private Object target;
	
	public TraceHandler(Object object){
		target = object;
	}

	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.print(target + ".");
		System.out.println(method.getName());
		return method.invoke(target, args);
	}
	
	public static void main(String[] args) {
		Object[] elements = new Object[100];
		Class[] interfaces = new Class[]{Comparable.class};
		for (int i = 0; i < elements.length; i++) {
			Integer integer = i+1;
			InvocationHandler handler = new TraceHandler(integer);
			elements[i] = Proxy.newProxyInstance(null, interfaces, handler);
		}
		Integer key = new Random().nextInt(elements.length) + 1;
		int result = Arrays.binarySearch(elements, key);
		if (result > 0) {
			System.out.println(elements[result]);
		}
	}

}
