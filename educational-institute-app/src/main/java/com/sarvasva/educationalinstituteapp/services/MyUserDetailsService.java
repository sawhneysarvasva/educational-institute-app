package com.sarvasva.educationalinstituteapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sarvasva.educationalinstituteapp.model.MyUserDetails;
import com.sarvasva.educationalinstituteapp.model.Person;
import com.sarvasva.educationalinstituteapp.model.Student;
import com.sarvasva.educationalinstituteapp.repositories.PersonRepository;


@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	PersonRepository personRepository;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Person> person=personRepository.findByEmail(userName);
		
		

		
		person.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
		// TODO Auto-generated method stub
		return new MyUserDetails(person.get());
		
	}

}
