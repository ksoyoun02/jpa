package com.example.demo.dto.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.demo.dto.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "board_file")
@NoArgsConstructor
@Getter
@SequenceGenerator(
		name="BOARD_FILE_SEQ_GENERATOR", //시퀀스 제너레이터 이름
		sequenceName="BOARD_FILE_SEQ", //시퀀스 이름
		initialValue=1, //시작값
		allocationSize=1 //메모리를 통해 할당할 범위 사이즈
	)
public class BoardFileEntity extends BaseTimeEntity{

	@Id
    @GeneratedValue(
	    strategy=GenerationType.SEQUENCE, //사용할 전략을 시퀀스로  선택
	    generator="BOARD_FILE_SEQ_GENERATOR" //식별자 생성기를 설정해놓은  USER_SEQ_GEN으로 설정        
    )
	private int seq;
    
	@Column(name = "original_File_Name")
	private String originalFileName;
	
	@Column(name = "stored_File_Path")
	private String storedFilePath;
	
	@Column(name = "file_Size")
	private long fileSize;
	
	private String id;
}
