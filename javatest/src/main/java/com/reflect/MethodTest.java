/**
 * 
 */
package com.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**  
 * @ProjectName：javatest  
 * @TypeName：MethodTest  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-17 下午2:37:33  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-17 下午2:37:33  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class MethodTest {

	private void testMethod(String[] strings){
		for (String string : strings) {
			System.out.println(string);
		}
	}
	
	public void test(){
		try {
			Method method = this.getClass().getDeclaredMethod("testMethod", String[].class);
			Object strings = (Object)new String[]{"aaa", "sss", "ddd"};
			method.invoke(this, strings);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MethodTest().test();
	}
	
}
