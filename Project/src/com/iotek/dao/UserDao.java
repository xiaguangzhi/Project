package com.iotek.dao;

import com.iotek.entry.User;

	public interface UserDao {
		boolean addUser(User user);
		User queryUser(User user);
		
		
	
	}
