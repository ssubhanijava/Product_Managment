package com.mar.wfh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mar.wfh.modal.Category;
import com.mar.wfh.services.CategoryService;

@Controller
@RequestMapping("/cat")
public class CategoryController {

	@Autowired
	private CategoryService categoryServ;

	@RequestMapping("/category")
	public String home(Category category) {
		return "add-category";

	}

	@RequestMapping("/add")
	public String addCategory(@ModelAttribute Category category) {

		categoryServ.registerCategory(category);
		return "redirect:list-category";

	}

	@RequestMapping("/list-category")
	public String showUpdateForm(Model model) {
		model.addAttribute("categorys", categoryServ.findAll());
		return "/list-category";
	}

	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable("id") long id, Model model) {
		Category category = categoryServ.findById(id);
		categoryServ.delete(category);
		model.addAttribute("categorys", categoryServ.findAll());
		return "/list-category";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Category category = categoryServ.findById(id);
		model.addAttribute("category", category);
		return "update-category"; 
	}

	@PostMapping("update/{id}")
	public String updateStudent(@PathVariable("id") long id, @ModelAttribute("category") Category category, Model model) {

		categoryServ.registerCategory(category);
		model.addAttribute("categorys", categoryServ.findAll());
		return "/list-category";
	}
}
