/**
 * 
 */
package com.thread.test010;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test02  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-26 下午3:08:23  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-26 下午3:08:23  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Test02 {

	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
//		ExecutorService service = Executors.newFixedThreadPool(3);
//		ExecutorService service = Executors.newCachedThreadPool();
		ExecutorService service = Executors.newSingleThreadExecutor();
//		for (int i = 0; i < 10; i++) {
//			final int index = i;
			service.submit(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 10; i++) {
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread() + ", 任务 " + 1 + ", 循环 " + i);
					}
				}
			});
//			service.execute(new Runnable() {
//				@Override
//				public void run() {
//					for (int i = 0; i < 10; i++) {
//						try {
//							Thread.sleep(10);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//						System.out.println(Thread.currentThread() + ", 任务 " + index + ", 循环 " + i);
//					}
//				}
//			});
//		}
		
//		service.shutdown();
		System.out.println("结束");
	}

}
