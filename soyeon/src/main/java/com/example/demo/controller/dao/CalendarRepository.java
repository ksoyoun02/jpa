package com.example.demo.controller.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.calendar.entity.CalEntity;

public interface CalendarRepository extends JpaRepository<CalEntity, Long>{
	 List<CalEntity> findAllById(String id);
}
