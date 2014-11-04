/**
 * 
 */
package com.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test01  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-7-1 上午10:22:43  
 * @creater：zhao_zengjun  
 * @updateDate：2014-7-1 上午10:22:43  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Test01 {

	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		final Business business = new Business();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					business.test2(i);
				}
			}
		}).start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					business.test3(i);
				}
			}
		}).start();
		
		for (int i = 0; i < 10; i++) {
			business.test1(i);
		}

	}

}
