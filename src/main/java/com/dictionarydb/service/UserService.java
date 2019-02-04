package com.dictionarydb.service;

import com.dictionarydb.entity.User;

public interface UserService {
	public User login(User user);
	public User logout(User user);
	public void init();
}
