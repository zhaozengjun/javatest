/**
 * 
 */
package com.thread.testWait;

/**  
 * @ProjectName：javatest  
 * @TypeName：MyWaitNotify  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-16 下午3:28:51  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-16 下午3:28:51  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class MyWaitNotify {
	MonitorObject myMonitorObject = new MonitorObject();

	public void doWait(){
		synchronized(myMonitorObject){
			try{
				System.out.println("begin doWait");
				myMonitorObject.wait();
				System.out.println("end doWait");
			} catch(InterruptedException e){}
		}
	}

	public void doNotify(){
		synchronized(myMonitorObject){
			System.out.println("doNotify");
			myMonitorObject.notify();
		}
	}
}
