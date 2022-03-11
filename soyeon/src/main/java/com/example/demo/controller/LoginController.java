package com.example.demo.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.controller.impl.Member_i;
import com.example.demo.dto.memberDTO;

@Controller
public class LoginController {
	
	
	@Autowired
	private Member_i member_i;

	@GetMapping("/")
	public String index(Model model){
		model.addAttribute("text", "indexPage");
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		memberDTO mDto = new memberDTO();
		mDto.setId("test");
		mDto.setPwd("1234");
		mDto.setName("name");
		model.addAttribute("member",mDto);
		return "login";
	}
	
    @RequestMapping(value = "/loginFind", method = RequestMethod.GET)
    public String loginFind(HttpServletRequest request, Model model, memberDTO mDto) {
    	System.out.println(mDto.getId());
        return "index";
    }

	
}
