package com.mar.wfh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mar.wfh.modal.Address;
import com.mar.wfh.modal.Customer;
import com.mar.wfh.services.AddressService;
import com.mar.wfh.services.CustomerService;

@Controller
@RequestMapping("/addr")
public final class AddressController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private AddressService addressService;

	@GetMapping("/customer")
	public String home(ModelMap map) {
		map.addAttribute("customer", new Customer());
		map.addAttribute("cAddress", new Address());
		return "customer-form";
	}

	@RequestMapping("/add")
	public String addCustomer(@ModelAttribute("customer") Customer customer,
			@ModelAttribute("cAddress") Address cAddress) {

		List<Address> addre = new ArrayList<Address>();
		addre.add(cAddress);

		// addressService.registerCategory(addre);

		Customer customer2 = customerService.registerCustomer(customer);

		cAddress.setCustomer(customer2);
		addressService.registerCategory(addre);

		return "redirect:customer-list";

	}

	@RequestMapping("/all-address")
	public String gettingAllCustomer(Model model) {
		model.addAttribute("address", addressService.findAll());
		return "all-address";
	}
	
	
	@RequestMapping("/getAddres/{id}")
	public String gettingAddressOnCustId(@PathVariable("id") int id, Model model) {
		Customer customer = customerService.findById(id);
		Address address = addressService.findById(customer.getCid());
		model.addAttribute("address",address);
		return "/list-address";
		
	}
	
	
}
