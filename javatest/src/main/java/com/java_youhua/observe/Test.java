/**
 * 
 */
package com.java_youhua.observe;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class Test {

	public static void test(){
		MyObservable observable = new MyObservable();
		MyObserver observer1 = new MyObserver();
		MyObserver observer2 = new MyObserver();
		observable.addObserver(observer1);
		observable.addObserver(observer2);
		for (int i = 0; i < 100; i++) {
			observable.setCount(observable.getCount() + 1);
		}
	}
	
	public static void main(String[] args) {
		test();
	}
	
}
