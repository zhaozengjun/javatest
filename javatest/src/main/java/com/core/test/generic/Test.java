/**
 * 
 */
package com.core.test.generic;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-4-10 上午9:37:50  
 * @creater：zhao_zengjun  
 * @updateDate：2014-4-10 上午9:37:50  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Test {
	
	public static <T extends Comparable<T>> T min(T[] t){
		T t2 = null;
		if (t != null && t.length > 0) {
			t2 = t[0];
			for (int i = 0; i < t.length; i++) {
				if (t2.compareTo(t[i]) > 0) {
					t2 = t[i];
				}
			}
		}
		return t2;
	}
	
	public static String xx(){
		return "";
	}

	public static <T> T getMiddle(T[] t){
		return t[t.length/2];
	}
	
	
	
	
	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {

		String[] strings = {"ss", "11", "00", "22", "33"};
		System.out.println(getMiddle(strings));
		
		
		String string = min(strings);
		System.out.println(string);
		
	}
	
}

