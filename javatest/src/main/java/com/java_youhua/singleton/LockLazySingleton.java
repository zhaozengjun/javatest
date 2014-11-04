/**
 * 
 */
package com.java_youhua.singleton;

import java.util.concurrent.locks.ReentrantLock;

/**  
 * @ProjectName：javatest  
 * @TypeName：LazySingleton  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class LockLazySingleton {

	private static LockLazySingleton instance = null;
	
	private LockLazySingleton(){};
	
	private static ReentrantLock lock = new ReentrantLock();
	
	public static synchronized LockLazySingleton getInstance(){
//		try {
//			Thread.sleep(1);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		if (instance == null) {
			lock.lock();
			if (instance == null) {
				instance = new LockLazySingleton();
			}
			lock.unlock();
		}
		return instance;
	}
	
}
