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
public class Thread2 implements Runnable {
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Thread1.rs = true;
		System.out.println("改变值");
	}

}
