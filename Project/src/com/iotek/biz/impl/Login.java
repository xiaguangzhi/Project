package com.iotek.biz.impl;

import java.util.Scanner;

import com.iotek.biz.UserBiz;
import com.iotek.entry.User;
import com.iotek.util.Input;
import com.iotek.view.Info;



public class Login {
	private Info info;
	private Input input;
	private Scanner scanner;
	private UserBiz userBiz;
	private User user;//保证全局一个用户
	public Login() {
		info=new Info();
		info.header();
		input=new Input();
		scanner=new Scanner(System.in);
		userBiz=new UserBizImpl();
		user=new User();
	}
	public void login(){
		boolean flag=true;
		while (flag) {
			System.out.println("请选择：1：注册  2：登录     0：退出");
			int key = 0;
			while (true) {
				key = input.input();
				if (key >= 0 && key < 3) {
					break;
				}

			}
			switch (key) {
			case 1:
				boolean reg=userBiz.register(user);
				if (reg) {//如果注册成功结束该循环
					flag=false;
				}
				break;
			case 2:
				if (userBiz.login(user)) {
					flag=false;
				}
				
				break;
			case 0:
				System.out.println("退出成功");
				System.exit(0);
				break;
			default:
				break;
			}
		}
		
		
	}
	public void oper(){
		int usertype=user.getType();
		switch (usertype) {
		case 0:
			info.common();
			break;
		case 1:
			info.admin();
			break;
		default:
			break;
		}
		
	}
}
