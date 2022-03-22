package com.example.demo.controller.impl;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.dto.MemberDTO;

public interface MemberService extends UserDetailsService{

	String save(MemberDTO mDto);
 
}
