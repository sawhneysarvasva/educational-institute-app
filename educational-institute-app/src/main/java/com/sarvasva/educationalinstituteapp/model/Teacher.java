package com.sarvasva.educationalinstituteapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
@Entity
public class Teacher extends Person{
	String educationalQualification;
	
	@OneToMany
	Set<Batch> batches=new HashSet<Batch>();
	public Teacher(String firstName, String lastName, String mobileNo, String email, Address address,
			String educationalQualification) {
		super(firstName, lastName, mobileNo, email, address);
		this.educationalQualification = educationalQualification;
	}
	public Teacher(String firstName, String lastName, String mobileNo, String email, Address address) {
		super(firstName, lastName, mobileNo, email, address);
	}
	public String getEducationalQualification() {
		return educationalQualification;
	}
	public void setEducationalQualification(String educationalQualification) {
		this.educationalQualification = educationalQualification;
	}
	public Set<Batch> getBatches() {
		return batches;
	}
	public void setBatches(Set<Batch> batches) {
		this.batches = batches;
	}
	
	
	
}
