/**
 * 
 */
package com.test;

/**  
 * @ProjectName：javatest  
 * @TypeName：TreadTest  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2013-12-24 下午5:00:32  
 * @creater：zhao_zengjun  
 * @updateDate：2013-12-24 下午5:00:32  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class ThreadTest {

	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName());
				}
			}
		});
		thread.start();
		
		
		
		
		
		
		Thread thread2 = new Thread(){
			public void run(){
				while (true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("2:" + Thread.currentThread().getName());
				}
				
			}
		};
		thread2.start();
		
		
		
		Thread thread3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("方法:" + Thread.currentThread().getName());
				}
			}
		}){
			public void run(){
				while (true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("子类:" + Thread.currentThread().getName());
				}
			}
		};
		
		thread3.start();
	}

}
