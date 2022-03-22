package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.controller.impl.MemberService;
import com.example.demo.controller.impl.MemberDao;
import com.example.demo.dto.Member;
import com.example.demo.dto.MemberDTO;

@Controller
public class JoinController {
	
	@Autowired
	MemberDao mDao;
	
	@Autowired 
	MemberService mService;
	
	@GetMapping("/signup")
	public String index(Model model, Member member){
		model.addAttribute("text", "JoinPage");
		model.addAttribute("member", member);
		
		return "join";
	}

	 @ResponseBody
	 @RequestMapping(value = "/joinChk", method = RequestMethod.POST)
	 public String joinChk(HttpServletRequest request, Model model, MemberDTO mDto) {
		mService.save(mDto);
		return "redirect:/login";
		 /*
		 String resultMsg = "";
		 Optional<Member> user = mDao.findById(member.getId());
		if(user.isPresent() == false) {
			mDao.save(member);
			resultMsg = "<script>alert('회원가입성공');location.href = '/main';</script>";
		}else {
			model.addAttribute("member",member);
			resultMsg = "<script>alert('이미 존재하는 아이디입니다.');location.href = '/login';</script>";
			return resultMsg;
		}
		return resultMsg;
		*/
	 }   
	 
 /*	@PreAuthorize("hasRole('ROLE_MEMBER')")
    @GetMapping("/member/info")
    public String userInfoView() {
        return "pages/user_info";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String adminView() {
        return "pages/admin";
    }

    @GetMapping("/denied")
    public String deniedView() {
        return "pages/denied";
    }
    */
}
