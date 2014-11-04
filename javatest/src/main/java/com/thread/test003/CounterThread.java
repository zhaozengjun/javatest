/**
 * 
 */
package com.thread.test003;

/**  
 * @ProjectName：javatest  
 * @TypeName：CounterThread  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-16 下午2:53:52  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-16 下午2:53:52  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class CounterThread implements Runnable {
	protected Counter counter = null;

	public CounterThread(Counter counter){
		this.counter = counter;
	}
	public void run() {
		for(int i=0; i<10; i++){
			counter.add(i);
		}
	}
}
