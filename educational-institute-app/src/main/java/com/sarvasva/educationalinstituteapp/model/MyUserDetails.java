package com.sarvasva.educationalinstituteapp.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
	
	Person person;
	private List<GrantedAuthority> authorities;
	

	public MyUserDetails() {
		super();
	}

	

	public MyUserDetails(Person person) {
		super();
		this.person = person;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		 List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		 String role="";
		 if (person instanceof  Student) {
			 role="ROLE_STUDENT";
		 }else if (person instanceof Faculty) {
			 role="ROLE_FACULTY";
		 }
		 authorities.add(new SimpleGrantedAuthority(role));	
		
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return person.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return person.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return person.getIsEnabled();
	}

}
