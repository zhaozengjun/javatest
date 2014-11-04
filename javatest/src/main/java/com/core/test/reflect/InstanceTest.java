/**
 * 
 */
package com.core.test.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import oracle.net.aso.f;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-4-8 下午4:35:28  
 * @creater：zhao_zengjun  
 * @updateDate：2014-4-8 下午4:35:28  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class InstanceTest {

	
	
	public static void showSuperClass(Class class1){
		if (class1 != null) {
			Class class2 = class1.getSuperclass();
			if (class2 != null) {
				System.out.println(class2.getName());
				showSuperClass(class2);
			}
		}
	}
	
	
	/**
	 * @throws Exception 
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) throws Exception {
		/*A a1 = new A();
		A a2 = new B();
		B b1 = new B();
		IA b2 = new B();
		
		System.out.println("a1 instanceof A == " + (a1 instanceof A));
		System.out.println("a1 instanceof B == " + (a1 instanceof B));
		System.out.println("a1 instanceof IA == " + (a1 instanceof IA));
		System.out.println("a2 instanceof A == " + (a2 instanceof A));
		System.out.println("a2 instanceof B == " + (a2 instanceof B));
		System.out.println("a2 instanceof IA == " + (a2 instanceof IA));
		System.out.println("b1 instanceof A == " + (b1 instanceof A));
		System.out.println("b1 instanceof B == " + (b1 instanceof B));
		System.out.println("b1 instanceof IA == " + (b1 instanceof IA));
		System.out.println("b2 instanceof A == " + (b2 instanceof A));
		System.out.println("b2 instanceof B == " + (b2 instanceof B));
		System.out.println("b2 instanceof IA == " + (b2 instanceof IA));*/
		
		
		/*Class<?> class1 = Class.forName("com.core.test_reflect.B");
		Class<?> class2 = Class.forName("com.core.test_reflect.C");
		showSuperClass(class1);
		C c = new C();
		c.sayHello();
		System.out.println(class2.getName());
		Class class3 = class2.asSubclass(class1);
		System.out.println(class3.getName());
		System.out.println(class2 == class3);
		B b = (B)class1.newInstance();
		b.sayHello();*/
		
		Class<?> class1 = Class.forName("com.core.test_reflect.B");
		Object object = class1.newInstance();
		Method[] methods = class1.getMethods();
		for (Method method : methods) {
			//System.out.println(method.getName() + "--" + method.getModifiers());
		}
		
		Field[] fields = class1.getDeclaredFields();
		AccessibleObject.setAccessible(fields, true);
		for (Field field : fields) {
			System.out.println(field.getName());
			System.out.println(field.get(object));
		}
		
		fields = class1.getDeclaredFields();
		for (Field field : fields) {
			//System.out.println(field.getName());
		}
		
		
		
	}

}
