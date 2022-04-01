package com.example.demo.controller.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.calender.entity.CalEntity;

public interface CalenderRepository extends JpaRepository<CalEntity, Long>{
	 List<CalEntity> findAllById(String id);
}
