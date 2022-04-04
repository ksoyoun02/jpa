package com.example.demo.dto.calendar;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalendarDTO {
	
	private long seq;
	private String id;
	private String title;
	private String detail;
	private LocalDateTime startDt;
	private LocalDateTime endDt;
	private LocalDateTime regDt;
	private LocalDateTime updateDt;
}
