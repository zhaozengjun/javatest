/**
 * 
 */
package com.java_youhua.nio;

import java.nio.ByteBuffer;

import oracle.net.aso.b;

/**  
 * @ProjectName：javatest  
 * @TypeName：BufferTest  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class BufferTest {

	/**
	 * @author：Administrator  
	 * @Title: main
	 * @param args
	 * void
	 * @throws
	 */
	public static void main(String[] args) {
		test1();
	}

	
	public static void test1(){
		ByteBuffer buffer = ByteBuffer.allocate(15);
		System.out.println("初始化");
		System.out.println("limit = " + buffer.limit()
				+ ", capacity = " + buffer.capacity()
				+ ", position = " + buffer.position()
				);
		for (int i = 0; i < 10; i++) {
			buffer.put((byte)i);
		}
		System.out.println("放入10个元素");
		System.out.println("limit = " + buffer.limit()
				+ ", capacity = " + buffer.capacity()
				+ ", position = " + buffer.position()
				);
//		buffer.flip();
//		System.out.println("buffer.flip()");
		buffer.rewind();
		System.out.println("buffer.rewind()");
		System.out.println("limit = " + buffer.limit()
				+ ", capacity = " + buffer.capacity()
				+ ", position = " + buffer.position()
				);
		System.out.println("取出5个元素");
		for (int i = 0; i < 5; i++) {
			System.out.print(buffer.get());
		}
		System.out.println();
		System.out.println("limit = " + buffer.limit()
				+ ", capacity = " + buffer.capacity()
				+ ", position = " + buffer.position()
				);
//		buffer.flip();
//		System.out.println("buffer.flip()");
		buffer.rewind();
		System.out.println("buffer.rewind()");
		System.out.println("limit = " + buffer.limit()
				+ ", capacity = " + buffer.capacity()
				+ ", position = " + buffer.position()
				);
	}
	
}
