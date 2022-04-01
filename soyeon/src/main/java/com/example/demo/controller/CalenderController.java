package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.controller.dao.CalenderRepository;
import com.example.demo.dto.calender.entity.CalEntity;

@Controller
@RequestMapping(value = "/calender")
public class CalenderController {
	
	@Autowired
	CalenderRepository calRepository;
	
	@GetMapping("/calenderMain")
	public String calender(HttpServletRequest request, Authentication authentication, Model model){
		
	//	HttpSession session = request.getSession();
		String id = authentication.getName();
		System.out.println(id);
		
		model.addAttribute("id", id);
		/*
		CalEntity cal = CalEntity.builder()
		.id(id)
		.title("test")
		.detail("detailTest")
		.regDt(LocalDateTime.now())
		.updateDt(LocalDateTime.now())
		.build();
		
		calRepository.save(cal);
		calRepository.findAllById(id);
		
		*/
		
		
		
		return "calender/calenderMain";
	}
	
	@GetMapping("/calList")
	public @ResponseBody List<CalEntity> calList(Authentication authentication, Model model) {
		
		String id = authentication.getName();
		List<CalEntity> calList = calRepository.findAllById(id);
		if(calList.size() > 0) {
			model.addAttribute("calList", calList);
		}else {
			model.addAttribute("calList", "");
		}
		
		return calList;
	}
}
