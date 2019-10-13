package phamthuy.ptithcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import phamthuy.ptithcm.dao.MemberDao;
import phamthuy.ptithcm.model.Member;

@Controller
public class MemberController {
	MemberDao memberDao = new MemberDao();

	@RequestMapping("user/register")
	public String showRegister() {
		return "member/register";
	}

	@RequestMapping(value = "user/register", method = RequestMethod.POST)
	public String register(Member member) {

		if (member != null) {
			if (memberDao.getMemberIDByEmail(member.getEmail()) != -1) {
				
			} else
				memberDao.add(member);
		}

		return "redirect:/user/register.htm";
	}

	@RequestMapping("user/login")
	public String showLogin() {
		return "member/login";
	}

	@RequestMapping("user/forgot")
	public String showForgot() {
		return "member/forgot";
	}

}
