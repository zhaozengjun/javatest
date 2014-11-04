/**
 * 
 */
package com.mianshi.jd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**  
 * @ProjectName：javatest  
 * @TypeName：Test  
 * @TypeDesc：  
 * @author：Administrator  
 *   
 */
public class Test {
	
	static List<String> list = new ArrayList<String>();
	List<String> used = new ArrayList<String>();
	
	static {
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
	}

	public static void main(String[] args) {
        new Test('a','d').start();
//		test();
	}
	
	public static void test(){
		List<String> list2 = new ArrayList<String>();
		Collections.copy(list2, list);
//		System.arraycopy(list, 0, list2, 0, list.size());
		System.out.println(list2);
		for (int i = 0; i < list.size(); i++) {
		}
	}
	
	private char initial;
    private char last;
    List<Character> chars=new ArrayList<Character>();
    

    public Test(char initial,char last) {
        this.initial=initial;
        this.last=last;
        for (char c = this.initial; c <= this.last; c++) {
            chars.add(c);
        }
    }

    public void start(){
        next(chars,new ArrayList<Character>());
    }

    private void next(List<Character> unused,List<Character> used){
        if(unused.isEmpty()){
        	System.out.println(used);
        }else{
            for(int i=0;i<unused.size();i++){
                List<Character> cur=new ArrayList<Character>(unused);
                List<Character> curUsed=new ArrayList<Character>(used);
                curUsed.add(cur.remove(i));
                next(cur,curUsed);
            }
        }
    }
}
