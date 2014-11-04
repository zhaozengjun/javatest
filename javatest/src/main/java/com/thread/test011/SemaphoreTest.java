/**
 * 
 */
package com.thread.test011;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**  
 * @ProjectName：javatest  
 * @TypeName：SemaphoreTest  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-7-1 下午12:15:51  
 * @creater：zhao_zengjun  
 * @updateDate：2014-7-1 下午12:15:51  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class SemaphoreTest {

	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(3);
		
		
		for (int i = 0; i < 10; i++) {
			final int index = i;
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						semaphore.acquire();
						System.out.println(index + ",当前并发数：" + 
						(3 - semaphore.availablePermits()));
						Thread.sleep(new Random().nextInt(10000));
						System.out.println(index + ",即将释放");
						semaphore.release();
						System.out.println(index + ",已经释放");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			service.execute(runnable);
		}
		service.shutdown();
	}

}
