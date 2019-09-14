package phamthuy.ptithcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import phamthuy.ptithcm.dao.ProductDao;
import phamthuy.ptithcm.model.Product;

@Controller
public class ProductController {

	ProductDao productDao = new ProductDao();
	private static int size = 6;

	@RequestMapping(value = {"home/products", "home/products/{p}" })
	public String index(Model model, @PathVariable(value = "p", required = false) Integer page) {
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
}
