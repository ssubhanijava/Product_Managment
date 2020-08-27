package com.mar.wfh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mar.wfh.modal.Address;
import com.mar.wfh.modal.Category;
import com.mar.wfh.modal.Customer;
import com.mar.wfh.services.AddressService;
import com.mar.wfh.services.CustomerService;

@Controller
@RequestMapping("/cust")
public final class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private AddressService addressService;

	@PostMapping(value = "/add")
	public String createNewUser(@ModelAttribute("customer") Customer customer, Model model) {
		ModelAndView modelAndView = new ModelAndView();

		customerService.registerCustomer(customer);

		model.addAttribute("successMessage", "Customer has been registered successfully");

		modelAndView.setViewName("customer-form");

		//return "login_succes";
		return "redirect:/cust/customer?success";
	}

	@GetMapping("/customer")
	public String home(ModelMap map) {
		map.addAttribute("customer", new Customer());
		map.addAttribute("cAddress", new Address());
		return "customer-form";
	}
	/*
	 * @RequestMapping("/add") public String addCustomer(@ModelAttribute("customer")
	 * Customer customer,
	 * 
	 * @ModelAttribute("cAddress") Address cAddress) {
	 * 
	 * List<Address> addre = new ArrayList<Address>(); addre.add(cAddress);
	 * 
	 * // addressService.registerCategory(addre);
	 * 
	 * Customer customer2 = customerService.registerCustomer(customer);
	 * 
	 * cAddress.setCustomer(customer2); addressService.registerCategory(addre);
	 * 
	 * customerService.registerCustomer(customer);
	 * 
	 * //return "redirect:customer-list"; return "index";
	 * 
	 * }
	 */

	@RequestMapping("/customer-list")
	public String gettingAllCustomer(Model model) {
		model.addAttribute("customers", customerService.findAll());
		return "/customer-list";
	}

	@RequestMapping("/getAddres/{id}")
	public String gettingAddressOnCustId(@PathVariable("id") Integer id, Model model) {
		Customer customer = customerService.findById(id);
		Address address = addressService.findById(customer.getCid());
		model.addAttribute("address", address);
		return "/list-address";

	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		Customer customer = customerService.findById(id);
		model.addAttribute("customer", customer);
		return "update-customer";
	}

	@PostMapping("update/{id}")
	public String updateCustomer(@PathVariable("id") Integer id, @ModelAttribute("customer") Customer customer,
			Model model) {

		customerService.registerCustomer(customer);
		model.addAttribute("customers", customerService.findAll());
		return "/customer-list";
	}

	@GetMapping("delete/{id}")
	public String deleteCustomer(@PathVariable("id") Integer id, @ModelAttribute("customer") Customer customer,
			Model model) {

		customerService.deleteCustomer(id);
		model.addAttribute("customers", customerService.findAll());
		return "/customer-list";
	}

	@GetMapping("/loginCustomer")
	public String loginCustDetailes(HttpServletRequest request,ModelMap map) {
		String remoteUser = request.getRemoteUser();
		Customer customer = customerService.findByCname(remoteUser);
		
		map.addAttribute("customers", customer);
	
		return "customer_login_details";
	}
	
	@GetMapping("/updateEmail")
	public String updateEmail(HttpServletRequest request,ModelMap map) {
		String remoteUser = request.getRemoteUser();
		Customer customer = customerService.findByCname(remoteUser);
		
		map.addAttribute("customers", customer);
	
		return "update_email";
	}

	
	
	@GetMapping("/updateAddress")
	public String updateAddress(HttpServletRequest request,ModelMap map) {
		
		String remoteUser = request.getRemoteUser();
		Customer customer = customerService.findByCname(remoteUser);
		List<Address> address = customer.getcAddress();
		
		map.addAttribute("address", address);
	
		return "update_address";
	}
	
	@GetMapping("updateemail/{id}")
	public String updateCEmail(@PathVariable("id") Integer id, @ModelAttribute("customer") Customer customer,
			Model model) {

		System.out.println("===============...............................");
		
		System.out.println("-=============== " +customer.getcEmail());
		
		
		customerService.registerCustomer(customer);
		
		return "customer_login_details";
	}

	
}
