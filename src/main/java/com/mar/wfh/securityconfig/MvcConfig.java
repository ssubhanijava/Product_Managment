package com.mar.wfh.securityconfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
	
   @Override
   public void addViewControllers(ViewControllerRegistry registry) {
      registry.addViewController("/cust/customer").setViewName("customer-form");
      registry.addViewController("/login_succes").setViewName("login_succes");
     // registry.addViewController("/proced/do").setViewName("one");
    //  registry.addViewController("/indexLogin").setViewName("index");
    /*  registry.addViewController("/hello").setViewName("hello");
      registry.addViewController("/login").setViewName("login");*/
   }
}