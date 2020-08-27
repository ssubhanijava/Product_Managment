package com.mar.wfh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mar.wfh.modal.Category;
import com.mar.wfh.modal.Item;
import com.mar.wfh.modal.SubCategory;
import com.mar.wfh.modal.product;
import com.mar.wfh.services.CategoryService;
import com.mar.wfh.services.ProductService;
import com.mar.wfh.services.SubCategoryService;

@Controller
public class AddToCartController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private SubCategoryService subCategoryService;

	@RequestMapping("/cart/{id}")
	public String addTocartProduct(@PathVariable("id") String pro, HttpServletRequest request, ModelMap map) {

		List<Category> findAll = categoryService.findAll();
		map.addAttribute("categories", findAll);

		List<SubCategory> subcategories = subCategoryService.findAll();
		map.addAttribute("subCategories", subcategories);

		List<product> products = productService.findAll();
		map.addAttribute("products", products);

		map.addAttribute("product", new product());

	@SuppressWarnings("unchecked")
	List<String> pros=(List<String>) request.getSession().getAttribute("pros");
		
		if (pros == null) {
			pros = new ArrayList<>();
			request.getSession().setAttribute("pros", pros);
		}
		pros.add(pro);
		request.getSession().setAttribute("pros", pros);
		
		System.out.println("list of orders "+pros.size());
		product product = productService.getProductByName(pro);
		
		System.out.println("add to cart msg ->"+product.getpSubCat());
		
		return "redirect:/"+product.getpSubCat();
	
	}

	
	@RequestMapping("/cart1/{id}")
	public String addToCartProduct(@PathVariable("id") String pro, HttpServletRequest request, ModelMap map) {

		List<Category> findAll = categoryService.findAll();
		map.addAttribute("categories", findAll);

		List<SubCategory> subcategories = subCategoryService.findAll();
		map.addAttribute("subCategories", subcategories);

		List<product> products = productService.findAll();
		map.addAttribute("products", products);

		map.addAttribute("product", new product());

	@SuppressWarnings("unchecked")
	List<String> pros=(List<String>) request.getSession().getAttribute("pros");
		
		if (pros == null) {
			pros = new ArrayList<>();
			request.getSession().setAttribute("pros", pros);
		}
		pros.add(pro);
		request.getSession().setAttribute("pros", pros);
		
		System.out.println("list of orders "+pros.size());
		product product = productService.getProductByName(pro);
		
		System.out.println("add to cart msg ->"+product.getpSubCat());

		 
		map.addAttribute("noItems", pros.size());

		
		return "redirect:/"+"details/"+product.getPid();
	
	}
	
	

	@RequestMapping("/cartuser/{id}")
	public String addTocartUserProduct(@PathVariable("id") String pro, HttpServletRequest request, ModelMap map) {

		List<Category> findAll = categoryService.findAll();
		map.addAttribute("categories", findAll);

		List<SubCategory> subcategories = subCategoryService.findAll();
		map.addAttribute("subCategories", subcategories);

		List<product> products = productService.findAll();
		map.addAttribute("products", products);

		map.addAttribute("product", new product());

	@SuppressWarnings("unchecked")
	List<String> pros=(List<String>) request.getSession().getAttribute("pros");
		
		if (pros == null) {
			pros = new ArrayList<>();
			request.getSession().setAttribute("pros", pros);
		}
		pros.add(pro);
		request.getSession().setAttribute("pros", pros);
		
		System.out.println("list of orders "+pros.size());
		product product = productService.getProductByName(pro);
		
		System.out.println("add to cart msg ->"+product.getpSubCat());
		
		return "redirect:/"+"one/"+product.getpSubCat();
	
	}

	
	@RequestMapping("/cartuser1/{id}")
	public String addToUserCartProduct(@PathVariable("id") String pro, HttpServletRequest request, ModelMap map) {

		List<Category> findAll = categoryService.findAll();
		map.addAttribute("categories", findAll);

		List<SubCategory> subcategories = subCategoryService.findAll();
		map.addAttribute("subCategories", subcategories);

		List<product> products = productService.findAll();
		map.addAttribute("products", products);

		map.addAttribute("product", new product());

	@SuppressWarnings("unchecked")
	List<String> pros=(List<String>) request.getSession().getAttribute("pros");
		
		if (pros == null) {
			pros = new ArrayList<>();
			request.getSession().setAttribute("pros", pros);
		}
		pros.add(pro);
		request.getSession().setAttribute("pros", pros);
		
		System.out.println("list of orders "+pros.size());
		product product = productService.getProductByName(pro);
		
		System.out.println("add to cart msg ->"+product.getpSubCat());
		
		return "redirect:/"+"one/details/"+product.getPid();
	
	}

	
	
	@RequestMapping("/buy/{id}")
	public String buyProduct(@PathVariable("id") int id, HttpSession session) {

		if (session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(productService.findProuctById(id), 1));
			session.setAttribute("cart", cart);

		}

		return null;
	}

}
