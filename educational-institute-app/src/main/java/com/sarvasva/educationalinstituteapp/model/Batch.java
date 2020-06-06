package com.sarvasva.educationalinstituteapp.model;

import java.util.Date;
import java.util.Set;

public class Batch {
	Date startDate;
	Date endDate;
	Integer maximumCapacity;
	Course course;
	Teacher teacher;
	Set<Student> students;
	Set<Doubt> doubts;
	BatchWeeklySchedule batchWeeklySchedule;
	Set<BatchClass> batchClasses;
	
	
	
}
