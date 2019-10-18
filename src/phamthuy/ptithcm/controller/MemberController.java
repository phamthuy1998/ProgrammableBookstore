package phamthuy.ptithcm.controller;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import phamthuy.ptit.helper.Helper;
import phamthuy.ptithcm.dao.MemberDao;
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

	// Del author
	@RequestMapping("admin/user/del/{id}")
	public String delete(@PathVariable("id") int id) {
		System.out.println("vo del");
		memberDao.delete(id);
		return "redirect:/admin/users.htm";
	}

	@RequestMapping(value = "admin/user/dels.htm", method = RequestMethod.POST)
	public String delete(HttpServletRequest request, ModelMap model) {
		String arrAuthorID[] = request.getParameterValues("authorIds");
		try {
			if (arrAuthorID.length != 0) {
				for (String id : arrAuthorID) {
					memberDao.delete(Integer.parseInt(id));
				}
				model.addAttribute("list", memberDao.getAllMember());
			}
			return "redirect:/admin/users.htm";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			model.addAttribute("list", memberDao.getAllMember());
			return "redirect:/admin/users.htm";
		}
	}

	// Insert author
	@RequestMapping("admin/user/add")
	public String add(Model model) {
		model.addAttribute("member", new Member());
		return "member/add"; 
	}
	

	@RequestMapping(value = "admin/user/add", method = RequestMethod.POST)
	public String addMember(Model model, @ModelAttribute("member") Member member, BindingResult errors) {
		if (member.getUsername().trim().equals("")) {
			System.out.println("user name rong");
			errors.rejectValue("username", "member", "Vui lòng nhập tên người dùng!");
		}

		if (member.getEmail().trim().equals("")) {
			System.out.println("mail name rong");
			errors.rejectValue("email", "member", "Vui lòng nhập email!");
		} else if (memberDao.getMemberIDByEmail(member.getEmail()) != -1) {
			errors.rejectValue("email", "member", "Email đã tồn tại!");
		} else if (Helper.checkEmail(member.getEmail().trim()) == false) {
			errors.rejectValue("email", "member", "Email không hợp lệ!");
		}

		if (member.getPassword().trim().equals("")) {
			System.out.println("pass name rong");
			errors.rejectValue("password", "member", "Vui lòng nhập password!");
		}

		if (member.getTel().trim().equals("")) {
			System.out.println("tel name rong");
			errors.rejectValue("tel", "member", "Vui lòng nhập số điện thoại!");
		} else if (memberDao.getMemberIDByPhone(member.getTel()) != -1) {
			errors.rejectValue("tel", "member", "Số điện thoại đã tồn tại!");
		} else if (Helper.isValidPhone(member.getTel().trim()) == false) {
			errors.rejectValue("tel", "member", "Số điện thoại không hợp lệ!");
		}

		if (Helper.checkEmail(member.getEmail().trim()) == false
				|| memberDao.getMemberIDByEmail(member.getEmail()) != -1
				|| Helper.isValidPhone(member.getTel().trim()) == false
				|| memberDao.getMemberIDByPhone(member.getTel()) != -1 || member.getTel().trim().equals("")
				|| member.getPassword().trim().equals("") || member.getEmail().trim().equals("")
				|| member.getUsername().trim().equals("")) {
			return "member/add";
		} else {
			memberDao.addEmployee(member);
			return "member/add";
		}
	}

	// Edit author
	@RequestMapping(value = "admin/user/edit/{id}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable("id") int id) {
		System.out.println("vô edit tren");
		model.addAttribute("member", memberDao.getMember(id));
		System.out.println("add attribute rooif");
		return "member/edit";
	}

	@RequestMapping(value = "admin/user/edit", method = RequestMethod.POST)
	public String edit(Model model, @ModelAttribute("member") Member member, BindingResult errors) {
		if (member.getUsername().trim().equals("")) {
			System.out.println("user name rong");
			errors.rejectValue("username", "member", "Vui lòng nhập tên người dùng!");
		}

		if (member.getEmail().trim().equals("")) {
			System.out.println("mail name rong");
			errors.rejectValue("email", "member", "Vui lòng nhập email!");
		}
		// mail da ton tai
		else if (memberDao.getMemberIDByEmail(member.getEmail()) > 1) {
			errors.rejectValue("email", "member", "Email đã tồn tại!");
		}
		// mail k hop le
		else if (Helper.checkEmail(member.getEmail().trim()) == false) {
			errors.rejectValue("email", "member", "Email không hợp lệ!");
		}

		if (member.getPassword().trim().equals("")) {
			System.out.println("pass name rong");
			errors.rejectValue("password", "member", "Vui lòng nhập password!");
		}

		if (member.getTel().trim().equals("")) {
			System.out.println("tel name rong");
			errors.rejectValue("tel", "member", "Vui lòng nhập số điện thoại!");
		}
		// so dt da ton tai
		else if (memberDao.getMemberIDByPhone(member.getTel()) > 1) {
			errors.rejectValue("tel", "member", "Số điện thoại đã tồn tại!");
		}
		// so dt k hop le
		else if (Helper.isValidPhone(member.getTel().trim()) == false) {
			errors.rejectValue("tel", "member", "Số điện thoại không hợp lệ!");
		}

		//
		if (memberDao.getMemberIDByEmail(member.getEmail()) > 1 || memberDao.getMemberIDByPhone(member.getTel()) > 1
				|| member.getTel().trim().equals("") || member.getPassword().trim().equals("")
				|| member.getEmail().trim().equals("") || member.getUsername().trim().equals("")) {
			return "member/edit";

		} else {
			memberDao.edit(member);
			return "redirect:/admin/users.htm";
		}
	}

	@RequestMapping(value = "user/register")
	public String register(Model model) {
		model.addAttribute("member", new Member());
		return "member/register";
	}

	@RequestMapping(value = "user/register", method = RequestMethod.POST)
	public String register(Model model, @ModelAttribute("member") Member member, BindingResult errors) {
		ResourceBundle labels = ResourceBundle.getBundle("login",LocaleContextHolder.getLocale());// );
		
		if (member.getUsername().trim().equals("")) {
			errors.rejectValue("username", "member", labels.getString("label.errNoName"));
		}

		if (member.getEmail().trim().equals("")) {
			errors.rejectValue("email", "member", "Vui lòng nhập email!");
		} else if (memberDao.getMemberIDByEmail(member.getEmail()) != -1) {
			errors.rejectValue("email", "member", "Email đã tồn tại");
		} else if (Helper.checkEmail(member.getEmail().trim()) == false) {
			errors.rejectValue("email", "member", "Email không hợp lệ!");
		} 

		if (member.getPassword().trim().equals("")) {
			errors.rejectValue("password", "member", "Vui lòng nhập mật khẩu!");
		} else if (Helper.checkPassword(member.getPassword().trim()) == false) {
			errors.rejectValue("password", "member", "Mật khẩu không hợp lệ, mật khẩu chỉ gồm a-z, A-Z, 0-9!");
		}

		if (member.getTel().trim().equals("")) {
			errors.rejectValue("tel", "member", "Vui lòng nhập số điện thoại!");
		} else if (memberDao.getMemberIDByPhone(member.getTel()) != -1) {
			errors.rejectValue("tel", "member", "Số điện thoại đã tồn tại!");
		} else if (Helper.isValidPhone(member.getTel().trim()) == false) {
			errors.rejectValue("tel", "member", "Số điện thoại không hợp lệ");
		}

		if (Helper.isValidPhone(member.getTel().trim()) == false || Helper.checkEmail(member.getEmail().trim()) == false
				|| memberDao.getMemberIDByEmail(member.getTel()) != -1
				|| memberDao.getMemberIDByEmail(member.getEmail()) != -1 || member.getTel().trim().equals("")
				|| member.getPassword().trim().equals("") || member.getEmail().trim().equals("")
				|| member.getUsername().trim().equals("")) {
			return "member/register";
		} else {
			memberDao.add(member);
			return "redirect:/user/login.htm";
		}
	}

	@RequestMapping(value = "user/login", method = RequestMethod.GET)
	public String showLogin(ModelMap model) {
		model.addAttribute("member", new Member());
		return "member/login";
	}

	@RequestMapping(value = "user/login", method = RequestMethod.POST)
	public String login(ModelMap model, @ModelAttribute("member") Member member, BindingResult errors) {

		System.out.println("email: " + member.getEmail());
		System.out.println("passs: " + member.getPassword());
		if (member.getEmail().trim().equals("")) {
			System.out.println("email login rong");
			errors.rejectValue("email", "member", "Vui lòng nhập email!");
		} else if (Helper.checkEmail(member.getEmail().trim()) == false) {
			errors.rejectValue("email", "member", "Email không hợp lệ!");
		}

		if (member.getPassword().trim().equals("")) {
			System.out.println("password login rong");
			errors.rejectValue("password", "member", "Vui lòng nhập password!");
		}
		// login
		if (Helper.checkEmail(member.getEmail().trim()) == false || member.getEmail().trim().equals("")
				|| member.getPassword().trim().equals("")) {
			return "member/login";
		} else {
			if (memberDao.getMemberIDByEmail(member.getEmail()) != -1
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
					errors.rejectValue("password", "member", "Mật khẩu không đúng!");
				}

			}
			// email password k ton tai
			else {
				errors.rejectValue("email", "member", "Email   không tồn tại trong hệ thống!");
			}
		}

		return "member/login";
	}

	@RequestMapping("user/forgot")
	public String showForgot(ModelMap model) {
		model.addAttribute("member", new Member());
		return "member/forgot";
	}

	@RequestMapping(value = "user/forgot", method = RequestMethod.POST)
	public String resetPassWord(ModelMap model, @ModelAttribute("member") Member member, BindingResult errors) {
		if (member.getEmail().trim().equals("")) {
			System.out.println("mail forgot rong");
			errors.rejectValue("email", "member", "Vui lòng nhập email!");
		} else if (Helper.checkEmail(member.getEmail().trim()) == false) {
			errors.rejectValue("email", "member", "Email không hợp lệ!");
		} else if (memberDao.getMemberIDByEmail(member.getEmail()) == -1) {
			errors.rejectValue("email", "member", "Email chưa tạo tài khoản trong hệ thống");
		} else {
			System.out.println("mail forgot :" + member.getEmail());
			try { // Tạo mail
				MimeMessage mail = mailer.createMimeMessage(); // Sử
				// dụng lớp trợ giúp
				MimeMessageHelper helper = new MimeMessageHelper(mail);
				helper.setFrom("congnghephanmemptithcm@gmail.com", "Nhóm tài khoản lấy lại mật khẩu Bookstore");
				helper.setTo(member.getEmail());
				helper.setReplyTo("congnghephanmemptithcm@gmail.com", "congnghephanmemptithcm@gmail.com");
				helper.setSubject("RESET PASSWORD - Booksttore");
				String password = Helper.randomPassword();
				helper.setText("Mật khẩu của bạn sẽ được đổi thành: " + password + ".\n Trân trọng", true);

				// Gửi mail
				mailer.send(mail);
				if (memberDao.updatePassword(password, member.getEmail()) > 0) {
					model.addAttribute("message", "dat mat khau thanh cong !");
					return "redirect:/user/login.htm";
				} else {
					model.addAttribute("message", "dat mat khau that bai!");
				}
			} catch (Exception ex) {
				model.addAttribute("message", "Gửi email thất bại !");
			}
		}
		return "member/forgot";

	}

}
