package com.sarvasva.educationalinstituteapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CourseType extends BaseEntity {
	
	String name;
	
	public CourseType(String name) {
		super();
		this.name = name;
	}
	public CourseType() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
