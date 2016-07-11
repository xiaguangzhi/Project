package com.iotek.util;

import java.util.Scanner;

public class Input {
	
	public  int input(){
		
		int nextInt=0;
		while (true) {
			try {
				System.out.println("请输入指定的操作");
				Scanner scanner=new Scanner(System.in);
				nextInt = scanner.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("输入错误请重新输入");
			}
		}
		return nextInt;
		
	}

}
