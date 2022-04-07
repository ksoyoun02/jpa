package com.example.demo.dto.calendar;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalendarDTO {
	
	private int seq;
	private String id;
	private String title;
	private String detail;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime startDt;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime endDt;
	
	private LocalDateTime regDt;
	private LocalDateTime updateDt;
}
