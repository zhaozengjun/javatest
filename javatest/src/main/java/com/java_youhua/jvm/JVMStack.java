/**
 * 
 */
package com.java_youhua.jvm;

/**  
 * @ProjectName：javatest  
 * @TypeName：JVMStack  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class JVMStack {
	
	private static int count;
	
	public static void main(String[] args) {
//		testStack();
		test1();
	}
	
	
	public static void recursion() throws Exception{
		count++;
		String[] strings = new String[1024*1024];
		recursion();
	}
	
	public static void testStack(){
		try {
			recursion();
		} catch (Throwable e) {
			System.out.println("deep of stack is " + count);
			e.printStackTrace();
		}
	}
	
	
	public static void test1(){
		{
			byte[] b = new byte[6*1024*1024];
			b = null;
		}
		System.gc();
	}
	
	
	
}
