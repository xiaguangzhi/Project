package com.iotek.biz;

import com.iotek.entry.User;

public interface UserBiz {

	 boolean register(User user);
	 boolean login(User user);
	 User queryUser(User user);
	 boolean queryUserTo(User user);

}
