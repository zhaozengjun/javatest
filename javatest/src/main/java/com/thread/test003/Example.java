/**
 * 
 */
package com.thread.test003;

/**  
 * @ProjectName：javatest  
 * @TypeName：Example  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-16 下午2:54:13  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-16 下午2:54:13  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Example {

	/**
	 * @throws InterruptedException 
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		Counter counter = new Counter();
		Thread  threadA = new Thread(new CounterThread(counter));
		Thread  threadB = new Thread(new CounterThread(counter));
		threadA.start();
		threadB.start();
	}

}
