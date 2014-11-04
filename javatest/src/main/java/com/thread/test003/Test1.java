/**
 * 
 */
package com.thread.test003;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test1  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-16 下午2:11:16  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-16 下午2:11:16  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Test1 implements Runnable {

	public int count = 0;
	
	public void add(){
		this.count = this.count + 1;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		add();
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		Test1 test1 = new Test1();
		Thread thread = new Thread(test1);
		Thread thread1 = new Thread(test1);
		Thread thread2 = new Thread(test1);
		Thread thread3 = new Thread(test1);
		Thread thread4 = new Thread(test1);
		Thread thread5 = new Thread(test1);
		Thread thread6 = new Thread(test1);
		thread.start();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		Thread.sleep(100);
		System.out.println("test1.count = " + test1.count);
		
		
	}
	
}
