package com.example.demo;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.impl.MemberDao;
import com.example.demo.dto.entity.Member;

@SpringBootTest
class SoyeonApplicationTests { 

	@Autowired
	MemberDao mDao;
	@Test
	void contextLoads() {
		Optional<Member> mem = mDao.findById("5");
		Member member = Member.builder()
				.id(mem.get().getId())
				.password(mem.get().getPassword())
				.name(mem.get().getName())
				.email(mem.get().getEmail())
				.role(mem.get().getRole())
				.lastAccessDt(LocalDateTime.now())
				.regDt(mem.get().getRegDt())
				.build();
		mDao.save(member);
	};
	

}
