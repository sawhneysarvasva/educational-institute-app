package com.sarvasva.educationalinstituteapp.model;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue( value="FACULTY" )
public class Faculty extends Person{
	String educationalQualification;
	
	@OneToMany
	Set<Batch> batches=new HashSet<Batch>();

	public Faculty(String firstName, String lastName, String mobileNo, String email, String password, Boolean isEnabled,
			String address, String educationalQualification) {
		super(firstName, lastName, mobileNo, email, password, isEnabled, address);
		this.educationalQualification = educationalQualification;
	}
	


	
	
	
}
