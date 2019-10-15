package phamthuy.ptithcm.controller;

import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import phamthuy.ptit.helper.Helper;
import phamthuy.ptithcm.dao.MemberDao;
import phamthuy.ptithcm.model.Invoice;
import phamthuy.ptithcm.model.Member;
import phamthuy.ptithcm.model.Role;

@Transactional
@Controller
public class MemberController {
	@Autowired
	JavaMailSender mailer;

	MemberDao memberDao = new MemberDao();
	public static Role roleLoginForm;
	public static Member memberLoginForm;

	// show list author
	@RequestMapping("admin/users")
	public String index(Model model) {
		model.addAttribute("list", memberDao.getAllMember());
		return "member/list";
	}

	@RequestMapping(value = "user/register")
	public String register(Model model) {
		model.addAttribute("member", new Member());
		return "member/register";
	}

	@RequestMapping(value = "user/register", method = RequestMethod.POST)
	public String register(Model model, @ModelAttribute("member") Member member, BindingResult errors) {

		if (member.getUsername().trim().equals("")) {
			System.out.println("user name rong");
			errors.rejectValue("username", "member", "Vui lòng nhập username!");
		}

		if (member.getEmail().trim().equals("")) {
			System.out.println("mail name rong");
			errors.rejectValue("email", "member", "Vui lòng nhập username!");
		}

		if (member.getPassword().trim().equals("")) {
			System.out.println("pass name rong");
			errors.rejectValue("password", "member", "Vui lòng nhập password!");
		}

		if (member.getTel().trim().equals("")) {
			System.out.println("tel name rong");
			errors.rejectValue("tel", "member", "Vui lòng nhập fullname!");
		}

		if (member != null) {
			if (memberDao.getMemberIDByEmail(member.getEmail()) != -1) {

			} else {
				memberDao.add(member);
				return "redirect:/user/login.htm";
			}
		}

		return "redirect:/user/register.htm";
	}

	@RequestMapping("user/login")
	public String showLogin() {
		return "member/login";
	}

	@RequestMapping(value = "user/login", method = RequestMethod.POST)
	public String login(ModelMap model, @ModelAttribute("member") Member member, BindingResult errors) {

		if (member != null) {
			System.out.println("email: " + member.getEmail());
			System.out.println("passs: " + member.getPassword());
			if (member.getEmail().trim().equals("")) {
				System.out.println("email login rong");
				errors.rejectValue("email", "member", "Vui lòng nhập username!");
			}

			else if (member.getPassword().trim().equals("")) {
				System.out.println("password login rong");
				errors.rejectValue("password", "member", "Vui lòng nhập password!");
			}
			// login
			else if (memberDao.getMemberIDByEmail(member.getEmail()) != -1
					|| memberDao.getMemberIDByPhone(member.getTel()) != -1) {
				System.out.println("co email pass");
				Member memberLogin = memberDao.login(member.getPassword(), member.getEmail());
				if (memberLogin != null) {
					System.out.println("login thanh cong");
					memberLoginForm = memberLogin;
					Role rolelogin = memberDao.getRoleLogin(memberLogin.getId());
					if (rolelogin != null) {
						roleLoginForm = rolelogin;
						return "redirect:/admin/authors.htm";
					}
				} else {
					System.out.println("dang nhap that bai");
					return "redirect:/user/login.htm";
				}

			}
			// email password k ton tai
			else {
				return "redirect:/user/login.htm";
			}
		}

		return "redirect:/user/login.htm";
	}

	@RequestMapping("user/forgot")
	public String showForgot() {
		return "member/forgot";
	}

	@RequestMapping(value = "user/forgot", method = RequestMethod.POST)
	public String resetPassWord(ModelMap model, @ModelAttribute("email") String email, BindingResult errors) {
		if (email.trim().equals("")) {
			System.out.println("mail forgot rong");
		} else {
			System.out.println("mail forgot :" + email);
			try { // Tạo mail
				MimeMessage mail = mailer.createMimeMessage(); // Sử
				// dụng lớp trợ giúp
				MimeMessageHelper helper = new MimeMessageHelper(mail);
				helper.setFrom("congnghephanmemptithcm@gmail.com", "Nhóm tài khoản lấy lại mật khẩu Bookstore");
				helper.setTo(email);
				helper.setReplyTo("congnghephanmemptithcm@gmail.com", "congnghephanmemptithcm@gmail.com");
				helper.setSubject("RESET PASSWORD - Booksttore");
				String password = Helper.randomPassword();
				helper.setText("Mật khẩu của bạn sẽ được đổi thành: " + password + ".\n Trân trọng", true);

				// Gửi mail
				mailer.send(mail);
				if (memberDao.updatePassword(password, email) > 0) {
					model.addAttribute("message", "dat mat khau thanh cong !");
				} else {
					model.addAttribute("message", "dat mat khau that bai!");
				}
			} catch (Exception ex) {
				model.addAttribute("message", "Gửi email thất bại !");
			}
		}

		return "redirect:/user/login.htm";
	}

}
