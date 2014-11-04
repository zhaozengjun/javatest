/**
 * 
 */
package com.thread.test001;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test01  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-3-18 下午5:15:52  
 * @creater：zhao_zengjun  
 * @updateDate：2014-3-18 下午5:15:52  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */


public class Test01 implements Runnable{
	
	int b = 100;
	
	public  void m1(){
		System.out.println(Thread.currentThread().getName());
		m2();
		b = 1000;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("m1 == " + b);
	}
	
	public synchronized void m2(){
		b = 2000;
		System.out.println("m2 == " + b);
	}
	
	public static void main(String[] args) {
		Test01 test01 = new Test01();
		Thread thread = new Thread(test01);
		thread.start();
		test01.m2();
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		m1();
	}

}
