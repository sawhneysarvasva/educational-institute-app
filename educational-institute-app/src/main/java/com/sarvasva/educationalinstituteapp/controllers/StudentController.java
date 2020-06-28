package com.sarvasva.educationalinstituteapp.controllers;

import java.util.Date;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sarvasva.educationalinstituteapp.model.Batch;
import com.sarvasva.educationalinstituteapp.model.Course;
import com.sarvasva.educationalinstituteapp.model.Student;
import com.sarvasva.educationalinstituteapp.model.Suscription;
import com.sarvasva.educationalinstituteapp.repositories.CourseRepository;
import com.sarvasva.educationalinstituteapp.repositories.PersonRepository;

@Controller
@RequestMapping({"/student","/student/"})
public class StudentController {
	
	private CourseRepository courseRepository;
	private PersonRepository personRepository;
	private Logger logger=LoggerFactory.getLogger(StudentController.class);
	
	
	public StudentController(CourseRepository courseRepository, PersonRepository personRepository) {
		super();
		this.courseRepository = courseRepository;
		this.personRepository = personRepository;
	}

	@GetMapping({"","/","/courses","/courses/","/courses/index.html"})
	String getCoursesForStudent(Model model) {
		
		model.addAttribute("courses",courseRepository.findAll());
		return "Student/Course/index";
	}
	
	@GetMapping({"/courses/{courseId}/batches/","/courses/{courseId}/batches"})
	String getBatchesForCourse(Model model,@PathVariable(name="courseId") Long courseId) {
		Student student=getLoggedInStudentDetails();
		Set<Batch>	allBatchesOfCourse =courseRepository.findById(courseId).get().getBatches();
		Set<Suscription>	allStudentSuscriptions =student.getSuscriptions();
		if(allBatchesOfCourse.size()>0) {
			model.addAttribute("batches",courseRepository.findById(courseId).get().getBatches());
			Set<Batch>	allStudentBatches =student.getSuscriptions().stream().map(suscription->suscription.getBatch()).collect(Collectors.toSet());
			Optional<Batch> studentSuscribedBatchOptional=allBatchesOfCourse.stream().filter(batch->allStudentBatches.contains(batch)).findFirst();
			
			if(studentSuscribedBatchOptional.isPresent())
			{
				
				model.addAttribute("studentSuscribedBatch", studentSuscribedBatchOptional.get());
				logger.info(model.getAttribute("studentSuscribedBatch").toString());
			}
		}
		return "Student/Batch/index";
	}
	
	private Student getLoggedInStudentDetails() {
		String  email;
	    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			email = ((UserDetails)principal).getUsername();
		} else {
			email = principal.toString();
		}
		
	
		Student student=(Student)(personRepository.findByEmail(email).get());
		return student;
	}

	@PostMapping({"/courses/batches/suscribe/","/courses/batches/suscribe"})
	String suscribeCourse(@RequestParam Long courseId,@RequestParam Long batchId,RedirectAttributes redirectAttributes) {
		Student student=getLoggedInStudentDetails();
		Course course=courseRepository.findById(courseId).get();
		
		Optional<Batch> batchOptional =course.getBatches().stream().filter(b->b.getId()==batchId).findFirst();
		if(batchOptional.isPresent()) {
			Batch studentBatch=batchOptional.get();
			Suscription suscription=new Suscription(new Date(),studentBatch,student);
			student.getSuscriptions().add(suscription);
			studentBatch.getSuscriptions().add(suscription);
			courseRepository.save(course);
			personRepository.save(student);
		}
		
		
		redirectAttributes.addAttribute("courseId",courseId);
		return "redirect:/student/courses/{courseId}/batches";
	}
	
	@PostMapping({"/courses/batches/unsuscribe/","/courses/batches/unsuscribe"})
	String unsuscribeCourse(@RequestParam Long courseId,@RequestParam Long batchId,RedirectAttributes redirectAttributes) {
		Student student=getLoggedInStudentDetails();
		Course course=courseRepository.findById(courseId).get();
		
		Optional<Batch> batchOptional =course.getBatches().stream().filter(b->b.getId()==batchId).findFirst();
		if(batchOptional.isPresent()) {
			
			Optional<Suscription> studentSuscriptionOptional=student.getSuscriptions().stream().filter((suscription)->suscription.getBatch().getId()==batchId).findFirst();
			if(studentSuscriptionOptional.isPresent())
			{
				Batch studentBatch=batchOptional.get();
				Suscription studentSuscription=studentSuscriptionOptional.get();
				student.getSuscriptions().remove(studentSuscription);
				studentBatch.getSuscriptions().remove(studentSuscription);
				courseRepository.save(course);
				personRepository.save(student);
			}
			
		}
		
		
		redirectAttributes.addAttribute("courseId",courseId);
		return "redirect:/student/courses/{courseId}/batches";
	}
	
	
}
