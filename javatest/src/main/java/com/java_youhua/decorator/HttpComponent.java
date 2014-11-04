/**
 * 
 */
package com.java_youhua.decorator;

/**  
 * @ProjectName：javatest  
 * @TypeName：HttpComponent  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class HttpComponent extends PageDecorator {

	/**
	 * @param pageCreator
	 */
	public HttpComponent(IPageCreator pageCreator) {
		super(pageCreator);
	}

	@Override
	public String handlerContent() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer
		.append("http head\n")
		.append(pageCreator.handlerContent());
		return stringBuffer.toString();
	}

}
