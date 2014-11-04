/**
 * 
 */
package com.java_youhua.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;

import oracle.net.aso.s;

import util.KBUtil;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class Test {
	
	public static int length = 10;

	public static void main(String[] args) {
//		reflect();
		
		createSingleton();
		createLazySingleton();
		createLockLazySingleton();
		createInnerClassSingleton();
		
//		Set<Singleton> set = new HashSet<Singleton>();
//		set.add(Singleton.getInstance());
//		set.add(Singleton.getInstance());
//		set.add(Singleton.getInstance());
//		set.add(Singleton.getInstance());
//		KBUtil.showSet(set);
	}
	
	
	/**
	 * 未证实
	* @author：Administrator  
	* @Title: reflect
	* void
	* @throws
	 */
	public static void reflect(){
		try {
			Class class1  = Class.forName("com.java_youhua.singleton.InnerClassSingleton");
			InnerClassSingleton singleton = (InnerClassSingleton)class1.newInstance();
			Constructor[] constructors = class1.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				System.out.println(constructor.newInstance(null));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createSingleton(){
		final Set<Singleton> set = new CopyOnWriteArraySet<Singleton>();
//		final Set<Singleton> set = new HashSet<Singleton>();
		long c = System.currentTimeMillis();
		final CountDownLatch countDownLatch = new CountDownLatch(length);
		for (int i = 0; i < length; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for (int j = 0; j < 100000; j++) {
						set.add(Singleton.getInstance());
					}
					countDownLatch.countDown();
				}
			}).start();
//			System.out.println(i);
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("对象个数：" + set.size());
		KBUtil.showSet(set);
		System.out.println("耗时：" + (System.currentTimeMillis() - c));
	}
	
	
	public static void createLazySingleton(){
		final Set<LazySingleton> set = new CopyOnWriteArraySet<LazySingleton>();
//		final Set<LazySingleton> set = new HashSet<LazySingleton>();
		long c = System.currentTimeMillis();
		final CountDownLatch countDownLatch = new CountDownLatch(length);
		for (int i = 0; i < length; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for (int j = 0; j < 100000; j++) {
						set.add(LazySingleton.getInstance());
					}
					countDownLatch.countDown();
				}
			}).start();
//			System.out.println(i);
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("对象个数：" + set.size());
		KBUtil.showSet(set);
		System.out.println("耗时：" + (System.currentTimeMillis() - c));
	}
	
	
	public static void createLockLazySingleton(){
//		final Set<LockLazySingleton> set = new HashSet<LockLazySingleton>();
		final Set<LockLazySingleton> set = new CopyOnWriteArraySet<LockLazySingleton>();
		long c = System.currentTimeMillis();
		final CountDownLatch countDownLatch = new CountDownLatch(length);
		for (int i = 0; i < length; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for (int j = 0; j < 100000; j++) {
						set.add(LockLazySingleton.getInstance());
					}
					countDownLatch.countDown();
				}
			}).start();
//			System.out.println(i);
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("对象个数：" + set.size());
		KBUtil.showSet(set);
		System.out.println("耗时：" + (System.currentTimeMillis() - c));
	}
	

	public static void createInnerClassSingleton(){
//		final Set<LockLazySingleton> set = new HashSet<LockLazySingleton>();
		final Set<InnerClassSingleton> set = new CopyOnWriteArraySet<InnerClassSingleton>();
		long c = System.currentTimeMillis();
		final CountDownLatch countDownLatch = new CountDownLatch(length);
		for (int i = 0; i < length; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for (int j = 0; j < 100000; j++) {
						set.add(InnerClassSingleton.getInstance());
					}
					countDownLatch.countDown();
				}
			}).start();
//			System.out.println(i);
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("对象个数：" + set.size());
		KBUtil.showSet(set);
		System.out.println("耗时：" + (System.currentTimeMillis() - c));
	}
	
}
