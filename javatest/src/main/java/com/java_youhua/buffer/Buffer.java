/**
 * 
 */
package com.java_youhua.buffer;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/**  
 * @ProjectName：javatest  
 * @TypeName：Buffer  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class Buffer {
	
	private static final int length = 1000000;
	
	public static void write(){
		long c = System.currentTimeMillis();
		Writer writer = null;
		try {
			writer = new FileWriter("d:\\file.txt");
			for (int i = 0; i < length; i++) {
				writer.write(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.flush();
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(System.currentTimeMillis() - c);
	}

	public static void bufferwrite(){
		long c = System.currentTimeMillis();
		Writer writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("d:\\file1.txt"));
			for (int i = 0; i < length; i++) {
				writer.write(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.flush();
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(System.currentTimeMillis() - c);
	}
	
	
	public static void output(){
		long c = System.currentTimeMillis();
		OutputStream os = null;
		try {
			os = new FileOutputStream("d:\\out.txt");
			for (int i = 0; i < length; i++) {
				os.write(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.flush();
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(System.currentTimeMillis() - c);
	}
	
	
	public static void bufferoutput(){
		long c = System.currentTimeMillis();
		OutputStream os = null;
		try {
			os = new BufferedOutputStream(new FileOutputStream("d:\\out1.txt"));
			for (int i = 0; i < length; i++) {
				os.write(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.flush();
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(System.currentTimeMillis() - c);
	}
	
	public static void main(String[] args) {
//		write();
//		bufferwrite();
		
		output();
		bufferoutput();
	}
	
}
