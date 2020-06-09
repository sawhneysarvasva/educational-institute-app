package com.sarvasva.educationalinstituteapp.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class BatchDailySechedule extends BaseEntity {
	@Enumerated(value = EnumType.STRING)
	WeekDays weekDay;
	String startTime;
	Integer durationInMinutes;
	public BatchDailySechedule(WeekDays weekDay, String startTime, Integer durationInMinutes) {
		super();
		this.weekDay = weekDay;
		this.startTime = startTime;
		this.durationInMinutes = durationInMinutes;
	}
	public BatchDailySechedule() {
		super();
	}
	public WeekDays getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(WeekDays weekDay) {
		this.weekDay = weekDay;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public Integer getDurationInMinutes() {
		return durationInMinutes;
	}
	public void setDurationInMinutes(Integer durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}
	
	
	
	
	
	
}
