/**
 * 
 */
package com.thread.test004;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-19 下午4:14:22  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-19 下午4:14:22  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Test{
	
	public synchronized void test1(int i) throws InterruptedException{
		Thread.sleep(10000);
		System.out.println(Thread.currentThread().getName() + "-------" + i);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(Thread.currentThread().getName() + ",test1-------end");
	}
	
	
	public synchronized void test2(int i){
		System.out.println(Thread.currentThread().getName() + "-------" + i);
	}
	
	
	public static void main(String[] args) {
		final Test test = new Test();
		final Test test2 = new Test();
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
//				for (int i = 0; i < 10; i++) {
					try {
						test.test1(11);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//				}
			}
		}, "t1");
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						test2.test1(i);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}, "t2");
		
		thread.start();
		thread2.start();
		
	}

	
}
