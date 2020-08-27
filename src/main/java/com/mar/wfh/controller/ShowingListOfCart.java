package com.mar.wfh.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mar.wfh.modal.Category;
import com.mar.wfh.modal.Item;
import com.mar.wfh.modal.SubCategory;
import com.mar.wfh.modal.product;
import com.mar.wfh.services.CategoryService;
import com.mar.wfh.services.ProductService;
import com.mar.wfh.services.SubCategoryService;
import com.sun.javafx.collections.MappingChange.Map;

@Controller
public class ShowingListOfCart {

	@Autowired
	private CategoryService categoryService;;

	@Autowired
	private SubCategoryService subCategoryService;

	@Autowired
	private ProductService productService;

	@SuppressWarnings("unused")
	@GetMapping("/showcart")
	public String showListOfCart(HttpServletRequest request, ModelMap map) {

		String u1 = request.getRemoteUser();

		System.out.println("Inside Index Controller.." + u1);

		map.addAttribute("user", u1);

		List<Category> categories = categoryService.findAll();
		map.addAttribute("cats", categories);

		List<SubCategory> subcategories = subCategoryService.findAll();
		map.addAttribute("subCategories", subcategories);

		product findProuctById = productService.findProuctById(2);
		map.addAttribute("product", findProuctById);

		List<String> pros = (List<String>) request.getSession().getAttribute("pros");

		List<product> listpro = new ArrayList<>();
		for (int i = 0; i < pros.size(); i++) {

			
			String pro = pros.get(i);
			product product = productService.getProductByName(pro);
			Integer pid = product.getPid();
			product pr = productService.findProuctById(pid);
			listpro.add(pr);
		}
		Item item = new Item();

		HashMap<product, Integer> counts = new HashMap<product, Integer>();

		for (product str : listpro) {
			if (counts.containsKey(str)) {
				counts.put(str, counts.get(str) + item.getQuantity() + 1);
			} else {
				counts.put(str, 1);
			}
		}

		/*
		 * for (Entry<product, Integer> entry : counts.entrySet()) {
		 * System.out.println(entry.getKey() + " = " + entry.getValue());
		 * 
		 * Integer value = entry.getValue(); map.addAttribute("no",entry);
		 * 
		 * 
		 * }
		 */

		map.addAttribute("prosList", listpro);

		System.out.println(pros);

		if (pros == null) {
			map.addAttribute("noItems", " ");
		} else {

			map.addAttribute("noItems", pros.size());
		}

		return "show_cart";
	}

	private void findProuctById(Integer pid) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unused")
	@GetMapping("/remove/{id}")
	public String removeingListOfCart(@PathVariable("id") String name, HttpServletRequest request, ModelMap map) {

		List<String> pros = (List<String>) request.getSession().getAttribute("pros");

		/*
		 * if (pros == null) { pros = new ArrayList<>();
		 * request.getSession().setAttribute("MY_PROS", pros); }
		 */
		System.out.println(pros.remove(name));
		pros.remove(name);
		request.getSession().setAttribute("pros", pros);

		

		// ProductMaster proMaster=productService.getProductByName(name);

		List<Category> categories = categoryService.findAll();
		map.addAttribute("cats", categories);

		List<SubCategory> subcategories = subCategoryService.findAll();
		map.addAttribute("subCategories", subcategories);
		List<product> products = productService.findAll();
		map.addAttribute("products", products);

		map.addAttribute("product", new product());

		return "redirect:/showcart";

	}

}
