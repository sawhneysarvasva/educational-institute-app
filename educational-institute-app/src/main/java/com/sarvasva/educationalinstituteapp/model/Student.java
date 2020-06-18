package com.sarvasva.educationalinstituteapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"},callSuper = false)
@Entity
@DiscriminatorValue( value="STUDENT" )
public class Student extends Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String className;
	
	@ManyToMany(mappedBy = "students")
	Set<Batch> batches=new HashSet<Batch>();
	@ManyToMany(mappedBy = "presentStudents")
	Set<BatchClass> presentBatchClasses=new HashSet<BatchClass>();
	@ManyToMany(mappedBy = "homeworkCompletedStudents")
	Set<BatchClass> homeworkCompletedBatchClasses=new HashSet<BatchClass>();
	
	public Student(String firstName, String lastName, String mobileNo, String email, String password, Boolean isEnabled,
			String address, String className) {
		super(firstName, lastName, mobileNo, email, password, isEnabled, address);
		this.className = className;
	}

	

	
	
	

}

