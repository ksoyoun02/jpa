package com.example.demo.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private Member_i member_i;
	
	@Override
	public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Member> memberEntityWrapper = member_i.findById(account);
		Member memberEntity = memberEntityWrapper.orElse(null);
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER"));
		
		return new User(memberEntity.getId(),memberEntity.getPwd(), authorities);
	}
	
	

}
