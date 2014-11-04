/**
 * 
 */
package com.java_youhua.decorator;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class Test {

	public static void main(String[] args) {
		IPageCreator pageCreator = new HttpComponent(new Htmlcomponent(new BodyComponent()));
		System.out.println(pageCreator.handlerContent());;
	}
	
}
