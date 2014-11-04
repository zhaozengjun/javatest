/**
 * 
 */
package com.file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**  
 * @ProjectName：javatest  
 * @TypeName：TextTest  
 * @TypeDesc：  
 * @author：zhao_zengjun  
 * @creatDate：2014-5-14 下午5:18:16  
 * @creater：zhao_zengjun  
 * @updateDate：2014-5-14 下午5:18:16  
 * @updater：zhao_zengjun  
 * @version   
 *   
 */
public class TextTest {

	/** 
	 * 解析普通文本文件  流式文件 如txt 
	 * @param path 
	 * @return 
	 */  
	public static String readTxt(String path){  
		StringBuilder content = new StringBuilder("");  
		try {  
			String code = resolveCode(path);  
			File file = new File(path);  
			InputStream is = new FileInputStream(file);  
			InputStreamReader isr = new InputStreamReader(is, code);  
			BufferedReader br = new BufferedReader(isr);  
			//          char[] buf = new char[1024];  
			//          int i = br.read(buf);  
			//          String s= new String(buf);  
			//          System.out.println(s);  
			String str = "";  
			while (null != (str = br.readLine())) {  
				content.append(str);  
			}  
			br.close();  
		} catch (Exception e) {  
			e.printStackTrace();  
			System.err.println("读取文件:" + path + "失败!");  
		}  
		return content.toString();  
	}  

	public static String resolveCode(String path) throws Exception {  
		//      String filePath = "D:/article.txt"; //[-76, -85, -71]  ANSI  
		//      String filePath = "D:/article111.txt";  //[-2, -1, 79] unicode big endian  
		//      String filePath = "D:/article222.txt";  //[-1, -2, 32]  unicode  
		//      String filePath = "D:/article333.txt";  //[-17, -69, -65] UTF-8  
		InputStream inputStream = new FileInputStream(path);    
		byte[] head = new byte[3];    
		inputStream.read(head);      
		String code = "GBK";  //或GBK  
		if (head[0] == -1 && head[1] == -2 )    
			code = "UTF-16";    
		else if (head[0] == -2 && head[1] == -1 )    
			code = "Unicode";    
		else if(head[0]==-17 && head[1]==-69 && head[2] ==-65)    
			code = "UTF-8";    

		inputStream.close();  

		System.out.println(code);   
		return code;  
	}  

	/**
	 * 判断文件的编码格式
	 * @param fileName :file
	 * @return 文件编码格式
	 * @throws Exception
	 */
	public static String codeString(File file) throws Exception{
		BufferedInputStream bin = new BufferedInputStream(
		new FileInputStream(file));
		int p = (bin.read() << 8) + bin.read();
		String code = null;
		
		switch (p) {
			case 0xefbb:
				code = "UTF-8";
				break;
			case 0xfffe:
				code = "Unicode";
				break;
			case 0xfeff:
				code = "UTF-16BE";
				break;
			default:
				code = "GBK";
		}
		bin.close();
		return code;
	}
	
	
	public static String codeString(String filePath) throws Exception{
		return codeString(new File(filePath));
	}
	
	
	/**
	 * @author：zhao_zengjun  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) throws Exception {  
//		String filePath = "E:\\works\\大屏数据\\无锡Neulion媒资统计结果.csv";  
		String filePath = "E:\\test1.txt";  
		
		OutputStream os = new FileOutputStream(filePath);
		os.write("我们".getBytes());
		os.flush();
		os.close();
//		//      String filePath = "D:/article333.txt";    
//		//      String filePath = "D:/article111.txt";    
		String content = codeString(filePath);  
		System.out.println(content);  
		
		InputStream is = new FileInputStream(filePath);
		int i = -1;
		while ((i = is.read()) > -1) {
			System.out.println(i);
		}
		
		InputStreamReader  in = new InputStreamReader(new FileInputStream(filePath));
		char[] chars = new char[2];
		int length = chars.length;
		while (in.read(chars) > -1) {
			System.out.println(new String(chars));
		}
		in.close();

	}  

}
