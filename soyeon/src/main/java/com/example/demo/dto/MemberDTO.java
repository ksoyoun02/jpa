package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MemberDTO {
	
	private String id;
	private String password;
	private String name;
	private String email;
	private String role;
	
	private LocalDateTime lastAccessDt;

    private LocalDateTime regDt;
/*
    public Member toEntity() {
        return new Member();
    }
    */
}
