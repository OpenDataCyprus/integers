package com.integers.ofs.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.integers.ofs.domain.RestaurantCategory;
import com.integers.ofs.repositories.RestaurantCategoryRepository;

@Controller
@RequestMapping("/restaurant/category")
public class RestaurantCategoryController
{
	@Autowired
	private RestaurantCategoryRepository restaurantCategoryRepository;

	@RequestMapping("")
	public ModelAndView list() throws Exception
	{
		@SuppressWarnings("unchecked")
		List<RestaurantCategory> restaurantCategoryList = (List<RestaurantCategory>) restaurantCategoryRepository.list();
		ModelAndView model = new ModelAndView("RestaurantCategoryList");
		model.addObject("restaurantCategoryList", restaurantCategoryList);
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addNewRestaurantCategory()
	{
		ModelAndView model = new ModelAndView("RestaurantCategoryForm");
		model.addObject("restaurantCategory", new RestaurantCategory());
		return model;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editRestaurantCategory(HttpServletRequest request)
	{
		Long restaurantCategoryId = Long.parseLong(request.getParameter("id"));
		RestaurantCategory restaurantCategory = (RestaurantCategory) restaurantCategoryRepository.get(restaurantCategoryId);
		ModelAndView model = new ModelAndView("RestaurantCategoryForm");
		model.addObject("restaurantCategory", restaurantCategory);
		return model;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteRestaurantCategory(HttpServletRequest request)
	{
		Long restaurantCategoryId = Long.parseLong(request.getParameter("id"));
		restaurantCategoryRepository.delete(restaurantCategoryId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveRestaurantCategory(@ModelAttribute RestaurantCategory restaurantCategory)
	{
		restaurantCategoryRepository.saveOrUpdate(restaurantCategory);
		return new ModelAndView("redirect:/");
	}
}