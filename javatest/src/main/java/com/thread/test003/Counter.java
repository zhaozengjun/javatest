/**
 * 
 */
package com.thread.test003;

/**  
 * @ProjectName：javatest  
 * @TypeName：Counter  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-16 下午2:53:25  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-16 下午2:53:25  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Counter {
	long count = 0;

	public synchronized void add(long value){
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.count += value;
		System.out.println(Thread.currentThread().getName() + "==== "+count);
	}
}
