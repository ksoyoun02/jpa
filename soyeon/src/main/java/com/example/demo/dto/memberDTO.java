package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name="member")

/*@SequenceGenerator(name = "MEMBER_SEQ_GENERATOR",
sequenceName = "MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름
initialValue = 1,
allocationSize = 1) */
public class memberDTO {
	
	/*seq로 pk잡고싶을때 사용
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
		generator = "MEMBER_SEQ_GENERATOR")
	private int member_seq;
	*/	
	
	//@ID -> pk설정
	@Id
	private String id;
	
	//@Column(" ") -> column명과 다르게 mapping 가능
	@Column
	private String pwd;
	
	@Column
	private String name;
}
