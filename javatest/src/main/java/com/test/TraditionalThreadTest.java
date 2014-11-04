/**
 * 
 */
package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**  
 * @ProjectName：javatest  
 * @TypeName：TraditionalThreadTest  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-2-10 下午2:50:44  
 * @creater：zhao_zengjun  
 * @updateDate：2014-2-10 下午2:50:44  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class TraditionalThreadTest {

	public static int data = 0;
	public static Map<Thread, Integer> threadMap = new HashMap<Thread, Integer>();
	
	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {

		for (int i = 0; i < 2; i++) {

			new Thread(new Runnable() {
				
				@Override
				public void run() {
					int data1 = new Random().nextInt();
					System.out.println(Thread.currentThread().getName() + ",put data:" + data1);
					threadMap.put(Thread.currentThread(), data1);
					new A().get();
					new B().get();
				}
			}).start();
			
		}
		
	}
	
	
	static class A{
		public void get(){
			int data2 = threadMap.get(Thread.currentThread());
			System.out.println("A from " + Thread.currentThread().getName() + ":" + data2);
		}
	}
	
	
	static class B{
		public void get(){
			int data2 = threadMap.get(Thread.currentThread());
			System.out.println("B from " + Thread.currentThread().getName() + ":" + data2);
		}
	}
	
	


}
