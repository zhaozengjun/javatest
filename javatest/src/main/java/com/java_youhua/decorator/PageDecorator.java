/**
 * 
 */
package com.java_youhua.decorator;

/**  
 * @ProjectName：javatest  
 * @TypeName：PageDecorator  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public abstract class PageDecorator implements IPageCreator {

	IPageCreator pageCreator;
	
	public PageDecorator(IPageCreator pageCreator) {
		this.pageCreator = pageCreator;
	}
	
}
