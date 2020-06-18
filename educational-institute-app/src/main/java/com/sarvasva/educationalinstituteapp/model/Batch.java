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
public class Batch  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Date startDate;
	Integer maximumCapacity;
	@ManyToOne
	Course course;
	@ManyToOne
	Faculty teacher;
	
	
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
	
	
	
	
	
	
	
	
}
