/**
 * 
 */
package com.thread.test002;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test01  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-3-21 下午3:55:07  
 * @creater：zhao_zengjun  
 * @updateDate：2014-3-21 下午3:55:07  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */


class Test001 implements Runnable{
	public synchronized void m1(){
		try {
			System.out.println("执行test001的m1方法");
			Thread.sleep(3000);
			System.out.println("运行m1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public synchronized void m12(){
		try {
			System.out.println("执行test001的m12方法");
			Thread.sleep(1000);
			System.out.println("运行m12");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public  void run() {
		m1();
	}
}


class Test002 implements Runnable{
	public synchronized void m2(){
		try {
//			Thread.sleep(1000);
			System.out.println("运行m2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			m2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



public class Test01 {
	public static void main(String[] args) {
		try {
			Test001 test001 = new Test001();
			Test002 test002 = new Test002();
			new Thread(test001).start();
			Thread.sleep(10);
			test001.m12();
			//test001.m1();
//			Thread.sleep(1);
//			test002.m2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
