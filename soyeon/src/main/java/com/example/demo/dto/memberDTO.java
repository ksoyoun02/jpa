package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Entity(name="member")
@Table(name="member")
public class memberDTO {
	
	//@ID -> pk설정
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	//@Column(" ") -> column명과 다르게 mapping 가능
	@Column
	private String pwd;
	
	@Column
	private String name;
}
