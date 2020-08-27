package com.mar.wfh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mar.wfh.modal.Address;
import com.mar.wfh.modal.Customer;
import com.mar.wfh.modal.ModeOfPayments;
import com.mar.wfh.modal.product;
import com.mar.wfh.services.AddressService;
import com.mar.wfh.services.CategoryService;
import com.mar.wfh.services.CustomerService;
import com.mar.wfh.services.ProductService;
import com.mar.wfh.services.SubCategoryService;

@Controller
//@RequestMapping("/proced")
public class ProceedController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private SubCategoryService subCategoryService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private AddressService addressService;

	@RequestMapping("/proced")
	// @ResponseBody
	public String showProduct(HttpServletRequest request, ModelMap map) {

		String user = request.getRemoteUser();

		System.out.println("Login User........ " + user);
		map.addAttribute("User", user);
		Customer customer = customerService.findByCname(user);
		List<Address> getcAddress = customer.getcAddress();

		System.out.println(customer);
		map.addAttribute("cAddress", getcAddress);

		return "one";
	}

	@GetMapping("/addAddresss")
	public String addAdress(ModelMap map, HttpServletRequest request) {

		String user = request.getRemoteUser();

		map.addAttribute("User", user);
		Customer customer = customerService.findByCname(user);

		System.out.println("User-----------" + customer);

		map.addAttribute("customer", customer);
		map.addAttribute("cAddress", new Address());

		/*
		 * List<Address> getcAddress = customer.getcAddress();
		 * 
		 * map.addAttribute("address", getcAddress);
		 */

		return "add_customer_Address";
	}

	@GetMapping("/selectAdd/{id}")
	public String selectOneOfAddress(@PathVariable("id") Integer id, ModelMap map, HttpServletRequest request) {

		String user = request.getRemoteUser();

		Customer customer = customerService.findByCname(user);

		Address address = addressService.findById(id);
		System.out.println("User----------- Adding Adddress :- " + customer);
		List<String> pros = (List<String>) request.getSession().getAttribute("pros");

		List<product> listpro = new ArrayList<>();
		for (int i = 0; i < pros.size(); i++) {

			String pro = pros.get(i);
			product product = productService.getProductByName(pro);
			Integer pid = product.getPid();
			product pr = productService.findProuctById(pid);
			listpro.add(pr);
		}
		System.out.println("List Of Items........." + listpro);

		map.addAttribute("user", user);
		map.addAttribute("listPros", listpro);
		map.addAttribute("cAddress", address);

		/*
		 * List<Address> getcAddress = customer.getcAddress();
		 * 
		 * map.addAttribute("address", getcAddress);
		 */

		return "Confirm";
	}

	@RequestMapping("/cust/adddress")
	public String saveAddress(@ModelAttribute("cAddress") Address address, ModelMap map, HttpServletRequest request) {

		List<Address> addree = new ArrayList<>();
		String user = request.getRemoteUser();

		Customer customer = customerService.findByCname(user);
		address.setCustomer(customer);

		System.out.println("User----------- Adding Adddress :- " + customer);
		if (customer.getcAddress() == null) {
			addree.add(address);

		} else {
			addree.add(address);
		}

		customer.setcAddress(addree);
		customerService.registerCustomer(customer);
		// customerService.saveAddress(customer);

		List<String> pros = (List<String>) request.getSession().getAttribute("pros");

		List<product> listpro = new ArrayList<>();
		for (int i = 0; i < pros.size(); i++) {

			String pro = pros.get(i);
			product product = productService.getProductByName(pro);
			Integer pid = product.getPid();
			product pr = productService.findProuctById(pid);
			listpro.add(pr);
		}
		
	
		System.out.println("List Of Items........." + listpro);

		map.addAttribute("user", user);
		map.addAttribute("listPros", listpro);
		map.addAttribute("cAddress", address);

		/*
		 * List<Address> getcAddress = customer.getcAddress();
		 * 
		 * map.addAttribute("address", getcAddress);
		 */

		return "Confirm";
	}

	@GetMapping("/placeOrder")
	public String placeOrder(ModelMap map, HttpServletRequest request) {

		String user = request.getRemoteUser();
		map.addAttribute("user", user);

		return "order_conformed";
	}

}
