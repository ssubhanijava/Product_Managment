package com.mar.wfh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mar.wfh.dto.Login;

@Controller
public class LoginController {

	@GetMapping("/login1")
	public String loginHome() {
System.out.println("nknnknlnl log coronaaaaaaaaaaaaaaaaa");
		return "redirect:/indexLogin";
	}

}