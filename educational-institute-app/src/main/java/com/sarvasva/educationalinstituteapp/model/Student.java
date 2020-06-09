package com.sarvasva.educationalinstituteapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Student extends Person {
	String className;
	
	@ManyToMany(mappedBy = "students")
	Set<Batch> batches=new HashSet<Batch>();
	@ManyToMany(mappedBy = "presentStudents")
	Set<BatchClass> presentBatchClasses=new HashSet<BatchClass>();
	@ManyToMany(mappedBy = "homeworkCompletedStudents")
	Set<BatchClass> homeworkCompletedBatchClasses=new HashSet<BatchClass>();

	public Student(String firstName, String lastName, String mobileNo, String email, Address address,
			String className) {
		super(firstName, lastName, mobileNo, email, address);
		this.className = className;
	}

	public Student(String firstName, String lastName, String mobileNo, String email, Address address) {
		super(firstName, lastName, mobileNo, email, address);
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Set<BatchClass> getPresentBatchClasses() {
		return presentBatchClasses;
	}

	public void setPresentBatchClasses(Set<BatchClass> presentBatchClasses) {
		this.presentBatchClasses = presentBatchClasses;
	}

	public Set<BatchClass> getHomeworkCompletedBatchClasses() {
		return homeworkCompletedBatchClasses;
	}

	public void setHomeworkCompletedBatchClasses(Set<BatchClass> homeworkCompletedBatchClasses) {
		this.homeworkCompletedBatchClasses = homeworkCompletedBatchClasses;
	}

	public Set<Batch> getBatches() {
		return batches;
	}

	public void setBatches(Set<Batch> batches) {
		this.batches = batches;
	}
	
	
	

}

