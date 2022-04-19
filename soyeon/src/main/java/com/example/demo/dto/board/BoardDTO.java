package com.example.demo.dto.board;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
	private int seq;
	private String id;
	private String boardTitle;
	private String boardContent;
	private int boardHitCnt;
	private LocalDateTime regDt;
	private LocalDateTime updateDt;
}
