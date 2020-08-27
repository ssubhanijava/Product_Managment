
package com.mar.wfh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mar.wfh.dao.ProductJpa;
import com.mar.wfh.modal.Category;
import com.mar.wfh.modal.SubCategory;
import com.mar.wfh.modal.product;
import com.mar.wfh.services.CategoryService;
import com.mar.wfh.services.ProductService;
import com.mar.wfh.services.SubCategoryService;

@Controller
public class IndexController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private SubCategoryService subCategoryService;

	@RequestMapping("/")
	public String indexPage(ModelMap map, HttpServletRequest request) {
	
	/*	  String u1 = request.getRemoteUser();
		  
		  System.out.println("Inside Index Controller.." + u1);
		  
		  map.addAttribute("user", u1);*/
		 

		System.out.println("Inside Index Controller.. no url");

		List<Category> categories = categoryService.findAll();
		map.addAttribute("cats", categories);

		List<SubCategory> subcategories = subCategoryService.findAll();
		map.addAttribute("subCategories", subcategories);

		List<product> products = productService.findAll();
		map.addAttribute("products", products);

		map.addAttribute("product", new product());
		
		
		List<String> pros = (List<String>) request.getSession().getAttribute("pros");
		
		if(pros==null) {
			map.addAttribute("noItems",0);
		}
		else {
		map.addAttribute("noItems", pros.size());
		}
		return "index";
	}

/*	@RequestMapping("/logout")
	public String logoutPage(ModelMap map, HttpServletRequest request) {
		
		  String u1 = request.getRemoteUser();
		  
		  System.out.println("Inside Index Controller.."+u1);
		  
		  map.addAttribute("user1", u1);
		 

		System.out.println("Inside Index Controller..");

		List<Category> categories = categoryService.findAll();
		map.addAttribute("cats", categories);

		List<SubCategory> subcategories = subCategoryService.findAll();
		map.addAttribute("subCategories", subcategories);

		List<product> products = productService.findAll();
		map.addAttribute("products", products);

		map.addAttribute("product", new product());

		return "index1";
	}*/

	@RequestMapping("/indexLogin")
	public String indexLogin(HttpServletRequest request, ModelMap map) {

		String u1 = request.getRemoteUser();

		System.out.println("Inside Index Controller.." + u1);

		map.addAttribute("user", u1);

		List<Category> categories = categoryService.findAll();
		map.addAttribute("cats", categories);

		List<SubCategory> subcategories = subCategoryService.findAll();
		map.addAttribute("subCategories", subcategories);

		List<product> products = productService.findAll();
		map.addAttribute("products", products);

		map.addAttribute("product", new product());
		
		List<String> pros = (List<String>) request.getSession().getAttribute("pros");
		
		if(pros==null) {
			map.addAttribute("Items", " ");
		}
		else {
		map.addAttribute("Items", pros.size());
		}

		return "indexlogin";
	}

	/*
	 * @RequestMapping("/{id}") public String showProduct(@PathVariable("id") String
	 * id, ModelMap map) {
	 * 
	 * 
	 * System.out.println("----------=-=-==-=-=-=w-f=f-=f-=f-e=f-ef=");
	 * 
	 * List<product> productsBySubCat = productService.getProductsBySubCat(id);
	 * 
	 * map.addAttribute("productsBySubCat", productsBySubCat);
	 * 
	 * return "products"; }
	 */

	/*
	 * @RequestMapping("/details/{id}") public String
	 * showDetails(@PathVariable("id")Integer id,ModelMap map) {
	 * 
	 * System.out.println("details---------===============888888888888888888888");
	 * product findProuctById = productService.findProuctById(id);
	 * map.addAttribute("product", findProuctById);
	 * 
	 * return "single"; }
	 * 
	 */

}
