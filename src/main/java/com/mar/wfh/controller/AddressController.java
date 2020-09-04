package com.mar.wfh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mar.wfh.modal.Address;
import com.mar.wfh.modal.Category;
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
		model.addAttribute("address", address);
		return "/list-address";

	}

	@GetMapping("/delete/{id}")
	public String deleteAddres(@PathVariable("id") Integer id, ModelMap map, HttpServletRequest request) {

		Address address = addressService.findById(id);
		addressService.deleteAddress(address);
		String user = request.getRemoteUser();

		System.out.println("Login User........ " + user);
		map.addAttribute("User", user);
		Customer customer = customerService.findByCname(user);
		List<Address> getcAddress = customer.getAddress();

		// System.out.println(customer);
		map.addAttribute("cAddress", getcAddress);

		return "redirect:/proced";

	}

	@GetMapping("/edit/{id}")
	public String showAddressUpdateForm(@PathVariable("id") Integer id, Model model) {
		Address address = addressService.findById(id);
		model.addAttribute("address", address);

		return "address_Customer_Update";
	}

	@PostMapping("/update/{id}")
	public String updateAddress(@PathVariable("id") Integer id, @ModelAttribute("address") Address address, Model model,
			HttpServletRequest request) {

		String user = request.getRemoteUser();
		List<Address> addree = new ArrayList<>();
		Customer customer = customerService.findByCname(user);
		address.setCustomer(customer);
		List<Address> addre = customer.getAddress();

		// System.out.println("User----------- Adding Adddress :- " + customer);
		if (customer.getAddress() == null) {
			addree.add(address);

		} else {
			addre.add(address);
		}

		customer.setAddress(addre);
		customerService.saveAddressCustomer(customer);

		//addressService.saveAddress(address);

		return "redirect:/proced";
	}

}
