/**
 * 
 */
package com.java_youhua.jvm;

/**  
 * @ProjectName：javatest  
 * @TypeName：TestGenGC  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class TestGenGC {

	/**
	 * @author：Administrator  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		test1();
	}
	
	
	public static void test1(){
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			String string = String.valueOf(i).intern();
		}
	}

}
