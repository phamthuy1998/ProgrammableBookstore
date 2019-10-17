package phamthuy.ptithcm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import phamthuy.ptithcm.dao.CartDao;
import phamthuy.ptithcm.dao.InvoiceDao;
import phamthuy.ptithcm.model.Cart;

@Controller
@RequestMapping("cart")
public class CartController {

	CartDao cartDao = new CartDao();
	InvoiceDao invoiceDao = new InvoiceDao();

	// Del category
	@RequestMapping("del/{productId}")
	public String delete(@PathVariable("productId") int productId, @CookieValue("cart") String id) {
		System.out.println("vo del: " + id);

		cartDao.delete(id, productId);
		return "redirect:/cart/index.htm";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Model model, Cart cart, HttpServletRequest request, HttpServletResponse response) {
		if (MemberController.memberLoginForm != null) {
			if (MemberController.memberLoginForm.getId() != 0) {
				System.out.println("co vo day");

				System.out.println("id product: " + cart.getProductId());
				System.out.println("id quan: " + cart.getQuantity());
				System.out.println("id member: " + cart.getMemberId());
				cart.setMemberId(MemberController.memberLoginForm.getId());
				cartDao.add(cart);
				model.addAttribute("list", cartDao.getCarts(MemberController.memberLoginForm.getId()));
			} else {
				return "redirect:/user/login.htm";
			}
		} else {
			return "redirect:/user/login.htm";
		}

		return "redirect:index.htm";
	}

	@RequestMapping("index")
	public String index(Model model) {
		model.addAttribute("title", "Your Cart");
		System.out.println("goi index");
		if (MemberController.memberLoginForm != null) {
			if (MemberController.memberLoginForm.getId() != 0) {
				model.addAttribute("list", cartDao.getCarts(MemberController.memberLoginForm.getId()));
			} else {
				return "redirect:/user/login.htm";
			}
		} else {
			return "redirect:/user/login.htm";
		}
		return "cart/index";
	}

}
