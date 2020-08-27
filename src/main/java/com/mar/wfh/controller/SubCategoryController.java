package com.mar.wfh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mar.wfh.modal.Category;
import com.mar.wfh.modal.SubCategory;
import com.mar.wfh.services.CategoryService;
import com.mar.wfh.services.SubCategoryService;

@Controller
@RequestMapping("/subcat")
public class SubCategoryController {

	@Autowired
	private SubCategoryService subCategoryService;
	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/subcategory")
	public String home(ModelMap map) {

		List<Category> categories = categoryService.findAll();

		map.addAttribute("categories", categories);
		map.addAttribute("subCategory", new SubCategory());
		return "add-subcategory";

	}

	@RequestMapping("/add")
	public String addCategory(@ModelAttribute SubCategory subCategory) {

		subCategoryService.registerCategory(subCategory);
		return "redirect:list-subcategory";

	}

	@RequestMapping("/list-subcategory")
	public String showUpdateForm(Model model) {
		model.addAttribute("subcategorys", subCategoryService.findAll());
		return "/list-subcategory";
	}

	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable("id") long id, Model model) {
		SubCategory subCategory = subCategoryService.findById(id);
		subCategoryService.delete(subCategory);
		model.addAttribute("subcategorys", subCategoryService.findAll());
		return "/list-subcategory";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		SubCategory subCategory = subCategoryService.findById(id);
		model.addAttribute("subCategory", subCategory);
		return "update-subcategory";
	}

	@PostMapping("update/{id}")
	public String updateStudent(@PathVariable("id") long id, @ModelAttribute("subCategory") SubCategory subCategory,
			Model model) {

		subCategoryService.registerCategory(subCategory);
		model.addAttribute("subcategorys", subCategoryService.findAll());
		return "/list-subcategory";
	}

}
