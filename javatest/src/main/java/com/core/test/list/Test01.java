/**
 * 
 */
package com.core.test.list;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.IntHolder;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test01  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-4-2 下午4:01:32  
 * @creater：zhao_zengjun  
 * @updateDate：2014-4-2 下午4:01:32  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */


enum Size {
	SMALL("s"),
	LARGE("l");
	private String name;
	
	private Size(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
}


public class Test01 {

	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		
		/*ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		System.out.println(list.size());
		list.trimToSize();
		list.add("ddd");
		System.out.println(list.size());
		
		
		Integer integer = new Integer(10);
		System.out.println(integer);
		triple(integer);
		System.out.println(integer);
		
		IntHolder intHolder = new IntHolder(10);
		System.out.println(intHolder.value);
		triple(intHolder);
		System.out.println(intHolder.value);
		*/
		
		
		System.out.println(Size.SMALL.toString());
		
		System.out.println(Enum.valueOf(Size.class, "SMALL"));
		
		
		
	}

	
	public static void triple(Integer x){
		x = new Integer(100);
	}
	
	public static void triple(IntHolder x) {
		x.value = x.value * 3;
	}
	
	
}
