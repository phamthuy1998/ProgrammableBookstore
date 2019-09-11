package phamthuy.ptithcm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import phamthuy.ptithcm.dao.AuthorDao;
import phamthuy.ptithcm.model.Author;

@Controller
public class AuthorController {

	private AuthorDao authorDao = new AuthorDao();

	// show list author
	@RequestMapping("admin/authors")
	public String index(Model model) {
		model.addAttribute("list", authorDao.getAllAuthor());
		return "author/list";
	}

	// Insert author
	@RequestMapping("admin/author/add.htm")
	public String add() {
		return "author/add";
	}

	@RequestMapping(value = "admin/author/add.htm", method = RequestMethod.POST)
	public String addPost(Author author) {
		// if insert success, then return back to admin/authors.htm page
		if (authorDao.insert(author) == 1) {
			return "redirect:/admin/authors.htm";
		}
		// if not, still be there
		return "author/add";
	}

	// Del author
	@RequestMapping("admin/author/del/{id}")
	public String delete(@PathVariable("id") int id) {
		System.out.println("vo del");
		authorDao.delete(id);
		return "redirect:/admin/authors.htm";
	}

	@RequestMapping(value = "admin/author/dels.htm", method = RequestMethod.POST)
	public String delete(HttpServletRequest request, ModelMap model) {
		String arrAuthorID[] = request.getParameterValues("authorIds");
		try {
			if (arrAuthorID.length != 0) {
				for (String id : arrAuthorID) {
					authorDao.delete(Integer.parseInt(id));
				}
				model.addAttribute("list", authorDao.getAllAuthor());
			}
			return "redirect:/admin/authors.htm";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			model.addAttribute("list", authorDao.getAllAuthor());
			return "redirect:/admin/authors.htm";
		}

	}

	// Edit author
	@RequestMapping("admin/author/edit/{id}")
	public String edit(Model model, @PathVariable("id") int id) {
		System.out.println("vô đây hk á");
		model.addAttribute("o", authorDao.getAuthor(id));
		return "author/edit";
	}

	@RequestMapping(value = "admin/author/edit/{id}", method = RequestMethod.POST)
	public String edit(Model model, Author obj, @PathVariable("id") int id) {
		System.out.println("vô đây hk ta");
		authorDao.edit(obj);

		return "redirect:/admin/authors.htm";
	}
}
