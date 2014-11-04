/**
 * 
 */
package com.thread;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test20140311  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-3-11 上午10:55:58  
 * @creater：zhao_zengjun  
 * @updateDate：2014-3-11 上午10:55:58  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */

public class Test20140311 {
	
	

	class A{
		public void banjia(int j){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("搬家------" + j);
		}
	}
	
	
	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		final Test20140311 test20140311 = new Test20140311();
		final A a = test20140311.new A();
		for (int i = 0; i < 100; i++) {
			final int j = i;
			new Thread(
					new Runnable() {
						@Override
						public void run() {
							System.out.println(j);
							a.banjia(j);
						}
					}
					).start();
		}
		
	}

}
