/**
 * 
 */
package com.thread.test009;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test03  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-25 下午4:38:08  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-25 下午4:38:08  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Test3 {
	
	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		final Map<Test301, Integer> map = new Hashtable<Test301, Integer>();
		final Map<Test301, Integer> map1 = new HashMap<Test301, Integer>();
		final Set<Test301> set = new HashSet<Test301>();
		for (int i = 0; i < 2000; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					Test301 test3 = Test301.getInstance();
//					map.put(test3, 1);
//					map1.put(test3, 1);
					set.add(test3);
				}
			}).start();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (Test301 test301 : map.keySet()) {
			System.out.println(test301);
		}
		System.out.println("*****************");
		for (Test301 test301 : map1.keySet()) {
			System.out.println(test301);
		}
		System.out.println("*****************");
		for (Test301 test301 : set) {
			System.out.println(test301);
		}
	}

}



class Test301{
	private Test301(){}

	private static Test301 instance;

	public static synchronized Test301 getInstance(){
		if (instance == null) {
			instance = new Test301();
		}
		return instance;
	}

}


