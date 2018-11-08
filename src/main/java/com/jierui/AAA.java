package com.jierui;

public class AAA {
	public static void main(String[] args) {
		System.out.println(dd(5));

		System.out.println(ff(8));
	}
	static void  aa() {
		/*for(int i=0;i<100;i++)*/
		System.out.println(" 子线程 ");
	}
	 //n * (n-1) * (n-2) * ...* 1(n>0)
	static int dd(int s) {
		
		if(s-1>0) {
			s = s* (dd(s-1));
		}
		
		return s;
		
	}
	//1、1、2、3、5、8、13、21、……
	//F(n) = F(n-1) + F(n-2),(n>=2)
	static int ff(int num) {

		return num<2 ? num:(ff(num-1)+ff(num-2));

			
		}
	
}
