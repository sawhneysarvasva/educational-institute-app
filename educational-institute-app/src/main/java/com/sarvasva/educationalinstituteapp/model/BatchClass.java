package com.sarvasva.educationalinstituteapp.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"},callSuper = false)
@Entity
public class BatchClass{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne
	Batch batch;
	Date date;
	@OneToOne(cascade=CascadeType.ALL)
	HomeWork homeWork;
	
	@ManyToMany
	@JoinTable(
			name="batch_class_present_student",
			joinColumns=@JoinColumn(name="batch_id"),
			inverseJoinColumns=@JoinColumn(name="student_id"))
	Set<Student> presentStudents=new HashSet<Student>();
	@ManyToMany
	@JoinTable(
			name="batch_class_homework_comp_student",
			joinColumns=@JoinColumn(name="batch_id"),
			inverseJoinColumns=@JoinColumn(name="student_id"))
	Set<Student> homeworkCompletedStudents=new HashSet<Student>();
	
	
	
	
}
