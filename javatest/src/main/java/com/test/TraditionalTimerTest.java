/**
 * 
 */
package com.test;

import java.util.Timer;
import java.util.TimerTask;

/**  
 * @ProjectName：javatest  
 * @TypeName：TraditionalTimerTest  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-2-10 上午11:21:47  
 * @creater：zhao_zengjun  
 * @updateDate：2014-2-10 上午11:21:47  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class TraditionalTimerTest {

	public int index = 10;
	
	public void t1(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("t1:" +(index++));
				}
				
			}
		}){}.start();
	}
	
	public void t2(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("t2:" +(index++));
				}
				
			}
		}){}.start();
	}
	
	public void show(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					print("zzj");
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					print("zhaozengjun");
				}
			}
		}).start();
	}
	
	
	public void print(String name){
		for (int i = 0; i < name.length(); i++) {
			System.out.print(name.charAt(i));
		}
		System.out.println();
	}
	
	
	
	
	
	
	
	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {

		new TraditionalTimerTest().show();
		
	}

}
