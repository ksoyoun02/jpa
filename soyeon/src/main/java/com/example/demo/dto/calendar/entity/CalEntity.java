package com.example.demo.dto.calendar.entity;

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
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
@Table(name = "calendar")
@SequenceGenerator(
	name="CALENDAR_SEQ_GENERATOR", //시퀀스 제너레이터 이름
	sequenceName="CALENDAR_SEQ", //시퀀스 이름
	initialValue=1, //시작값
	allocationSize=1 //메모리를 통해 할당할 범위 사이즈
)
public class CalEntity {
	
    @Id
    @GeneratedValue(
	    strategy=GenerationType.SEQUENCE, //사용할 전략을 시퀀스로  선택
	    generator="CALENDAR_SEQ_GENERATOR" //식별자 생성기를 설정해놓은  USER_SEQ_GEN으로 설정        
    )
	private int seq;
    
    @Column
    private String id;
    
    @Column
	private String title;
    
    @Column
	private String detail;
    
    @Column(name = "start_dt")
    private LocalDateTime startDt;
    
    @Column(name = "end_dt")
    private LocalDateTime endDt;
    
    @CreatedDate
    @Column(name = "reg_dt")
    private LocalDateTime regDt;
    
    @LastModifiedDate
    @Column(name = "update_dt")
	private LocalDateTime updateDt;

    @Builder
	public CalEntity(int seq, String id, String title, String detail, LocalDateTime startDt, LocalDateTime endDt,
			LocalDateTime regDt, LocalDateTime updateDt) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.detail = detail;
		this.startDt = startDt;
		this.endDt = endDt;
		this.regDt = regDt;
		this.updateDt = updateDt;
	}



	
	
}
