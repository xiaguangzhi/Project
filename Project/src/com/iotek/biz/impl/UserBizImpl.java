package com.iotek.biz.impl;

import java.util.Scanner;

import com.iotek.biz.UserBiz;
import com.iotek.dao.UserDao;
import com.iotek.dao.impl.UserDaoImpl;
import com.iotek.entry.User;
import com.iotek.util.Input;

public class UserBizImpl implements UserBiz{
	private UserDao userdao=null;
	private Scanner scanner;
	private Input input;
	 public UserBizImpl() {
		userdao=new UserDaoImpl();
		scanner=new Scanner(System.in);
		input=new Input();
	}

	@Override
	public boolean register(User user) {
		String name=null;
		String password=null;
		System.out.println("注册");
		System.out.println("请输入用户名");
		name=scanner.next();
		user.setName(name);
		System.out.println("请输入密码");
		password=scanner.next();
		user.setPassword(password);
		user.setType(0);
		boolean flaguser=queryUserTo(user);
		if (flaguser) {
			System.out.println("用户已存在");
			return false;
		}else {
			boolean register =userdao.addUser(user);
			if (register) {
				System.out.println("注册成功");
				return true;
			}else {
				System.out.println("注册失败");
				return false;
			}
		}
	}

	@Override
	public boolean login(User user) {
		String name=null;
		String password=null;
		int type=0;
		System.out.println("请输入用户名");
		name=scanner.next();
		System.out.println("请输入密码");
		password=scanner.next();
		System.out.println("请选择： 0： 普通用户     1：管理员");
		type=input.input();
		user.setName(name);
		user.setPassword(password);
		user.setType(type);
		boolean flaguser=queryUserTo(user);
		if (flaguser) {
			return true;
		}else {
			System.out.println("用户不存在，请选择注册");
			return false;
		}
	}

	@Override
	public User queryUser(User user) {
		
		return userdao.queryUser(user);
	}

	@Override
	public boolean queryUserTo(User user) {
		User queryUser = queryUser(user);
		if (queryUser!=null) {
			return true;
		}
		return false;
	}

}
