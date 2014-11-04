/**
 * 
 */
package com.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**  
 * @ProjectName：javatest  
 * @TypeName：Business  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-7-1 上午10:49:57  
 * @creater：zhao_zengjun  
 * @updateDate：2014-7-1 上午10:49:57  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class Business {
	final Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	Condition condition2 = lock.newCondition();
	Condition condition3 = lock.newCondition();
	boolean isSub1 = true;
	boolean isSub2 = false;
	boolean isSub3 = false;

	public  void test1(int index){
		try {
			lock.lock();
			while (!isSub1) {
				condition.await();
			}
			for (int i = 0; i < 5; i++) {
				System.out.println(index + ",T1 -- " + i);
			}
			isSub2 = true;
			isSub1 = false;
			isSub3 = false;
			condition2.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		
	}
	
	public  void test2(int index){
		try {
			lock.lock();
			while (!isSub2) {
				condition2.await();
			}
			for (int i = 0; i < 5; i++) {
				System.out.println(index + ",T2 -- " + i);
			}
			isSub3 = true;
			isSub1 = false;
			isSub2 = false;
			condition3.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		
	}
	
	public void test3(int index){
		try {
			lock.lock();
			while (!isSub3) {
				condition3.await();
			}
			for (int i = 0; i < 5; i++) {
				System.out.println(index + ",T3 -- " + i);
			}
			isSub1 = true;
			isSub2 = false;
			isSub3 = false;
			condition.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		
	}


}
