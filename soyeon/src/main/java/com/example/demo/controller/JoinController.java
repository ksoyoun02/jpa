package com.example.demo.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.controller.impl.MemberService;
import com.example.demo.controller.impl.MemberDao;
import com.example.demo.dto.MemberDTO;
import com.example.demo.dto.entity.Member;

@Controller
@RequestMapping(value = "/")
public class JoinController {
	
	@Autowired
	MemberDao mDao;
	
	@Autowired 
	MemberService mService;
	
	 @ResponseBody
	 @PostMapping("/signup")
	 //@RequestMapping(value = "/joinChk", method = RequestMethod.POST)
	 public String joinChk(HttpServletRequest request, Model model, MemberDTO mDto) {
		 String resultMsg = "";
		 Optional<Member> user = mDao.findById(mDto.getId());
		if(user.isPresent() == false) {
			mService.save(mDto);
			resultMsg = "<script>alert('회원가입성공');location.href = '/login';</script>";
		}else {
			resultMsg = "<script>alert('error.');</script>";
			return resultMsg;
		}
		return resultMsg;
		
	 }   
	 
	 @RequestMapping(value = "/idChk", method = {RequestMethod.GET})
	 public @ResponseBody int idChk(@RequestParam("id") String id) {
		int count = mDao.countById(id);
		return count;
	 }
	 
}
