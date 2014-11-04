/**
 * 
 */
package com.java_youhua.jvm;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ProjectName：javatest  
 * @TypeName：TestHeapGC  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class TestHeapGC {

	/**
	 * @author：Administrator  
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
		byte[] b1 = new byte[1024*1024/2];
		byte[] b2 = new byte[1024*1024*8];
		b2 = null;
		b2 = new byte[1024*1024*8];
		System.gc();
	}
	
	
	public static void test2(){
		List<byte[]> list = new ArrayList<byte[]>();
		for (int i = 0; i < 10; i++) {
			byte[] b = new byte[1024*1024];
			list.add(b);
		}
		System.out.println("Max Memory:" + 
		Runtime.getRuntime().maxMemory()/1024/1024 + "M");
	}
	
}
