package com.sarvasva.educationalinstituteapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sarvasva.educationalinstituteapp.repositories.CourseRepository;

@Controller
public class FacultyController {
	@Autowired
	CourseRepository courseRepository;
	
	@GetMapping({"/faculty/","/faculty","/faculty/profile","/faculty/profile/","/faculty/profile/index.html"})
	String getCoursesForStudent(Model model) {
		
		model.addAttribute("courses",courseRepository.findAll());
		return "Faculty/Profile/index";
	}
}
