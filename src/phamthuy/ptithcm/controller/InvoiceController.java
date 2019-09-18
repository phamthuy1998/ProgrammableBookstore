package phamthuy.ptithcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import phamthuy.ptithcm.dao.CartDao;
import phamthuy.ptithcm.dao.InvoiceDao;
import phamthuy.ptithcm.model.Invoice;

@Controller
@RequestMapping("/cart/")
public class InvoiceController {

	InvoiceDao invoiceDao = new InvoiceDao();
	CartDao cartDao = new CartDao();

	@RequestMapping("checkout")
	public String checkout(Model model, @CookieValue("cart") String id) {
		model.addAttribute("title", "Check Out");
		model.addAttribute("list", cartDao.getCarts(id));
		return "cart/checkout";
	}

	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public String checkout(Model model, Invoice invoice, @CookieValue("cart") String id) {
		
		invoice.setId(id);
		invoiceDao.add(invoice);
		return "redirect:/order/detail/" + invoice.getId();
	}
}
