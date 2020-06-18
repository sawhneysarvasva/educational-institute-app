package com.sarvasva.educationalinstituteapp.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
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
public class HomeWork{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Lob
	String description;
	Boolean isCompleted;
	@OneToOne
	BatchClass batchClass;
	
	
	
}
