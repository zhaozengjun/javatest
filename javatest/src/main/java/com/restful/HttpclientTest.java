/**
 * 
 */
package com.restful;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import util.Sql;

/**  
 * @ProjectName：javatest  
 * @TypeName：HttpclientTest  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-6-10 下午4:37:08  
 * @creater：zhao_zengjun  
 * @updateDate：2014-6-10 下午4:37:08  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class HttpclientTest {

	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		test2();
	}
	
	
	
	
	
	public static void test2(){
		String sqlStrBuf  = Sql.getSql("xxxx");
		System.out.println(sqlStrBuf.length());
		sqlStrBuf = "xxx";
		//创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        //HttpClient
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        RequestConfig requestConfig = RequestConfig.custom()
//        		.setSocketTimeout(2000)
//        		.setConnectTimeout(2000)
        		.build();
        HttpPost httpPost = new HttpPost("http://10.78.68.12:8080/pdi/api/addRecommend");
    	httpPost.setConfig(requestConfig);
    	//设置参数
    	List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
    	formparams.add(new BasicNameValuePair("request", sqlStrBuf));
    	UrlEncodedFormEntity requestEntity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
    	httpPost.setEntity(requestEntity);  
    	//执行post请求
    	//获取响应消息实体
        try {
        	long c = System.currentTimeMillis();
            //执行get请求
            HttpResponse httpResponse = closeableHttpClient.execute(httpPost);
            System.out.println("**********耗时 = " + (System.currentTimeMillis() - c)/1000D);
            //获取响应消息实体
            HttpEntity entity = httpResponse.getEntity();
            //响应状态  
            System.out.println("status:" + httpResponse.getStatusLine().getStatusCode());  
            //判断响应实体是否为空
            if (entity != null) {
            	String string = EntityUtils.toString(entity);
                System.out.println("response content:" + string);
            }
        } catch (ConnectTimeoutException e) {
            System.out.println("***********ConnectTimeoutException***************");
        } catch (SocketTimeoutException e) {
        	e.printStackTrace();
            System.out.println("***********SocketTimeoutException***************");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {           //关闭流并释放资源
                closeableHttpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	
	
	
	
	
	public static void test1(){
		//创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        //HttpClient
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        RequestConfig requestConfig = RequestConfig.custom()
        		.setSocketTimeout(1000)
        		.setConnectTimeout(1000)
        		.build();
        HttpGet httpGet = new HttpGet("http://10.78.68.12:8080/pdi/api/addRecommend?request=22222222222");
//        HttpGet httpGet = new HttpGet("http://10.64.4.149:8080/pdi/api/addRecommend?request=22222222222");
//        HttpGet httpGet = new HttpGet("http://localhost:8080/web/r");
//        HttpGet httpGet = new HttpGet("http://www.163.com");
        httpGet.setConfig(requestConfig);
        try {
        	long c = System.currentTimeMillis();
            //执行get请求
            HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
            System.out.println("**********耗时 = " + (System.currentTimeMillis() - c)/1000D);
            //获取响应消息实体
            HttpEntity entity = httpResponse.getEntity();
            //响应状态  
            System.out.println("status:" + httpResponse.getStatusLine().getStatusCode());  
            //判断响应实体是否为空
            if (entity != null) {
            	String string = EntityUtils.toString(entity);
                System.out.println("response content:" + string);
            }
        } catch (ConnectTimeoutException e) {
            System.out.println("***********ConnectTimeoutException***************");
        } catch (SocketTimeoutException e) {
        	e.printStackTrace();
            System.out.println("***********SocketTimeoutException***************");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {           //关闭流并释放资源
                closeableHttpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	
	
}
