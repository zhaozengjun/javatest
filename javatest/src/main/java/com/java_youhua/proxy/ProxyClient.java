/**
 * 
 */
package com.java_youhua.proxy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Enhancer;

import com.core.test.copy.Class;

/**  
 * @ProjectName：javatest  
 * @TypeName：ProxyClient  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class ProxyClient {

	public static void main(String[] args) {
		jdkProxy();
	}
	
	public static void jdkProxy(){
//		JdkHandler handler = new JdkHandler(new DoSomething());
//		IDoSomething doSomething = 
//				(IDoSomething)handler.bind();
		
		CglibHandler cglibHandler = new CglibHandler();
		IDoSomething doSomething = (IDoSomething)cglibHandler.bind(new DoSomething());
		doSomething.dosomething();
		
		System.out.println("doSomething instanceof Proxy:" + (doSomething instanceof Proxy));
		 System.out.println("subject的Class类是："+doSomething.getClass().toString());
		 System.out.print("subject中的属性有：");
		 Field[] field=doSomething.getClass().getDeclaredFields();
		 for(Field f:field){
		 System.out.print(f.getName()+", ");
		 }
		 System.out.print("\n"+"subject中的方法有：");
		 Method[] method=doSomething.getClass().getDeclaredMethods();
		 for(Method m:method){
		 System.out.print(m.getName()+", ");
		 }
		 System.out.println("\n"+"subject的父类是："+doSomething.getClass().getSuperclass());
		 System.out.print("\n"+"subject实现的接口是：");
//		 Class[] interfaces=doSomething.getClass().getInterfaces();
//		 for(Class i:interfaces){
//		 System.out.print(i.getName()+", ");
//		 } 
		 
		
//		doSomething.dosomething();
	}
	
}
