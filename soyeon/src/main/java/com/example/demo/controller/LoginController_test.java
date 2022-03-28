package com.example.demo.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.controller.impl.MemberDao;
import com.example.demo.dto.entity.Member;

@Controller
public class LoginController_test {
	
	
	@Autowired
	private MemberDao mDao;

	//@GetMapping("/login")
	public String login(Model model) {
		/***
		Member member = new Member();
		model.addAttribute("member",member);
		 
		List<Member> findAll = mDao.findAll();
		System.out.println("==========================================");
		System.out.println("findAll : 유형의 모든 인스턴스를 반환 --> " + findAll);
		System.out.println("==========================================");
		
		 	Arrays.asList()는 Arrays의 private 정적 클래스인 ArrayList를 리턴,
		 	!!java.util.ArrayList 클래스와 다름
		 	java.util.ArrayList 클래스는 set(), get(), contains()매서드를 가지고있지만
		 	원소를 추가하는 매서드는 가지고 있지 않기때문에 사이즈를 바꿀수없음.
		 
		// findAllById -> 주어진 ID를 가진 T 유형의 모든 인스턴스를 반환합니다.
		List<String> idList = Arrays.asList("test1","test2");
		List<Member> findAllById = mDao.findAllById(idList);
		System.out.println("findAllById --> " + findAllById);
		System.out.println("==========================================");
		 
		mDao.flush();
		//flush : 현재 버퍼에 저장되어 있는 내용을 클라이언트로 전송하고 버퍼를 비운다.
		
		***/
		
		
		return "login";
	}
	
    //@RequestMapping(value = "/loginFind", method = RequestMethod.POST)
	//@PostMapping("/login")
    public String loginFind(HttpServletRequest request, Model model, Member member) {
		System.out.println("test");
    	/*
    	 <Optional 메서드>
    	 	1. isPresent() : 값의 존재 확인
    	 	2. orElse : 없는 경우 다른 대체적인 인스턴스 리턴하게 할 수 있음
    	 	3. orElseThrow : 없는 경우 예외를 던짐
    	 */
    	Optional<Member> user = mDao.findById(member.getId()); 
    	if(user.isPresent() == false) {
    		System.out.println("계정없음");
    	}else {
    		if(!member.getPassword().equals(user.get().getPassword())) {
    			System.out.println("패스워드오류");
    		}else if(!member.getName().equals(user.get().getName())) {
    			System.out.println("이름 오류");
    		}else {
    			System.out.println("회원정보 일치");
    		}
    	}
        return "index";
    }

	
}
