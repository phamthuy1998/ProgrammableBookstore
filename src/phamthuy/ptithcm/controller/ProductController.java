package phamthuy.ptithcm.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import phamthuy.ptit.helper.Helper;
import phamthuy.ptithcm.dao.ProductDao;
import phamthuy.ptithcm.model.Member;
import phamthuy.ptithcm.model.Product;

@Controller
public class ProductController {

	ProductDao productDao = new ProductDao();
	private static int size = 6;

	@RequestMapping(value = { "home/products", "home/products/{p}" })
	public String index(Model model, @PathVariable(value = "p") Integer page) {

		model.addAttribute("title", "Mini Shop");
		int pageNum = (int) Math.ceil(productDao.count() / (double) size);
		model.addAttribute("pageNum", pageNum);

		if (page == null)
			page = 1;
		// show product from id to id by using page,
		model.addAttribute("list", productDao.getProducts(page, size));
		return "product/index";

	}

	@RequestMapping("home/product/detail/{id}")
	public String detail(Model model, @PathVariable("id") int id) {
		Product product = productDao.getProduct(id);
		model.addAttribute("title", product.getTitle());
		model.addAttribute("o", product);
		return "product/detail";
	}

	@RequestMapping("home/search")
	public String search(Model model, @RequestParam("q") String q) {
		model.addAttribute("title", "Result for " + q);
		model.addAttribute("list", productDao.search(q));
		return "product/search";
	}

	// show list product for admin
	@RequestMapping(value = "admin/products")
	public String listProduct(Model model, HttpServletRequest request, HttpServletResponse response) {// ,
		if (MemberController.memberLoginForm != null) {
			// admin
			if (MemberController.roleLoginForm.getId() == 1 || MemberController.roleLoginForm.getId() == 3) {
				model.addAttribute("list", productDao.getAllProducts());
				return "product/list_admin";
			}
			// Member
			else if (MemberController.roleLoginForm.getId() == 2) {
				return "redirect:/home/products/1.htm";
			} else {
				return "redirect:/user/login.htm";
			}
		} else {
			return "redirect:/user/login.htm";
		}
	}

	// Insert author
	@RequestMapping("admin/product/add")
	public String addProduct(Model model, HttpServletRequest request, HttpServletResponse response) {

		if (MemberController.memberLoginForm != null) {
			// admin
			if (MemberController.roleLoginForm.getId() == 1 || MemberController.roleLoginForm.getId() == 3) {
				model.addAttribute("product", new Product());
				return "product/add";
			}
			// Member
			else if (MemberController.roleLoginForm.getId() == 2) {
				return "redirect:/home/products/1.htm";
			} else {
				return "redirect:/user/login.htm";
			}
		} else {
			return "redirect:/user/login.htm";
		}
	}

	@RequestMapping(value = "admin/product/add", method = RequestMethod.POST)
	public String addProduct(Model model, @ModelAttribute("product") Product product, BindingResult errors) {

		return "";
	}

	// Del product
	@RequestMapping("admin/product/del/{id}")
	public String delete(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) {

		if (MemberController.memberLoginForm != null) {
			// admin
			if (MemberController.roleLoginForm.getId() == 1 || MemberController.roleLoginForm.getId() == 3) {
				System.out.println("vo del");
				productDao.delete(id);
				return "redirect:/admin/products.htm";
			}
			// Member
			else if (MemberController.roleLoginForm.getId() == 2) {
				return "redirect:/home/products/1.htm";
			} else {
				return "redirect:/user/login.htm";
			}

		} else
			return "redirect:/user/login.htm";
	}

	// del list product
	@RequestMapping(value = "admin/product/dels.htm", method = RequestMethod.POST)
	public String delete(HttpServletRequest request, ModelMap model) {

		if (MemberController.memberLoginForm != null) {
			// admin
			if (MemberController.roleLoginForm.getId() == 1 || MemberController.roleLoginForm.getId() == 3) {
				String arrAuthorID[] = request.getParameterValues("productIds");
				try {
					if (arrAuthorID.length != 0) {
						for (String id : arrAuthorID) {
							productDao.delete(Integer.parseInt(id));
						}
						model.addAttribute("list", productDao.getAllProducts());
					}
					return "redirect:/admin/products.htm";
				} catch (Exception e) {
					model.addAttribute("error", e.getMessage());
					model.addAttribute("list", productDao.getAllProducts());
					return "redirect:/admin/products.htm";
				}
			}
			// Member
			else if (MemberController.roleLoginForm.getId() == 2) {
				return "redirect:/home/products/1.htm";
			} else {
				return "redirect:/user/login.htm";
			}

		} else {
			return "redirect:/user/login.htm";
		}
	}

}
