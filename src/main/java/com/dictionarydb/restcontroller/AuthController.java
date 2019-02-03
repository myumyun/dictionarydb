package com.dictionarydb.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dictionarydb.annotation.Logging;
import com.dictionarydb.dto.UserDTO;
import com.dictionarydb.repository.UserRepository;
import com.dictionarydb.security.JwtTokenProvider;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtTokenProvider tokenProvider;

	@Logging
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(
			@Valid @RequestBody UserDTO userDTO) {
		


		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userDTO.getEmail(),
						userDTO.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok(jwt);
	}

	// @PostMapping("/signup")
	// public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest
	// signUpRequest) {
	// if(userRepository.existsByUsername(signUpRequest.getUsername())) {
	// return new ResponseEntity(new ApiResponse(false, "Username is already
	// taken!"),
	// HttpStatus.BAD_REQUEST);
	// }
	//
	// if(userRepository.existsByEmail(signUpRequest.getEmail())) {
	// return new ResponseEntity(new ApiResponse(false, "Email Address already
	// in use!"),
	// HttpStatus.BAD_REQUEST);
	// }
	//
	// // Creating user's account
	// User user = new User(signUpRequest.getName(),
	// signUpRequest.getUsername(),
	// signUpRequest.getEmail(), signUpRequest.getPassword());
	//
	// user.setPassword(passwordEncoder.encode(user.getPassword()));
	//
	// Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
	// .orElseThrow(() -> new AppException("User Role not set."));
	//
	// user.setRoles(Collections.singleton(userRole));
	//
	// User result = userRepository.save(user);
	//
	// URI location = ServletUriComponentsBuilder
	// .fromCurrentContextPath().path("/users/{username}")
	// .buildAndExpand(result.getUsername()).toUri();
	//
	// return ResponseEntity.created(location).body(new ApiResponse(true, "User
	// registered successfully"));
	// }
}