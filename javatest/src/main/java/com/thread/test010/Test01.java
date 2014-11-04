/**
 * 
 */
package com.thread.test010;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test01  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-26 上午11:21:04  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-26 上午11:21:04  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */

class SimpleThreadFactory implements ThreadFactory{
	String name;
	public SimpleThreadFactory(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
	 */
	@Override
	public Thread newThread(Runnable r) {
		return new Thread(r, name);
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
		ExecutorService service = Executors.newFixedThreadPool(3);
//		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			service.execute(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 10; i++) {
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread() + ", 任务 " + index + ", 循环 " + i);
					}
				}
			});
		}
		
//		service.shutdown();
	}

}
