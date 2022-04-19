package com.example.demo.dto.board.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.example.demo.dto.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DynamicUpdate
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본생성자
@Getter
@Entity
@Table(name = "board")
@SequenceGenerator(
	name="BOARD_SEQ_GENERATOR", //시퀀스 제너레이터 이름
	sequenceName="BOARD_SEQ", //시퀀스 이름
	initialValue=1, //시작값
	allocationSize=1 //메모리를 통해 할당할 범위 사이즈
)
public class BoardEntity extends BaseTimeEntity{

	@Id
    @GeneratedValue(
	    strategy=GenerationType.SEQUENCE, //사용할 전략을 시퀀스로  선택
	    generator="BOARD_SEQ_GENERATOR" //식별자 생성기를 설정해놓은  USER_SEQ_GEN으로 설정        
    )
	private int seq;
    
    @Column
    private String id;
    
    @Column(name = "board_title")
	private String boardTitle; 
    
    @Column(name = "board_content")
    private String boardContent;
    
    @Column(name = "board_pwd")
    private String boardPwd;
    
    @Column(name = "board_hit_cnt")
    private int boardHitCnt;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="seq")
    private Collection<BoardEntity> fileList;
   
    @Builder
	public BoardEntity(int seq, String id, String boardTitle, String boardContent, String boardPwd, int boardHitCnt,
			Collection<BoardEntity> fileList) {
		super();
		this.seq = seq;
		this.id = id;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardPwd = boardPwd;
		this.boardHitCnt = boardHitCnt;
		this.fileList = fileList;
	}
    
}
