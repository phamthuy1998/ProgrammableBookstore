package phamthuy.ptithcm.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SendEmailController {
	@Autowired
	JavaMailSender mailer;
	@RequestMapping("sendmail1")
	public String sendMail1(){
		return "sendmail";
	}


	@RequestMapping("sendmail")
	public String sendMail(ModelMap model, @RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("subject") String subject, @RequestParam("body") String body) {
		try {
			// Tạo mail
			System.out.println("vô đay 1");
			MimeMessage mail = mailer.createMimeMessage();
			// Sử dụng lớp trợ giúp
			System.out.println("vô đay 2");
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			System.out.println("from"+from);
			System.out.println("from"+to);
			System.out.println("from"+subject);
			System.out.println("from"+body);
			helper.setFrom(from, from);
			helper.setTo(to);
			helper.setReplyTo(from, from);
			helper.setSubject(subject);
			helper.setText(body, true);

			// gửi mail
			mailer.send(mail);
			
			model.addAttribute("message", "Gửi email thành công !");
		} catch (Exception ex) {
			model.addAttribute("message", "Gửi email thất bại !");
		}
		return "sendmail";
	}
}
