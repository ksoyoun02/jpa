package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String index(Model model){
		return "/index";
	}
	
	@GetMapping("/signup")
	public String signup(Model model){
		return "/join";
	}
	
	@GetMapping("/login")
	public String login(Model model){
		return "/login";
	}
	
	//@PreAuthorize -> 권한별로 접근 통제
	@PreAuthorize("hasRole('ROLE_MEMBER')")
    @GetMapping("/member/mem_info")
    public String mem_info() {
        return "/member/mem_info";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin/admin_info")
    public String admin_info() {
        return "/admin/admin_info";
    }

    @GetMapping("/denied")
    public String deniedView() {
        return "/denied";
    }
}
