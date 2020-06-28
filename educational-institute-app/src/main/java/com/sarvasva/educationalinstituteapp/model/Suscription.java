package com.sarvasva.educationalinstituteapp.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class Suscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	 @Temporal(TemporalType.TIMESTAMP)
	 private Date suscriptionStartDate;
	 @Temporal(TemporalType.TIMESTAMP)
	 private Date suscriptionEndDate;
	 @ManyToOne
	 Batch batch;
	 @ManyToOne
	 Student student;
	 @ManyToMany(mappedBy="presentSuscriptions")
	 Set<BatchClass> presentBatchClasses=new HashSet<BatchClass>();
	 @ManyToMany(mappedBy="homeworkCompletedSuscriptions")
	 Set<BatchClass> homeworkCompletedBatchClasses=new HashSet<BatchClass>();
	public Suscription(Date suscriptionStartDate, Batch batch, Student student) {
		super();
		this.suscriptionStartDate = suscriptionStartDate;
		this.batch = batch;
		this.student = student;
	}
	 
	 
}
