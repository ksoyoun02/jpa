package com.example.demo.controller.member;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.dto.member.MemberDTO;

public interface MemberService extends UserDetailsService{

	String save(MemberDTO mDto);
 
}
