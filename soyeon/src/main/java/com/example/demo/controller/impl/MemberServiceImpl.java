package com.example.demo.controller.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Role;
import com.example.demo.dto.MemberDTO;
import com.example.demo.dto.entity.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao mDao;
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Member> memberEntityWrapper = mDao.findById(id);
		
		Member memberEntity = memberEntityWrapper.orElse(null);
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		if(("admin").equals(memberEntity.getId())) {
			authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
		}else {
			authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
		}
		
		return new User(memberEntity.getId(),memberEntity.getPassword(), authorities);
	}
	
	@Transactional
	@Override
	public String save(MemberDTO mDto) {
		mDto.setLastAccessDt(LocalDateTime.now());
		mDto.setRegDt(LocalDateTime.now());
		 // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        mDto.setPassword(passwordEncoder.encode(mDto.getPassword()));
        
        Member member = Member.builder()
		.id(mDto.getId())
		.password(mDto.getPassword())
		.name(mDto.getName())
		.email(mDto.getEmail())
		.role(mDto.getRole())
		.lastAccessDt(mDto.getLastAccessDt())
		.regDt(mDto.getRegDt())
		.build();
        
        return mDao.save(member).getId();
        
		

       
	}

}
