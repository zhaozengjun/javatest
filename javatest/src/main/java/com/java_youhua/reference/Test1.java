/**
 * 
 */
package com.java_youhua.reference;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test1  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class Test1 {
	
	
	public static void main(String[] args) {
		test1();
	}
	
	
	public static void test1(){
		String string = new String("aaa");
		String string2 = string;
		System.out.println(string == string2);
	}
	
}
