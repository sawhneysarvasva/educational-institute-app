package com.sarvasva.educationalinstituteapp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sarvasva.educationalinstituteapp.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long>{
	Optional<Person> findByEmail(String email);
}
