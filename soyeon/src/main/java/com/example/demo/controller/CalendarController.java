package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.controller.dao.CalendarRepository;
import com.example.demo.dto.calendar.CalendarDTO;
import com.example.demo.dto.calendar.entity.CalEntity;

@Controller
@RequestMapping(value = "/calendar")
public class CalendarController {
	
	@Autowired
	CalendarRepository calRepository;
	
	@GetMapping("/calendarMain")
	public String calendar(HttpServletRequest request, Authentication authentication, Model model){
		
	//	HttpSession session = request.getSession();
		String id = authentication.getName();
		System.out.println(id);
		
		model.addAttribute("id", id);
		/*
	System.out.println(LocalDateTime.now());
		CalEntity cal = CalEntity.builder()
		.id(id)
		.title("test")
		.detail("detailTest")
		.startDt(LocalDateTime.now())
		.endDt(LocalDateTime.now())
		.regDt(LocalDateTime.now())
		.updateDt(LocalDateTime.now())
		.build();
		
		calRepository.save(cal);
		calRepository.findAllById(id);
		*/
		
		return "calendar/calendarMain";
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
	
	@GetMapping("/calPopup")
	public String calPopup(@RequestParam("startDt") String startDt, Model model) {
		model.addAttribute("startDt", startDt);
		System.out.println(startDt);
		return "calendar/calPopup";
	}
	
	@PostMapping("/addCalendar")
	public String addCalendar(Authentication authentication, CalendarDTO cDto) {
		System.out.println(cDto);
		String id = authentication.getName();
		calRepository.save(CalEntity.builder()
							.id(id)
							.title(cDto.getTitle())
							.detail(cDto.getDetail())
							.startDt(cDto.getStartDt())
							.endDt(cDto.getEndDt())
							.build());
		
		return "calendar/calendarMain";
	}
}
