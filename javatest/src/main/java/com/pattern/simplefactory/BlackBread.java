/**
 * 
 */
package com.pattern.simplefactory;

/**  
 * @ProjectName：javatest  
 * @TypeName：BlackBread  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class BlackBread implements IBreadMaker {

	@Override
	public void creatBread() {
		System.out.println("烤出黑面包");
	}


}
