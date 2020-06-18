package com.sarvasva.educationalinstituteapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sarvasva.educationalinstituteapp.repositories.CourseTypeRepository;

@Controller
public class CourseTypeController {
	@Autowired
	CourseTypeRepository courseTypeRepository;
	
	@GetMapping({"/coursetypes","/coursetypes/","/coursetypes/index.html"})
	String getCourses(Model model) {
		
		model.addAttribute("courseTypes",courseTypeRepository.findAll());
		return "CourseType/index";
	}
	
}
