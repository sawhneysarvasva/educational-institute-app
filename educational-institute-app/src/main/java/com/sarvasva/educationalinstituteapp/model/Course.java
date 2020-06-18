package com.sarvasva.educationalinstituteapp.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"},callSuper = false)
@Entity
public class Course  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
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
	
	
	
	
}
