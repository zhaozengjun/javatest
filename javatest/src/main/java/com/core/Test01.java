/**
 * 
 */
package com.core;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test01  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-3-28 上午9:46:33  
 * @creater：zhao_zengjun  
 * @updateDate：2014-3-28 上午9:46:33  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Test01 {
	
	public Test01(String name) {
		super();
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void swap(Test01 test01, Test01 test012){
//		Test01 test013 = test01;
//		test01 = test012;
//		test012 = test013;
		test01 = null;
	}
	
	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		Test01 a1 = new Test01("zzj");
		Test01 a2 = new Test01("milan");
		System.out.println(a1);
		System.out.println(a2);
		new Test01("").swap(a1, a2);
		System.out.println(a1);
		System.out.println(a2);
		
	}

}
