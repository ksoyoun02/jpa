package com.example.demo.controller.impl;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.memberDTO;

public interface Member_i extends JpaRepository<memberDTO, String>{
	Optional<memberDTO> findOne(String id);
}
