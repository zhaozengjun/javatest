/**
 * 
 */
package com.java_youhua.string;

import java.util.StringTokenizer;

import javax.jws.Oneway;

/**  
 * @ProjectName：javatest  
 * @TypeName：Split  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class Split {
	
	public static int length = 50000;
	
	public static int appendLength = 10000;

	/**
	 * @author：Administrator  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
//		split();
//		tokenizer();
//		substring();
//		append();
//		testAppend2();
//		testAppend3();
		testAppend456();
	}
	
	
	public static void split(){
		long c = System.currentTimeMillis();
		String orgStr = getOrgStr();
		for (int i = 0; i < length; i++) {
			orgStr.split(";");
		}
		System.out.println(System.currentTimeMillis() - c);
	}
	
	
	public static void tokenizer(){
		long c = System.currentTimeMillis();
		String orgStr = getOrgStr();
		StringTokenizer tokenizer = new StringTokenizer(orgStr, ";");
		for (int i = 0; i < length; i++) {
			while (tokenizer.hasMoreTokens()) {
				tokenizer.nextToken();
			}
			tokenizer = new StringTokenizer(orgStr, ";");
		}
		System.out.println(System.currentTimeMillis() - c);
	}
	
	
	public static void substring(){
		long c = System.currentTimeMillis();
		String orgStr = getOrgStr();
		for (int i = 0; i < length; i++) {
			while (true) {
				int index = orgStr.indexOf(";");
				if (index < 0) {
					break;
				}
				String tmp = orgStr.substring(0, index);
//				System.out.println(tmp);
				orgStr = orgStr.substring(index + 1);
			}
		}
		System.out.println(System.currentTimeMillis() - c);
	}
	
	
	public static void append(){
		String string = "a" + "b";
		String string2 = "ab";
		System.out.println(string == string2);
	}
	
	
	public static void append2(){
		String string = "String";
		String string1 = "and";
		String string2 = "String";
		String string3 = "append";
		String result = string + string1 + string2 + string3;
	}
	
	
	public static void append3(){
		String string = "String";
		String string1 = "and";
		String string2 = "String";
		String string3 = "append";
		String result = new StringBuffer()
						.append(string)
						.append(string1)
						.append(string2)
						.append(string3)
						.toString();
	}
	
	
	public static void append4(){
		String string = "";
		for (int i = 0; i < appendLength; i++) {
			string += i;
		}
	}
	
	
	public static void append5(){
		String string = "";
		for (int i = 0; i < appendLength; i++) {
			string = string.concat(String.valueOf(i));
		}
	}
	
	
	public static void append6(){
		StringBuffer string = new StringBuffer();
		for (int i = 0; i < appendLength; i++) {
			string.append(i);
		}
	}
	
	
	public static void testAppend456(){
		int l = 10;
		long c = System.currentTimeMillis();
		for (int i = 0; i < l; i++) {
			append4();
		}
		System.out.println(System.currentTimeMillis() - c);
		c = System.currentTimeMillis();
		for (int i = 0; i < l; i++) {
			append5();
		}
		System.out.println(System.currentTimeMillis() - c);
		c = System.currentTimeMillis();
		for (int i = 0; i < l; i++) {
			append6();
		}
		System.out.println(System.currentTimeMillis() - c);
	}
	
	
	
	public static void testAppend2(){
		long c = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			append2();
		}
		System.out.println(System.currentTimeMillis() - c);
	}

	public static void testAppend3(){
		long c = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			append3();
		}
		System.out.println(System.currentTimeMillis() - c);
	}
	
	
	public static String getOrgStr(){
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < 1000; i++) {
			sBuffer.append(i).append(";");
		}
		return sBuffer.toString();
	}
	

}
