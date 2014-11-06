/**
 * 
 */
package com.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;
import java.io.PipedWriter;

/**  
 * @ProjectName：javatest  
 * @TypeName：PipeExample  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class PipeExample {
	
	public static void main(String[] args) throws IOException {
//		final PipedOutputStream out = new PipedOutputStream();
//		final PipedInputStream in = new PipedInputStream(out);
		
		final PipedWriter out = new PipedWriter();
		final PipedReader in = new PipedReader();
//		in.connect(out);
		out.connect(in);
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
//					out.write(("方 正 国 际").getBytes());
					out.write("方 正 国 际");
				} catch (IOException e) {
					e.printStackTrace();
				} finally{
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					int data = in.read();
					while (data != -1) {
						System.out.print((char)data);
						data = in.read();
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally{
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		thread.start();
		thread2.start();
		
	}
	
}
