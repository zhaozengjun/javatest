/**
 * 
 */
package com.thread.testWait;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-16 下午3:29:21  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-16 下午3:29:21  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Test {

	public static void main(String[] args) {
		MyWaitNotify myWaitNotify = new MyWaitNotify();
		myWaitNotify.doWait();
		myWaitNotify.doNotify();
	}
	
}
