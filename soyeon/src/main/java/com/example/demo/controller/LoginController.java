package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.controller.impl.Member_i;
import com.example.demo.dto.memberDTO;

@Controller
public class LoginController {
	
	
	@Autowired
	private Member_i member_i;

	@GetMapping("/")
	public String index(Model model){
		return "index";
	}
	
	@GetMapping("/login")
	public ModelAndView login(Model model){
		System.out.println("login");
		Optional<memberDTO> mDto = member_i.findById("testID");
		System.out.println(mDto.get().getPwd());
		return new ModelAndView("index");
	}
}
