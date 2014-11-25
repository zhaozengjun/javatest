/**
 * 
 */
package com.A.string;

/**  
 * @ProjectName：javatest  
 * @TypeName：String  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class StringTest {
	public static void main(String[] args) {
		test2();
	}
	
	private static String getA() {return "a";}
	
	static void test2(){
		String a = "a";
		final String c = "a";

		String b = a + "b";
		String d = c + "b";
		String e = getA() + "b";

		String compare = "ab";
		System.out.println(b == compare);
		System.out.println(d == compare);
		System.out.println(e == compare);
		
	}
}
