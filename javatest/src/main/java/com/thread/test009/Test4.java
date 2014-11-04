/**
 * 
 */
package com.thread.test009;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test4  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-25 下午5:28:14  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-25 下午5:28:14  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Test4 {
	private int j;

	private synchronized void add(){
		j++;
		System.out.println(Thread.currentThread().getName() + "加1");
	}

	private synchronized void minus(){
		j--;
		System.out.println(Thread.currentThread().getName() + "减1");
	}

	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		final Test4 test4 = new Test4();
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					test4.add();
				}
			}, "t1").start();

			new Thread(new Runnable() {

				@Override
				public void run() {
					test4.add();
				}
			}, "t2").start();

			new Thread(new Runnable() {

				@Override
				public void run() {
					test4.minus();
				}
			}, "t3").start();

			new Thread(new Runnable() {

				@Override
				public void run() {
					test4.minus();
				}
			}, "t4").start();
		}
	}

}
