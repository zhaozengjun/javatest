/**
 * 
 */
package com.thread.test001;

/**  
 * @ProjectName：javatest  
 * @TypeName：Thread1  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-3-18 下午2:26:03  
 * @creater：zhao_zengjun  
 * @updateDate：2014-3-18 下午2:26:03  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Thread1 implements Runnable {
	public static boolean rs = false;
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			System.out.println(rs);
			Thread.sleep(1000);
			System.out.println(rs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
