package com.niit.foodcart.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.foodcart.model.Login;
import com.niit.foodcart.service.impl.LoginService;

@Controller
public class LoginController
{
	
	@ModelAttribute("log")
	public Login bala()
	{
		System.out.println("called");
		return new Login();
	}
	
	@RequestMapping(value={"loginpage"})
	public ModelAndView login()
	{
		
		ModelAndView model= new ModelAndView("login");
				return model;
	}
//	@RequestMapping(value="loginpages")
//	public String log()
//	{
//		return "login";
//	}
//	
	@Autowired
	LoginService ls;

	

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView loginuser(@ModelAttribute("log") Login login) {
		boolean isvaliduser = false;
		isvaliduser = ls.checkUser(login);
		ls.save(login);
		ModelAndView mv = null;
		if (isvaliduser == true) {
			 mv = new ModelAndView("success");
			mv.addObject("msg", "Welcome");
			mv.addObject("name", login.getUsername());
		}
		return mv;
	}
	
	@RequestMapping(value = "/loginpages", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
	@RequestParam(value = "logout",	required = false) String logout) {
		
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid Credentials provided.");
		}

		if (logout != null) {
			model.addObject("message", "Logged out successfully.");
		}

		model.setViewName("login");
		return model;
	}

}











