/**
 * 
 */
package com.java_youhua.map;

/**  
 * @ProjectName：javatest  
 * @TypeName：Inner  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class Inner implements Comparable<Inner>{
	
		String no;
		String name;
		
		/**
		 * 
		 */
		public Inner() {
			super();
		}
		/**
		 * @param no
		 * @param name
		 */
		public Inner(String no, String name) {
			super();
			this.no = no;
			this.name = name;
		}
		public String getNo() {
			return no;
		}
		public void setNo(String no) {
			this.no = no;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public int compareTo(Inner o) { 
			if (this.no.compareTo(o.getNo()) != 0) {
				return this.no.compareTo(o.getNo());
			}else {
				return this.name.compareTo(o.getName());
			} 
		}

}
