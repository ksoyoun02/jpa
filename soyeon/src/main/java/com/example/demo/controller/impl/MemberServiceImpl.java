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

import com.example.demo.dto.Member;
import com.example.demo.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao mDao;
	
	@Override
	public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Member> memberEntityWrapper = mDao.findByAccount(account);
		Member memberEntity = memberEntityWrapper.orElse(null);
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER"));
		
		return new User(memberEntity.getId(),memberEntity.getPwd(), authorities);
	}
	
	@Transactional
	@Override
	public String save(MemberDTO mDto) {
		Member member = mDto.toEntity();
        member.setLastAccessDt(LocalDateTime.now());
        member.setRegDt(LocalDateTime.now());

        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setPwd(passwordEncoder.encode(member.getPwd()));
        return mDao.save(member).getId();
	}

}
