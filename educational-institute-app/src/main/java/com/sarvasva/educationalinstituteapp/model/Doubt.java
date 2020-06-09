package com.sarvasva.educationalinstituteapp.model;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Doubt extends BaseEntity{
	@Lob
	String descrption;
	Boolean isSolved;
	@ManyToOne
	Batch batch;
	
	
	public Doubt(String descrption, Boolean isSolved, Batch batch) {
		super();
		this.descrption = descrption;
		this.isSolved = isSolved;
		this.batch = batch;
	}
	public Doubt() {
		super();
	}
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	public Boolean getIsSolved() {
		return isSolved;
	}
	public void setIsSolved(Boolean isSolved) {
		this.isSolved = isSolved;
	}
	public Batch getBatch() {
		return batch;
	}
	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	
	
	
}
