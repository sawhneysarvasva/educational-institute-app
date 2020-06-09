package com.sarvasva.educationalinstituteapp.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class BatchClass extends BaseEntity{
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
	
	public BatchClass(Batch batch, Date date, HomeWork homeWork) {
		super();
		this.batch = batch;
		this.date = date;
		this.homeWork = homeWork;
	}
	public BatchClass() {
		super();
	}
	public Batch getBatch() {
		return batch;
	}
	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public HomeWork getHomeWork() {
		return homeWork;
	}
	public void setHomeWork(HomeWork homeWork) {
		this.homeWork = homeWork;
	}
	public Set<Student> getPresentStudents() {
		return presentStudents;
	}
	public void setPresentStudents(Set<Student> presentStudents) {
		this.presentStudents = presentStudents;
	}
	public Set<Student> getHomeworkCompletedStudents() {
		return homeworkCompletedStudents;
	}
	public void setHomeworkCompletedStudents(Set<Student> homeworkCompletedStudents) {
		this.homeworkCompletedStudents = homeworkCompletedStudents;
	}
	
	
}
