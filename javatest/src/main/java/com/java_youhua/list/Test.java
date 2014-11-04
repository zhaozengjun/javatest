/**
 * 
 */
package com.java_youhua.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class Test {

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
		List<Object> list = new ArrayList<Object>();
		List<Object> list2 = new LinkedList<Object>();
		int length = 1000000;
		Object object = new Object();
		long c = System.currentTimeMillis();
		for (int i = 0; i < length; i++) {
			list.add(object);
		}
		System.out.println(System.currentTimeMillis() - c);
		c = System.currentTimeMillis();
		for (int i = 0; i < length; i++) {
			list2.add(object);
		}
		System.out.println(System.currentTimeMillis() - c);
	}
	
	
	public static void test2(){
		List<Object> list = new ArrayList<Object>();
		List<Object> list2 = new LinkedList<Object>();
		int length = 100000;
		Object object = new Object();
		long c = System.currentTimeMillis();
		for (int i = 0; i < length; i++) {
			list.add(0, object);
		}
		System.out.println(System.currentTimeMillis() - c);
		c = System.currentTimeMillis();
		for (int i = 0; i < length; i++) {
			list2.add(0, object);
		}
		System.out.println(System.currentTimeMillis() - c);
	}
	
	
	public static void test3(){
		List<Object> list = new ArrayList<Object>();
		List<Object> list2 = new LinkedList<Object>();
		int length = 100000;
		Object object = new Object();
		long c = System.currentTimeMillis();
		for (int i = 0; i < length; i++) {
			list.add(object);
		}
		for (int i = 0; i < length; i++) {
			list2.add(object);
		}
		System.out.println(System.currentTimeMillis() - c);
	}
	
	
}
