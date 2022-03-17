package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.memberDTO;

@Controller
public class JoinController {

	@GetMapping("/join")
	public String index(Model model, memberDTO mDto){
		model.addAttribute("text", "JoinPage");
		model.addAttribute("member", mDto);
		
		return "join";
	}
	
	 @RequestMapping(value = "joinChk", method = RequestMethod.POST)
	 public String joinChk(HttpServletRequest request, Model model, memberDTO mDto) {
		System.out.println(request);
		System.out.println(model);
		
		 return "join";
	 }   
}
