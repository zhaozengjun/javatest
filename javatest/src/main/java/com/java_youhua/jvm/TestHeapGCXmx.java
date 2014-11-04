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
public class TestHeapGCXmx {

	/**
	 * @author：Administrator  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		test2();
	}
	
	public static void test2(){
		List<byte[]> list = new ArrayList<byte[]>();
		for (int i = 0; i < 10; i++) {
			byte[] b = new byte[1024*1024];
			list.add(b);
			System.out.println((i + 1) + "M is allocated");
		}
		System.out.println("Max Memory:" + 
		Runtime.getRuntime().maxMemory()/1024/1024 + "M");
	}
	
}
