/**
 * 
 */
package com.thread;

/**  
 * @ProjectName：javatest  
 * @TypeName：MyThread  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-3-17 下午2:53:47  
 * @creater：zhao_zengjun  
 * @updateDate：2014-3-17 下午2:53:47  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */

class MyThread extends Thread{
	public int x = 0;

	public void run(){
		System.out.println(++x);
	}
}

class R implements Runnable{
	private int x = 0;
	public void run(){
		System.out.println(++x);
	}
}

public class Test {
	public static void main(String[] args) throws Exception{

//		for(int i=0;i<10;i++){
//			Thread t = new MyThread();
//			t.start();
//		}
//		Thread.sleep(10000);//让上面的线程运行完成
//		R r = new R();
//		for(int i=0;i<10;i++){
//			Thread t = new Thread(r);
//			t.start();
//		}
		
		
		do {
			System.out.println("循环。。。");
			Thread.sleep(100);
		} while (false);
		
		
		
	}
}