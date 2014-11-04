/**
 * 
 */
package com.thread.test011;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;

import cn.itcast.heima2.User;

/**  
 * @ProjectName：javatest  
 * @TypeName：CountdownTest  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-7-1 下午2:04:50  
 * @creater：zhao_zengjun  
 * @updateDate：2014-7-1 下午2:04:50  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class CountdownTest {

	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		final CountDownLatch cnOrder = new CountDownLatch(1);
		final CountDownLatch cnUser = new CountDownLatch(5);
		for (int i = 0; i < 5; i++) {
			final int index = i;
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println(Thread.currentThread().getName() + " 正在等待");
						cnOrder.await();
						System.out.println(Thread.currentThread().getName() + " 开始执行");
						Thread.sleep(new Random().nextInt(10000));
						cnUser.countDown();
						System.out.println(Thread.currentThread().getName() + " 执行完毕");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}, "线程" +index).start();
		}

		try {
			Thread.sleep(1000);
			cnOrder.countDown();
			System.out.println("等待所有线程执行完成。。。。");
			cnUser.await();
			System.out.println("所有线程执行完成，结束*********");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}
