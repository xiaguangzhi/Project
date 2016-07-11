package com.iotek.test;

import com.iotek.biz.impl.Login;

public class Test {
	public static void main(String[] args) {
		//1:注册登录
		Login login=new Login();
		login.login();
		//2：各种操作
		login.oper();
		
	}

}
