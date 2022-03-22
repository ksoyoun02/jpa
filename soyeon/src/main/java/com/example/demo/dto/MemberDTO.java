package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MemberDTO {
	
	private String id;
	private String pwd;
	private String name;
	private String account;
	
	private LocalDateTime lastAccessDt;

    private LocalDateTime regDt;

    public Member toEntity() {
        return new Member(id, pwd, name, account);
    }
}
