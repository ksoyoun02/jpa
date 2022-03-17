package com.example.demo.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.memberDTO;

public interface Member_i extends JpaRepository<memberDTO, String>{

	List<memberDTO> findAllById(String memberID);

}
