package com.dictionarydb.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dictionarydb.annotation.Logging;
import com.dictionarydb.dto.UserDTO;
import com.dictionarydb.entity.User;
import com.dictionarydb.service.UserService;
import com.dictionarydb.util.ObjectMapperUtils;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	@Logging
	@PostMapping("/login")
	public UserDTO login(@RequestBody UserDTO userDTO) {
		User user = userService.login(ObjectMapperUtils.map(userDTO, User.class));
		if(user == null) {
			return null;
		}
		return ObjectMapperUtils.map(user, UserDTO.class);
	}
	
	@Logging
	@GetMapping("/logout")
	public String logout(UserDTO userDTO) {
		return "logout";
	}
}
