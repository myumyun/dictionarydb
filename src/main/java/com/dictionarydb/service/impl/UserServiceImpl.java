package com.dictionarydb.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dictionarydb.entity.User;
import com.dictionarydb.enumaration.StatusType;
import com.dictionarydb.repository.UserRepository;
import com.dictionarydb.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User login(User user) {
		Optional<User> authUser = userRepository.findByEmail(user.getEmail());
		return authUser.get();
	}

	@Override
	public User logout(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
