package com.example.demo.dto.member;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
	
	private String id;
	private String password;
	private String name;
	private String email;
	private String role;
	
	private LocalDateTime lastAccessDt;

    private LocalDateTime regDt;
    
}
