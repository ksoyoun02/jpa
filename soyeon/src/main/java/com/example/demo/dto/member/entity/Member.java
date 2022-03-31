package com.example.demo.dto.member.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@DynamicUpdate
@DynamicInsert
//@AllArgsConstructor  //모든 멤버 필드에 대해서 매개변수를 받는 기본 생성자
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본생성자
@Getter
//@Data
@Entity
@ToString
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

	/*
	public Member() {
	}
	
	public Member(String id, String password, String name, String email, String role) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	*/
	@Builder
	public Member(String id, String password, String name, String email, LocalDateTime lastAccessDt,
			LocalDateTime regDt, String role) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.lastAccessDt = lastAccessDt;
		this.regDt = regDt;
		this.role = role;
	}

	
	 
}
