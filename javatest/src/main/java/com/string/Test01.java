/**
 * 
 */
package com.string;

import java.util.regex.Pattern;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test01  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-24 下午4:35:14  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-24 下午4:35:14  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Test01 {

	public static void test1(){
		
		Pattern pattern = Pattern.compile("^[A-Za-z0-9]{32}$");
		System.out.println(pattern.matcher("c1ed963e145846d3b7059wba67919b6a").find());
	}
	
	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		test1();
	}

}
