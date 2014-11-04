/**
 * 
 */
package com.java_youhua.proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**  
 * @ProjectName：javatest  
 * @TypeName：CglibHandler  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class CglibHandler implements MethodInterceptor {
	private Object object;
	
	public Object bind(Object object){
		this.object = object;  
        Enhancer enhancer = new Enhancer();  
        enhancer.setSuperclass(this.object.getClass());  
        // 回调方法  
        enhancer.setCallback(this);  
        // 创建代理对象  
        return enhancer.create();  
	}
	
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		System.out.println("cglib begin");
		Object o = arg3.invokeSuper(arg0, arg2);
		System.out.println("cblib end");
		return o;
	}

}
