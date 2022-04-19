package com.example.demo.controller.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.board.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{

}
