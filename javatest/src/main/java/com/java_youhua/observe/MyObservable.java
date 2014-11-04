/**
 * 
 */
package com.java_youhua.observe;

import java.util.Observable;

/**  
 * @ProjectName：javatest  
 * @TypeName：MyObservable  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class MyObservable extends Observable {

	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		if (this.count > 50) {
			setChanged();
			this.notifyObservers(this.count);
		}
		this.count = count;
	}
	
	
	
}
