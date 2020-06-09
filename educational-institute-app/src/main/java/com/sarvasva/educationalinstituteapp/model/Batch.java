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
public class Batch extends BaseEntity {
	
	
	Date startDate;
	Integer maximumCapacity;
	@ManyToOne
	Course course;
	@ManyToOne
	Teacher teacher;
	
	@OneToOne
	BatchWeeklySchedule batchWeeklySchedule;
	@ManyToMany
	@JoinTable(
			name="batch_student",
			joinColumns=@JoinColumn(name="batch_id"),
			inverseJoinColumns=@JoinColumn(name="student_id"))
	Set<Student> students=new HashSet<Student>();
	@OneToMany(cascade = CascadeType.ALL)
	Set<Doubt> doubts=new HashSet<Doubt>();
	@OneToMany(cascade =CascadeType.ALL)
	Set<BatchClass> batchClasses=new HashSet<BatchClass>();
	
	public Batch(Date startDate, Integer maximumCapacity, Course course, Teacher teacher,
			BatchWeeklySchedule batchWeeklySchedule) {
		super();
		this.startDate = startDate;
		this.maximumCapacity = maximumCapacity;
		this.course = course;
		this.teacher = teacher;
		this.batchWeeklySchedule = batchWeeklySchedule;
	}
	public Batch() {
		super();
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Integer getMaximumCapacity() {
		return maximumCapacity;
	}
	public void setMaximumCapacity(Integer maximumCapacity) {
		this.maximumCapacity = maximumCapacity;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public BatchWeeklySchedule getBatchWeeklySchedule() {
		return batchWeeklySchedule;
	}
	public void setBatchWeeklySchedule(BatchWeeklySchedule batchWeeklySchedule) {
		this.batchWeeklySchedule = batchWeeklySchedule;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Set<Doubt> getDoubts() {
		return doubts;
	}
	public void setDoubts(Set<Doubt> doubts) {
		this.doubts = doubts;
	}
	public Set<BatchClass> getBatchClasses() {
		return batchClasses;
	}
	public void setBatchClasses(Set<BatchClass> batchClasses) {
		this.batchClasses = batchClasses;
	}
	
	
	
	
	
	
}
