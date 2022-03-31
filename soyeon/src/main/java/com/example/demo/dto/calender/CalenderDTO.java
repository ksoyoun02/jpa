package com.example.demo.dto.calender;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalenderDTO {
	
	private long seq;
	private String id;
	private String title;
	private String detail;
	private LocalDateTime regDt;
	private LocalDateTime updateDt;
}
