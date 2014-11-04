/**
 * 
 */
package com.cxf;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

/**  
 * @ProjectName：javatest  
 * @TypeName：WSClient  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class WSClient {

	public static void main(String[] args) {
		testWS();
	}
	
	public static void testWS(){
		QName qName = new QName("http://helloworld.cxf.demo/", "Helloworld");
		QName qNamePort = new QName("http://helloworld.cxf.demo/", "HelloworldPort");
		Service service = Service.create(qName);
		String address = "http://localhost:8080/HelloWorld";
		service.addPort(qNamePort, SOAPBinding.SOAP11HTTP_BINDING, address);
		
	}
	
}
