/**
 * 
 */
package com.pattern.simplefactory;

/**  
 * @ProjectName：javatest  
 * @TypeName：WhiteBread  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class WhiteBread implements IBreadMaker {

	@Override
	public void creatBread() {
		System.out.println("烤出白面包");
	}

}
