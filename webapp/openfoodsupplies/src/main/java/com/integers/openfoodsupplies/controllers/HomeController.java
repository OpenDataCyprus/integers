package com.integers.openfoodsupplies.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController
{
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model model)
	{
		model.addAttribute("message", "Welcome to Open Food Supplies");
		return "index";
	}
}