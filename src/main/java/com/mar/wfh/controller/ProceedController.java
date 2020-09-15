package com.mar.wfh.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
import com.mar.wfh.modal.Item;
import com.mar.wfh.modal.ModeOfPayments;
import com.mar.wfh.modal.Order;
import com.mar.wfh.modal.product;
import com.mar.wfh.services.AddressService;
import com.mar.wfh.services.CategoryService;
import com.mar.wfh.services.CustomerService;
import com.mar.wfh.services.ProductService;
import com.mar.wfh.services.SubCategoryService;

@Controller
//@RequestMapping("/proced")
public class ProceedController {

	int subTotal;

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
		List<Address> getcAddress = customer.getAddress();

		// System.out.println(customer);
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

	@SuppressWarnings("null")
	@GetMapping("/selectAdd/{id}")
	public String selectOneOfAddress(@PathVariable("id") Integer id, ModelMap map, HttpServletRequest request) {

		int sum = 0;
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

		List<Item> Itemlist = new ArrayList<>();
		Set<product> p = new HashSet<product>(listpro);

		for (product pr : p) {
			Item item = new Item();

			int frequency = Collections.frequency(listpro, pr);
			if (frequency > 1) {

				if (Itemlist != null) {
					System.out.println(pr + "::" + frequency);
					item.setProduct(pr);
					item.setQuantity(frequency);
					Itemlist.add(item);
					sum += item.getProduct().getpPrice() * item.getQuantity();

				} else {
					System.out.println(pr + "::" + frequency);

					item.setProduct(pr);
					item.setQuantity(frequency);
					Itemlist.add(item);
					sum += item.getProduct().getpPrice() * item.getQuantity();
				}

				// System.out.println( frequency);

			} else {
				System.out.println(pr + "::" + frequency);
				Item item1 = new Item();
				item1.setProduct(pr);
				item1.setQuantity(frequency);
				Itemlist.add(item1);
				sum += item1.getProduct().getpPrice() * item1.getQuantity();
			}

		}

		System.out.println("--------" + Itemlist.size());

		List<Order> listOrders = new ArrayList<Order>();
		Order order = new Order();
		Order order1 = new Order();
		Iterator<Item> iterator = Itemlist.iterator();

		while (iterator.hasNext()) {
			Item items = (Item) iterator.next();

			if (items.getQuantity() > 1) {

				if (listOrders == null) {

					order.setProductName(items.getProduct().getpName());
					order.setQuantity(items.getQuantity());
					order.setPriceEach(items.getProduct().getpPrice());
					listOrders.add(order);

				} else {

					order1.setProductName(items.getProduct().getpName());
					order1.setQuantity(items.getQuantity());
					order1.setPriceEach(items.getProduct().getpPrice());
					listOrders.add(order1);

				}

			} else {
				if (listOrders == null) {

					order.setProductName(items.getProduct().getpName());
					order.setQuantity(items.getQuantity());
					order.setPriceEach(items.getProduct().getpPrice());
					listOrders.add(order);
				} else {

					order1.setProductName(items.getProduct().getpName());
					order1.setQuantity(items.getQuantity());
					order1.setPriceEach(items.getProduct().getpPrice());
					listOrders.add(order1);

				}

			}
			System.out.println("========" + items.getProduct().getpSubCat() + ":::" + items.getQuantity() + "=======");

		}

		System.out.println("-=================-=-=-=-" + sum);

		map.addAttribute("listOfItems", Itemlist);
		map.addAttribute("listOfOrders", listOrders);
		map.addAttribute("user", user);
		map.addAttribute("subtotal", sum);
		map.addAttribute("listPros", listpro);
		map.addAttribute("cAddress", address);

		/*
		 * List<Address> getcAddress = customer.getcAddress();
		 * 
		 * map.addAttribute("address", getcAddress);
		 */

		subTotal = sum;
		return "Confirm";
	}

	@RequestMapping("/cust/adddress")
	public String saveAddress(@ModelAttribute("cAddress") Address address, ModelMap map, HttpServletRequest request) {

		List<Address> addree = new ArrayList<>();
		String user = request.getRemoteUser();

		int sum = 0;

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

		List<Address> addre1 = customer.getAddress();

		// System.out.println("List Of Items........." + listpro);

		List<Item> Itemlist = new ArrayList<>();
		Set<product> p = new HashSet<product>(listpro);

		for (product pr : p) {
			Item item = new Item();

			int frequency = Collections.frequency(listpro, pr);
			if (frequency > 1) {

				if (Itemlist != null) {
					System.out.println(pr + "::" + frequency);
					item.setProduct(pr);
					item.setQuantity(frequency);
					Itemlist.add(item);
					sum += item.getProduct().getpPrice() * item.getQuantity();

				} else {
					System.out.println(pr + "::" + frequency);

					item.setProduct(pr);
					item.setQuantity(frequency);
					Itemlist.add(item);
					sum += item.getProduct().getpPrice() * item.getQuantity();
				}

				// System.out.println( frequency);

			} else {
				System.out.println(pr + "::" + frequency);
				Item item1 = new Item();
				item1.setProduct(pr);
				item1.setQuantity(frequency);
				Itemlist.add(item1);
				sum += item1.getProduct().getpPrice() * item1.getQuantity();
			}

		}

		System.out.println("--------" + Itemlist.size());

		List<Order> listOrders = new ArrayList<Order>();
		Order order = new Order();
		Order order1 = new Order();
		Iterator<Item> iterator = Itemlist.iterator();

		while (iterator.hasNext()) {
			Item items = (Item) iterator.next();

			if (items.getQuantity() > 1) {

				if (listOrders == null) {

					order.setProductName(items.getProduct().getpName());
					order.setQuantity(items.getQuantity());
					order.setPriceEach(items.getProduct().getpPrice());
					listOrders.add(order);

				} else {

					order1.setProductName(items.getProduct().getpName());
					order1.setQuantity(items.getQuantity());
					order1.setPriceEach(items.getProduct().getpPrice());
					listOrders.add(order1);

				}

			} else {
				if (listOrders == null) {

					order.setProductName(items.getProduct().getpName());
					order.setQuantity(items.getQuantity());
					order.setPriceEach(items.getProduct().getpPrice());
					listOrders.add(order);
				} else {

					order1.setProductName(items.getProduct().getpName());
					order1.setQuantity(items.getQuantity());
					order1.setPriceEach(items.getProduct().getpPrice());
					listOrders.add(order1);

				}

			}
			System.out.println("========" + items.getProduct().getpSubCat() + ":::" + items.getQuantity() + "=======");

		}

		System.out.println("-=================-=-=-=-" + sum);

		map.addAttribute("listOfItems", Itemlist);

		map.addAttribute("user", user);
		map.addAttribute("subtotal", sum);
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

	@GetMapping("/payMentMethods")
	public String paymentsMethod(ModelMap map, HttpServletRequest request) {

		String user = request.getRemoteUser();
		map.addAttribute("user", user);
		map.addAttribute("subTotal", subTotal);
		return "payments_options";
	}

}
