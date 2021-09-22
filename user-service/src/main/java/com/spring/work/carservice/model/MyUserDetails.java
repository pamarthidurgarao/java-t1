package com.spring.work.carservice.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.work.carservice.entity.User;

public class MyUserDetails implements UserDetails {

    /**
     * 
     */
    private static final long serialVersionUID = -787584210891708206L;
    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
	return null;
    }

    @Override
    public String getPassword() {
	return user.getPassword();
    }

    @Override
    public String getUsername() {
	return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
	return false;
    }

    @Override
    public boolean isAccountNonLocked() {
	return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
	return false;
    }

    @Override
    public boolean isEnabled() {
	return false;
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

}
