package com.example.demo.controller.impl;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Member;

//Spring Data JPA에서 제공하는 JpaRepository 인터페이스를 상속
public interface MemberDao extends JpaRepository<Member, String>{

	Optional<Member> findByAccount(String account);
	
}
