package phamthuy.ptithcm.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import phamthuy.ptithcm.dao.CartDao;
import phamthuy.ptithcm.dao.InvoiceDao;
import phamthuy.ptithcm.model.Invoice;

@Transactional
@Controller
@RequestMapping("cart")
public class InvoiceController {

	InvoiceDao invoiceDao = new InvoiceDao();
	CartDao cartDao = new CartDao();

	@RequestMapping(value = "checkout")
	public String checkout(Model model, HttpServletRequest request) {
		// get user's infor from cookie
		String userID = null, role = null;
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("userID")) {
				userID = cookie.getValue();
			}
			if (cookie.getName().equals("userRole")) {
				role = cookie.getValue();
			}
		}

		if (userID != null) {
			// admin
			if (Integer.parseInt(role) == 1) {
				return "redirect:/home/products/1.htm";
			}
			// Member
			else if (Integer.parseInt(role) == 2) {
				model.addAttribute("invoice", new Invoice());
				return "cart/checkout";
			}
			// employee
			else if (Integer.parseInt(role) == 3) {
				return "redirect:/home/products/1.htm";
			}
			// not login
			else {
				return "redirect:/user/login.htm";
			}
		}
		// not login
		else {
			return "redirect:/user/login.htm";
		}
	}

	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public String checkout(Model model, @ModelAttribute("invoice") Invoice invoice, BindingResult errors) {
		System.out.println("voo daay nef");
		System.out.println("voo emami" + invoice.getEmail());
		System.out.println("voo daay address" + invoice.getTel());
		System.out.println("voo daay tel" + invoice.getAddress());
		if (invoice != null) {
			System.out.println("co khac rong ");
			if (invoice.getEmail().trim().equals("")) {
				errors.rejectValue("email", "invoice", "Vui lòng nhập email");
			}
			if (invoice.getTel().trim().equals("")) {
				errors.rejectValue("tel", "invoice", "Vui lòng nhập số điện thoại");
			}
			if (invoice.getAddress().trim().equals("")) {
				errors.rejectValue("address", "invoice", "Vui lòng nhập address");
			}
			if (!invoice.getEmail().trim().equals("") && !invoice.getTel().trim().equals("")
					&& !invoice.getAddress().trim().equals("")) {

				System.out.println();
				// System.out.println("member id: " +
				// MemberController.memberLoginForm.getId());
				// if (MemberController.memberLoginForm != null) {
				invoice.setMemberId(1);
				// }
				invoiceDao.add(invoice);
				return "redirect:/cart/index.htm";
			}

		} else {
			System.out.println("cart rong");
		}
		return "cart/checkout";
	}
}
