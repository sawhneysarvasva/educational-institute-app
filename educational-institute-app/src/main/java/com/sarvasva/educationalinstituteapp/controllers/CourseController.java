package com.sarvasva.educationalinstituteapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sarvasva.educationalinstituteapp.repositories.CourseRepository;

@Controller
public class CourseController {
	@Autowired
	CourseRepository courseRepository;
	
	@GetMapping({"/courses","/courses/","/courses/index.html"})
	String getCourses(Model model) {
		
		model.addAttribute("courses",courseRepository.findAll());
		return "Course/index";
	}
	

}
