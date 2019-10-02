package phamthuy.ptithcm.controller;

import java.security.SecureRandom;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import phamthuy.ptit.helper.Helper;
import phamthuy.ptithcm.dao.CartDao;
import phamthuy.ptithcm.dao.InvoiceDao;
import phamthuy.ptithcm.model.Cart;
import phamthuy.ptithcm.model.Invoice;

@Controller
@RequestMapping("cart")
public class CartController {

	CartDao cartDao = new CartDao();
	
	// Del category
		@RequestMapping("del/{productId}")
		public String delete(@PathVariable("productId") int productId,@CookieValue("cart") String id ) {
			System.out.println("vo del: "+id);
			
			cartDao.delete(id, productId);
			return "redirect:/cart/index.htm";
		}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Model model, Cart cart, HttpServletRequest request, HttpServletResponse response) {
		String id = null;
		System.out.println("co vo day");

		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("cart")) {
				id = cookie.getValue();
				System.out.println("khong rong");
			}
		}
		if (id == null || id.equals("")) {
			id = Helper.randomString();
			Cookie cookie = new Cookie("cart", id);
			cookie.setPath(request.getServletContext().getContextPath());
			cookie.setMaxAge(30 * 24 * 3600);
			response.addCookie(cookie);
		}

		cart.setId(id);
		System.out.println("id: " + id);

		System.out.println("id cart: " + cart.getId());

		System.out.println("id product: " + cart.getProductId());
		System.out.println("id quan: " + cart.getQuantity());
		System.out.println("id member: " + cart.getMemberId());
		cartDao.add(cart);

		return "redirect:index.htm";
	}

	@RequestMapping("index")
	public String index(Model model, @CookieValue("cart") String id) {
		model.addAttribute("title", "Your Cart");

		model.addAttribute("list", cartDao.getCarts(id));
		return "cart/index";
	}

}
