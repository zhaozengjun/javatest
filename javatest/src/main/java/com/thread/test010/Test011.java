/**
 * 
 */
package com.thread.test010;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test011  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-26 下午5:11:44  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-26 下午5:11:44  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Test011 {
	
	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(service);
		for (int i = 0; i < 20; i++) {
			final int index = i;
			completionService.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					Thread.sleep(100);
					return index;
				}
			});
		}
		for (int i = 0; i < 20; i++) {
			try {
				System.out.println(completionService.take().get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
