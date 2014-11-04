/**
 * 
 */
package com.java_youhua.decorator;

/**  
 * @ProjectName：javatest  
 * @TypeName：BodyComponent  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class BodyComponent implements IPageCreator {

	@Override
	public String handlerContent() {
		return "main content of page";
	}

}
