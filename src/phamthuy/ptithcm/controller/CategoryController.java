package phamthuy.ptithcm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import phamthuy.ptithcm.dao.CategoryDao;
import phamthuy.ptithcm.model.Category;

@Controller
public class CategoryController {
	CategoryDao categoryDao = new CategoryDao();

	// show list category
	@RequestMapping("admin/categories")
	public String index(Model model) {
		model.addAttribute("list", categoryDao.getAllCategory());
		return "category/list";
	}

	@RequestMapping("admin/category/add")
	public String add(Model model) {
		// get all category
		List<Category> list = categoryDao.getAllCategory();
		Map<Integer, String> map = new HashMap<>();
		for (Category item : list) {
			map.put(item.getId(), item.getName());
		}
		model.addAttribute("map", map);
		model.addAttribute("obj", new Category());
		return "category/add";
	}

	@RequestMapping(value = "admin/category/add", method = RequestMethod.POST)
	public String add(Model model, @ModelAttribute("obj") Category obj, BindingResult errors) {
		if (obj.getName().equals("")) {
			errors.rejectValue("name", "obj", "Vui lòng nhập tên sách!");

		} else {
			categoryDao.add(obj);
			return "redirect:/admin/categories.htm";
		}
		return "category/add";
	}

	@RequestMapping("admin/category/edit/{id}")
	public String edit(Model model, @PathVariable("id") int id) {
		List<Category> list = categoryDao.getAllCategory();
		Map<Integer, String> map = new HashMap<>();
		for (Category item : list) {
			map.put(item.getId(), item.getName());
		}
		model.addAttribute("map", map);
		model.addAttribute("obj", categoryDao.getCategory(id));
		return "category/edit";
	}

	@RequestMapping(value = "admin/category/edit/{id}", method = RequestMethod.POST)
	public String edit(Model model, @ModelAttribute("obj") Category obj, BindingResult errors) {
		if (obj.getName().equals("")) {
			errors.rejectValue("name", "obj", "Vui lòng nhập tên sách!");

		} else {
			categoryDao.edit(obj);
			return "redirect:/admin/categories.htm";
		}
		return "category/edit";
	}

	// Del category
	@RequestMapping("admin/category/del/{id}")
	public String delete(@PathVariable("id") int id) {
		System.out.println("vo del");
		categoryDao.delete(id);
		return "redirect:/admin/categories.htm";
	}

	@RequestMapping(value = "admin/category/dels.htm", method = RequestMethod.POST)
	public String delete(HttpServletRequest request, ModelMap model) {
		String arrCategoryID[] = request.getParameterValues("categoryIds");
		try {
			if (arrCategoryID.length != 0) {
				for (String id : arrCategoryID) {
					categoryDao.delete(Integer.parseInt(id));
				}
				model.addAttribute("list", categoryDao.getAllCategory());
			}
			return "redirect:/admin/categories.htm";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			model.addAttribute("list", categoryDao.getAllCategory());
			return "redirect:/admin/categories.htm";
		}

	}
}
