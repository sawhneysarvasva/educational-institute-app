package com.sarvasva.educationalinstituteapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class BatchWeeklySchedule extends BaseEntity {
	@OneToOne
	Batch batch;
	@OneToMany
	Set<BatchDailySechedule> batchDailySchedule=new HashSet<BatchDailySechedule>();
	public BatchWeeklySchedule(Batch batch) {
		super();
		this.batch = batch;
	}
	public BatchWeeklySchedule() {
		super();
	}
	public Batch getBatch() {
		return batch;
	}
	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	public Set<BatchDailySechedule> getBatchDailySchedule() {
		return batchDailySchedule;
	}
	public void setBatchDailySchedule(Set<BatchDailySechedule> batchDailySchedule) {
		this.batchDailySchedule = batchDailySchedule;
	}
	
	
	
}
