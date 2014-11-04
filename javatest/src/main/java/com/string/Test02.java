/**
 * 
 */
package com.string;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test02  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-7-1 下午4:34:30  
 * @creater：zhao_zengjun  
 * @updateDate：2014-7-1 下午4:34:30  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Test02 {

	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
//		test1();
		test2();
	}

	public static void test1(){
		String s1 = "a";
		String s2 = "b";
		String s3 = s1 + s2;
		String s4 = s1 + s2;
		String s5 = "a" + "b";
		String s6 = "a" + "b";
		System.out.println(s3 == s4);
		System.out.println(s5 == s6);
		
		String b = "abc";
		String c = b + b;
		String d = "abcabc";
		System.out.println(c == d);
	}
	
	public static void test2(){
		String string = "string " + "and " + "string " + "buffer";
		String string1 = "string ";
		String string2 = "and ";
		String string3 = "string ";
		String string4 = "buffer";
		String string5 = string1 + string2 + string3 + string4;
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("string ")
		.append("and ")
		.append("string ")
		.append("buffer ");
		System.out.println(stringBuffer);
	}
	
}
