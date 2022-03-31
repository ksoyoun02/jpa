package com.example.demo.dto.calender.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본생성자
@Getter
@Entity
@ToString
@Table(name = "calender")
@SequenceGenerator(
	name="CALENDER_SEQ_GENERATOR", //시퀀스 제너레이터 이름
	sequenceName="CALENDER_SEQ", //시퀀스 이름
	initialValue=1, //시작값
	allocationSize=1 //메모리를 통해 할당할 범위 사이즈
)
public class CalEntity {
	
    @Id
    @GeneratedValue(
	    strategy=GenerationType.SEQUENCE, //사용할 전략을 시퀀스로  선택
	    generator="CALENDER_SEQ_GENERATOR" //식별자 생성기를 설정해놓은  USER_SEQ_GEN으로 설정        
    )
	private long seq;
    
    @Column
    private String id;
    
    @Column
	private String title;
    
    @Column
	private String detail;
    
    @Column(name = "reg_dt")
	private LocalDateTime regDt;
    
    @Column(name = "update_dt")
	private LocalDateTime updateDt;

    @Builder
	public CalEntity(long seq, String id, String title, String detail, LocalDateTime regDt, LocalDateTime updateDt) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.detail = detail;
		this.regDt = regDt;
		this.updateDt = updateDt;
	}
	

	
	
}
