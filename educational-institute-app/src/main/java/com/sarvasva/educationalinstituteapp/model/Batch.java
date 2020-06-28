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
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
	Faculty faculty;
	
	@OneToMany(cascade = CascadeType.ALL)
	Set<Doubt> doubts=new HashSet<Doubt>();
	@OneToMany(cascade =CascadeType.ALL)
	Set<BatchClass> batchClasses=new HashSet<BatchClass>();
	@OneToMany(cascade = CascadeType.ALL)
	Set<Suscription> suscriptions=new HashSet<Suscription>();
	
	public Batch(Date startDate, Integer maximumCapacity, Course course, Faculty faculty) {
		super();
		this.startDate = startDate;
		this.maximumCapacity = maximumCapacity;
		this.course = course;
		this.faculty = faculty;
	}
	
	
	
	
	
	
	
	
	
}
