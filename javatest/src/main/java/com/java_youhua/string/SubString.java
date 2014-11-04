/**
 * 
 */
package com.java_youhua.string;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class SubString {
	
	static int length = 1000000;

	public static void test(){
		String a = "a";
		String b = "a";
		String c = new String("a");
		System.out.println(a == b);
		System.out.println(a == c);
		System.out.println(a == c.intern());
		System.out.println(a.substring(0, 1));
	}
	
	public static void main(String[] args) {
//		test();
		bigStrTest();
	}
	
	
	public static void bigStrTest(){
		List<String> list = new ArrayList<String>();
		
		for (int i = 0; i < 1000; i++) {
			BigStr bigStr = new BigStr();
//			ImprovedBigStr bigStr = new ImprovedBigStr();
			list.add(new String(bigStr.getSubString(1, 5)));
			list.add(bigStr.getSubString(1, 5));
		}
	}
	
	
	static class BigStr{
		private String string = new String(new char[length]);
		
		public String getSubString(int begin, int end){
			return string.substring(begin, end);
		}
		
	}
	
	
	static class ImprovedBigStr{
		private String string = new String(new char[length]);
		
		public String getSubString(int begin, int end){
			return new String(string.substring(begin, end));
		}
		
	}
}
