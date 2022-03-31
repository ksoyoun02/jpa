package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.controller.dao.CalenderRepository;

@Controller
@RequestMapping(value = "/calender")
public class CalenderController {
	
	@Autowired
	CalenderRepository calRepository;
	
	@GetMapping("/")
	public String calender(Model model){
		
		return "/calender";
	}
}
