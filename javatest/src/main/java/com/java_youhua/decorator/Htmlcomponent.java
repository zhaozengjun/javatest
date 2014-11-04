/**
 * 
 */
package com.java_youhua.decorator;

/**  
 * @ProjectName：javatest  
 * @TypeName：Htmlcomponent  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class Htmlcomponent extends PageDecorator {

	/**
	 * @param pageCreator
	 */
	public Htmlcomponent(IPageCreator pageCreator) {
		super(pageCreator);
	}

	@Override
	public String handlerContent() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer
		.append("<html>\n")
		.append("<body>\n")
		.append(pageCreator.handlerContent())
		.append("</body>\n")
		.append("</html>\n");
		return stringBuffer.toString();
	}

}
