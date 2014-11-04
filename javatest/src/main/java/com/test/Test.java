/**
 * 
 */
package com.test;

import java.math.BigDecimal;
import java.util.Arrays;

/**  
 * @ProjectName：CNTVKB  
 * @TypeName：Test  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2013-12-16 下午2:22:11  
 * @creater：zhao_zengjun  
 * @updateDate：2013-12-16 下午2:22:11  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */

public class Test {

	static class A{
		String name;
		public A(String name){
			this.name = name;
		}
	}
	
	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		
//		String string = "afda_%_%";
//		System.out.println(string.replace("%", "/%").replace("_", "/_"));
		
//		String string = "http://localhost:8080/CNTVKB/";
//		System.out.println(string.substring(0, string.indexOf("/", "http://".length()) + 1));
		
//		Object string = "111";
//		System.out.println((BigDecimal)string);
		
		/*StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("success");
		if (stringBuffer.toString().equals("success")) {
			System.out.println("dddddddd");
		}else{
			System.out.println("vvvvvvvvvvvvvvvvvv");
		}
		*/
		
		String string = "abcd";
		String[] strings = {"a", "b", "c", "d", "e"};
		System.out.println(Arrays.toString(strings));
		for (String string2 : strings) {
			string2 = "aaa";
		}
		System.out.println(Arrays.toString(strings));
		for (int i = 0; i < strings.length; i++) {
			String string2 = strings[i];
			string2 = "bbb";
		}
		System.out.println(Arrays.toString(strings));
		Integer[] integers = {new Integer(1), new Integer(2), new Integer(2)};
		System.out.println(Arrays.toString(integers));
		for (Integer integer : integers) {
			integer = new Integer(111);
		}
		System.out.println(Arrays.toString(integers));
		for (int i = 0; i < integers.length; i++) {
			integers[i] = new Integer(222);
		}
		System.out.println(Arrays.toString(integers));
		
		Arrays.copyOf(strings, strings.length);
		
		
		
		
	}

}
