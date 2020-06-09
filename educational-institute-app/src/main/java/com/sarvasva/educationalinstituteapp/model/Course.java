package com.sarvasva.educationalinstituteapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Course extends BaseEntity {
	String name;
	@OneToOne
	CourseType courseType;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "course")
	Set<Batch> batches=new HashSet<Batch>();
	
	public Course(String name, CourseType courseType) {
		super();
		this.name = name;
		this.courseType = courseType;
	}
	
	public Course() {
		super();
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CourseType getCourseType() {
		return courseType;
	}

	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}

	public Set<Batch> getBatches() {
		return batches;
	}

	public void setBatches(Set<Batch> batches) {
		this.batches = batches;
	}

	
	

	

	
	
	
	
	
	
}
