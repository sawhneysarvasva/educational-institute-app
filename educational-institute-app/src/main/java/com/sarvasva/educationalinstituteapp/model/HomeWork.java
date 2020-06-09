package com.sarvasva.educationalinstituteapp.model;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class HomeWork extends BaseEntity{
	@Lob
	String description;
	Boolean isCompleted;
	@OneToOne
	BatchClass batchClass;
	
	public HomeWork(String description, Boolean isCompleted, BatchClass batchClass) {
		super();
		this.description = description;
		this.isCompleted = isCompleted;
		this.batchClass = batchClass;
	}

	public HomeWork() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public BatchClass getBatchClass() {
		return batchClass;
	}

	public void setBatchClass(BatchClass batchClass) {
		this.batchClass = batchClass;
	}
	
	
	
}
