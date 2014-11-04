/**
 * 
 */
package com.thread.test007;

/**  
 * @ProjectName：javatest  
 * @TypeName：ThreadTest  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-23 上午10:21:35  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-23 上午10:21:35  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class ThreadTest implements Runnable {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println("I am "+Thread.currentThread().getName());
			try {
//				Thread.sleep(1000); //暂停，每一秒输出一次
			}catch (Exception e) {
				return;
			}
		}
	}

}
