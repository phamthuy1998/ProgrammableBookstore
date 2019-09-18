package phamthuy.ptithcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import phamthuy.ptithcm.model.MailInfo;

@Controller
public class SendEmailController {
	
	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping("sendmail")
	public String index() {
		return "sendmail";
	}

	@RequestMapping(value = "sendmail", method = RequestMethod.POST)
	public String index(@Validated @ModelAttribute("obj") MailInfo obj) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(obj.getEmail());
		message.setSubject(obj.getSubject());
		message.setText(obj.getSubject());
		mailSender.send(message);
		return "sendmail";
	}
}
