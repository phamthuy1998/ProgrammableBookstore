package phamthuy.ptithcm.controller;

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
	public String checkout(Model model) {
		System.out.println("vo check cart");
		if (MemberController.memberLoginForm != null) {
			if (MemberController.memberLoginForm.getId() != 0) {
				//model.addAttribute("list", cartDao.getCarts(MemberController.memberLoginForm.getId()));
				model.addAttribute("invoice", new Invoice());
			} else {
				return "redirect:/user/login.htm";
			}
		} else {
			return "redirect:/user/login.htm";
		}

		return "cart/checkout";
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
