/**
 * 
 */
package com.thread.test009;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test2  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-25 下午2:43:16  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-25 下午2:43:16  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Test2 {

	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		final Bussiness bussiness = new Bussiness();
		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				for (int i = 0; i < 50; i++) {
//					bussiness.sub();
//				}
//			}
//		}).start();
//		
//		for (int i = 0; i < 50; i++) {
//			bussiness.main();
//		}
		
		bussiness.xxx();
		
		
	}

}

class Bussiness{
	private boolean isSub = true;
	public  void sub(){
		while (!isSub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 10; i++) {
			System.out.println("子线程循环---" + (i+1));
		}
		isSub = false;
		this.notify();
	}
	
	public  void main(){
		while (isSub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 100; i++) {
			System.out.println("主线程循环---" + (i+1));
		}
		isSub = true;
		this.notify();
	}
	
	public synchronized void xxx(){
		for (int i = 0; i < 50; i++) {
			sub();
			main();
		}
	}
}
