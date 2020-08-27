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
import org.springframework.web.bind.annotation.ResponseBody;

import com.mar.wfh.modal.Category;
import com.mar.wfh.modal.SubCategory;
import com.mar.wfh.modal.product;
import com.mar.wfh.services.CategoryService;
import com.mar.wfh.services.ProductService;
import com.mar.wfh.services.SubCategoryService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private CategoryService categoryService;;

	@Autowired
	private SubCategoryService subCategoryService;

	@Autowired
	private ProductService productService;

	@RequestMapping("/product")
	public String home(ModelMap map) {

		List<Category> categories = categoryService.findAll();
		List<SubCategory> subCategories = subCategoryService.findAll();
		map.addAttribute("categories", categories);
		map.addAttribute("subCategories", subCategories);
		map.addAttribute("product", new product());

		return "add-product";
	}

	@RequestMapping("/add")
	public String addProduct(@ModelAttribute product product) {

		productService.registerCategory(product);

		return "redirect:list-Product";
	}

	@RequestMapping("/list-Product")
	public String showAllProducts(Model model) {
		model.addAttribute("products", productService.findAll());
		return "/list-product";
	}

	@RequestMapping("/subcat/{cat}")
	@ResponseBody
	public List<SubCategory> getSubCatByCat(@PathVariable("cat") String cat, Model model) {

		List<SubCategory> subCats = subCategoryService.findByCat(cat);

		// model.addAttribute("products", productService.findAll());
		return subCats;
	}

	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable("id") Integer id, Model model) {
		product product = productService.findById(id);
		productService.delete(product);
		model.addAttribute("products", productService.findAll());
		return "/list-product";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		product product = productService.findById(id);
		model.addAttribute("product", product);
		return "update-product";
	}

	@PostMapping("update/{id}")
	public String updateStudent(@PathVariable("id") long id, @ModelAttribute("product") product product, Model model) {

		productService.registerCategory(product);
		model.addAttribute("products", productService.findAll());
		return "/list-product";
	}

	@RequestMapping("/{subCat}")
	public String productsBySubCategories(@PathVariable("subCat") String subCategories, ModelMap map) {
		// List<ProductMaster> productsList =
		// productService.getProductsBySubCategory(subCategories);
		// System.out.println(productsList);
		List<Category> categories = categoryService.findAll();
		map.addAttribute("cats", categories);

		List<SubCategory> subcategories = subCategoryService.findAll();
		map.addAttribute("subCategories", subcategories);

		List<product> products = productService.findAll();
		map.addAttribute("products", products);

		List<product> pros = productService.getProductsBySubCat(subCategories);
		map.addAttribute("pros", pros);
		map.addAttribute("product", new product());
		return "products";
	}

}
