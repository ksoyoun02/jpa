package com.example.demo.dto.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardFileDTO {

	private int seq;
	private String originalFileName;
	private String storedFilePath;
	private long fileSize;
	private String id;
}
