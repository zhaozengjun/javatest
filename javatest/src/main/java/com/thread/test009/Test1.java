/**
 * 
 */
package com.thread.test009;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test1  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-25 上午10:41:39  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-25 上午10:41:39  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Test1 {

	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		final Show show = new Show();
		final Show show1 = new Show();
		final int num = 0;
		new Thread(new Runnable() {
			
			/* (non-Javadoc)
			 * @see java.lang.Runnable#run()
			 */
			@Override
			public void run() {
				show.xxx(num);
			}
		}, "t1").start();
		
		
		new Thread(new Runnable() {
			
			/* (non-Javadoc)
			 * @see java.lang.Runnable#run()
			 */
			@Override
			public void run() {
				show1.xxxx(num);
			}
		}, "t2").start();
		
	}
	
	

}


class Show {
	
	public int num1;
	
	public  void xxx(int num2){
		int i = 0;
		for (i = 0; i < 100; i++) {
//			System.out.println(Thread.currentThread().getName() + "----" + i);
			num1++;
			num2++;
		}
		System.out.println(Thread.currentThread().getName() + "----" + num2);
	}
	
	public  void xxxx(int num2){
		int i = 0;
		for (i = 0; i < 100; i++) {
//			System.out.println(Thread.currentThread().getName() + "----" + i);
			num1++;
			num2++;
		}
		System.out.println(Thread.currentThread().getName() + "----" + num2);
	}
	
}
