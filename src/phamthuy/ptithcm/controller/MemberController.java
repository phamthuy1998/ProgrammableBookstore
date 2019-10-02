package phamthuy.ptithcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import phamthuy.ptithcm.dao.MemberDao;
import phamthuy.ptithcm.model.Member;

@Controller
public class MemberController {
	MemberDao memberDao;

	@RequestMapping("user/register")
	public String showRegister() {
		return "member/register";
	}

	@RequestMapping(value = "user/register", method = RequestMethod.POST)
	public String register(Member obj) {
		memberDao.add(obj);
		System.out.println("email: " + obj.getEmail());
		return "redirect:/user/register.htm";
	}

}
