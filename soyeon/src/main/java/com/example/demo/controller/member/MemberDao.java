package com.example.demo.controller.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.member.entity.Member;

//Spring Data JPA에서 제공하는 JpaRepository 인터페이스를 상속
public interface MemberDao extends JpaRepository<Member, String>{

	Optional<Member> findById(String id);
	int countById(String id);
	
}
