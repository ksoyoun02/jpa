package com.example.demo.dto.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.dto.MemberDTO;

import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Table(name = "member")
/*
 * @SequenceGenerator(name = "MEMBER_SEQ_GENERATOR", sequenceName =
 * "MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름 initialValue = 1, allocationSize = 1)
 */
public class Member {

	/*
	 * seq로 pk잡고싶을때 사용
	 * 
	 * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	 * "MEMBER_SEQ_GENERATOR") private int member_seq;
	 */

	// @ID -> pk설정
	@Id
	private String id;

	// @Column(" ") -> column명과 다르게 mapping 가능
	@Column
	private String password;

	@Column
	private String name;

	@Column
	private String email;

	@Column(name = "last_access_dt")
	private LocalDateTime lastAccessDt;

	@Column(name = "reg_dt")
	private LocalDateTime regDt;

	@Column
	private String role;

	
	public Member() {
	}
	/*
	public Member(String id, String password, String name, String email, String role) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	*/
	@Builder
	public Member(MemberDTO mDto) {
		this.id = mDto.getId();
		this.password = mDto.getPassword();
		this.name = mDto.getName();
		this.email = mDto.getEmail();
		this.role = mDto.getRole();
		this.lastAccessDt = mDto.getLastAccessDt();
		this.regDt = mDto.getRegDt();
	}
	 
}
