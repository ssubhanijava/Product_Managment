package com.mar.wfh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mar.wfh.modal.Category;
import com.mar.wfh.modal.SubCategory;
import com.mar.wfh.modal.product;
import com.mar.wfh.services.CategoryService;
import com.mar.wfh.services.ProductService;
import com.mar.wfh.services.SubCategoryService;

@Controller
//@RequestMapping("/one")
public class ShowUserProductDetails {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private SubCategoryService subCategoryService;

	@RequestMapping("/one/{id}")
	public String showUserProduct(@PathVariable("id") String id, ModelMap map,HttpServletRequest request) {
		
		System.out.println("----------------------------product user___________");

		List<Category> categories = categoryService.findAll();
		map.addAttribute("cats", categories);

		List<SubCategory> subcategories = subCategoryService.findAll();
		map.addAttribute("subCategories", subcategories);

		List<product> productsBySubCat = productService.getProductsBySubCat(id);

		map.addAttribute("productsBySubCat", productsBySubCat);
		
		List<String> pros = (List<String>) request.getSession().getAttribute("pros");

		
		if (pros == null) {
			map.addAttribute("Items", " ");
		} else {
			map.addAttribute("Items", pros.size());
		}
		return "product";
	}
	
	

	@RequestMapping("/one/details/{id}")
	public String showDetails(@PathVariable("id") Integer id, ModelMap map,HttpServletRequest request) {
		

		 String u1 = request.getRemoteUser();

		System.out.println("Inside Index Controller.."+u1);
		
		map.addAttribute("user", u1);

		List<Category> categories = categoryService.findAll();
		map.addAttribute("cats", categories);

		List<SubCategory> subcategories = subCategoryService.findAll();
		map.addAttribute("subCategories", subcategories);

		product findProuctById = productService.findProuctById(id);
		map.addAttribute("product", findProuctById);
		
	/*	List<String> pros = (List<String>) request.getSession().getAttribute("pros");
		
		 * request.getSession().setAttribute("items", pros);
		 
		map.addAttribute("Items", pros.size());*/

		return "single_user";
	}
	
	
	
	

/*	
	@RequestMapping("/details/{id}")
	public String showUserDetails(@PathVariable("id") Integer id, ModelMap map) {

		
		System.out.println("----------------------------productle page Single  user___________");
		
		List<Category> categories = categoryService.findAll();
		map.addAttribute("cats", categories);

		List<SubCategory> subcategories = subCategoryService.findAll();
		map.addAttribute("subCategories", subcategories);

		product findProuctById = productService.findProuctById(id);
		map.addAttribute("product", findProuctById);

		return "single";
	}*/

}
