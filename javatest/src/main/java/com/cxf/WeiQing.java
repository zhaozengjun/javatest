/**
 * 
 */
package com.cxf;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**  
 * @ProjectName：javatest  
 * @TypeName：WeiQing  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class WeiQing {
	
	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void test() throws Exception{
		String url = "http://61.191.252.182:8989/shzh/services/webService?wsdl";
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client = dcf.createClient(url);
        //sayHello 为接口中定义的方法名称   张三为传递的参数   返回一个Object数组
        Object[] objects=client.invoke("getAdCdBTree", "张三"); 
        //输出调用结果
        System.out.println(objects[0].toString());
	}
	
}
