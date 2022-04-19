package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.controller.dao.BoardRepository;
import com.example.demo.dto.board.entity.BoardEntity;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Autowired
	BoardRepository boardRepository;
	
	@GetMapping("/boardList")
	public String boardList(HttpServletRequest request, Model model) {
		
		/*
		BoardEntity board = BoardEntity.builder()
				.id("qw")
				.boardTitle("test1")
				.boardContent("test content1")
				.boardTitle("1234")
				.boardHitCnt(0)
				.build();
		
		boardRepository.save(board);
		
		*/
		List<BoardEntity> boardList = boardRepository.findAll();
		System.out.println(boardList);
		model.addAttribute("boardList", boardList);
		return "board/boardList";
	}
	
	@GetMapping("/addBoard")
	public @ResponseBody String addBoard(Authentication authentication, Model model) {
		
		String id = authentication.getName();
		System.out.println("============================");
		System.out.println(id);
		return id;
	}
}
