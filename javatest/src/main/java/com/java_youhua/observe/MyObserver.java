/**
 * 
 */
package com.java_youhua.observe;

import java.util.Observable;
import java.util.Observer;

/**  
 * @ProjectName：javatest  
 * @TypeName：MyObserver  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class MyObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(arg);
		System.out.println(this + ",超过警戒线！！！");
	}

}
