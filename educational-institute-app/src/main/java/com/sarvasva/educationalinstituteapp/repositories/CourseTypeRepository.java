package com.sarvasva.educationalinstituteapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sarvasva.educationalinstituteapp.model.CourseType;

@Repository
public interface CourseTypeRepository extends CrudRepository<CourseType,Long> {

}
