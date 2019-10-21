package phamthuy.ptithcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home/")
public class HomeController {
	@RequestMapping("index")
	public String index() {
		return "admin/index";
	}

	@RequestMapping("about")
	public String about() {
		return "admin/about";
	}

	@RequestMapping("contact")
	public String contact() {
		return "admin/contact";
	}
}