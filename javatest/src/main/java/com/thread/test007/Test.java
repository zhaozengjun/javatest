/**
 * 
 */
package com.thread.test007;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-23 上午10:19:33  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-23 上午10:19:33  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Test {
	public static void main(String[] args) {
		ThreadTest test = new ThreadTest();
		Thread t1 = new Thread(test, "testjoin");
		t1.start();
		try {
			
			t1.join();  //join()合并线程，子线程运行完之后，主线程才开始执行
		}catch (Exception e) {  }
		
		for(int i=0 ; i <10; i++){
			System.out.println("I am Main Thread");
			if (i == 5) {
				
			}
		}
	}
}
