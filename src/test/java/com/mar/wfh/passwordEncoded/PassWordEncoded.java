package com.mar.wfh.passwordEncoded;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassWordEncoded {

	public static void main(String[] args) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String password = "subbu";

		String encodePassWord = encoder.encode(password);
		
		System.out.println(encodePassWord);
		

	}

}
