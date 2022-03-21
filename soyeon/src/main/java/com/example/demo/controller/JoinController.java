package com.example.demo.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.controller.impl.Member_i;
import com.example.demo.dto.memberDTO;

@Controller
public class JoinController {
	
	@Autowired
	Member_i member_i;
	
	@GetMapping("/join")
	public String index(Model model, memberDTO mDto){
		model.addAttribute("text", "JoinPage");
		model.addAttribute("member", mDto);
		
		return "join";
	}

	 @ResponseBody
	 @RequestMapping(value = "/joinChk", method = RequestMethod.POST)
	 public String joinChk(HttpServletRequest request, Model model, memberDTO mDto) {
		String resultMsg = "";
		 Optional<memberDTO> user = member_i.findById(mDto.getId());
		if(user.isPresent() == false) {
			member_i.save(mDto);
			resultMsg = "<script>alert('회원가입성공');location.href = '/main';</script>";
		}else {
			model.addAttribute("member",mDto);
			resultMsg = "<script>alert('이미 존재하는 아이디입니다.');location.href = '/login';</script>";
			return resultMsg;
		}
		return resultMsg;
	 }   
}
