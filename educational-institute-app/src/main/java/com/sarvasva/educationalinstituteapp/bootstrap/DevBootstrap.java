package com.sarvasva.educationalinstituteapp.bootstrap;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sarvasva.educationalinstituteapp.model.Course;
import com.sarvasva.educationalinstituteapp.model.CourseType;
import com.sarvasva.educationalinstituteapp.model.Faculty;
import com.sarvasva.educationalinstituteapp.model.Person;
import com.sarvasva.educationalinstituteapp.model.Student;
import com.sarvasva.educationalinstituteapp.repositories.CourseRepository;
import com.sarvasva.educationalinstituteapp.repositories.CourseTypeRepository;
import com.sarvasva.educationalinstituteapp.repositories.PersonRepository;



@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	 
	CourseRepository courseRepository;
	CourseTypeRepository courseTypeRepository;
	PersonRepository personRepository;
	
	public DevBootstrap(CourseRepository courseRepository, CourseTypeRepository courseTypeRepository,
			PersonRepository personRepository) {
		super();
		this.courseRepository = courseRepository;
		this.courseTypeRepository = courseTypeRepository;
		this.personRepository = personRepository;
	}


	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		
		Person sarvasva=new Student("Sarvasva","Sawhney","7752004457","sawhneysarvasva@gmail.com","pass",true,"79 Ansari Marg","Class 12");
		Person manas=new Student("Manas","Sawhney","7752004457","manassawhney2012@gmail.com","pass",true,"79 Ansari Marg","Class 10");
		Person renu=new Faculty("Renu","Sahni","7752004457","renusahni@gmail.com","pass",true,"79 Ansari Marg","MSC Maths");
		
		personRepository.save(sarvasva);
		personRepository.save(manas);
		personRepository.save(renu);
		
	
		CourseType class12=new CourseType("Class 12");
		CourseType class10=new CourseType("Class 10");
		Course class12Maths=new Course("Class 12 Maths",class12);
		Course class12Physics=new Course("Class 12 Physics",class12);
		Course class10Maths=new Course("Class 12 Maths",class10);
		Course class10Physics=new Course("Class 12 Physics",class10);
		courseTypeRepository.save(class12);
		courseTypeRepository.save(class10);
		courseRepository.save(class12Maths);
		courseRepository.save(class12Physics);
		courseRepository.save(class10Maths);
		courseRepository.save(class10Physics);
		
	
		
	}

}