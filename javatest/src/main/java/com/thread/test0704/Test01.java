/**
 * 
 */
package com.thread.test0704;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test01  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-7-4 下午4:49:16  
 * @creater：zhao_zengjun  
 * @updateDate：2014-7-4 下午4:49:16  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */

class XX{
	Lock lock = new ReentrantLock();
	public synchronized void test1(){
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("test1111****");
		}
	}

	public synchronized void test2(){
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("test2222****");
		}
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
		final XX xx = new XX();
		final XX xxx = new XX();
		new Thread(new Runnable() {

			@Override
			public void run() {
				xx.test1();
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				xxx.test2();
			}
		}).start();
	}

}
