package com.dictionarydb.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetail implements UserDetails {
	private static final long serialVersionUID = -860692192165075349L;
	private String username;
	private String token;
	private int id;
	private Collection<? extends GrantedAuthority> authorities;

	public UserDetail(String username, int id, String token,
			List<GrantedAuthority> grantedAuthorities) {

		this.username = username;
		this.id = id;
		this.token = token;
		this.authorities = grantedAuthorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getUserName() {
		return username;
	}

	public String getToken() {
		return token;
	}

	public int getId() {
		return id;
	}

}
