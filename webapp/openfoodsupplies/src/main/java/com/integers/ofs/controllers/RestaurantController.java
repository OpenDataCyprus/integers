package com.integers.ofs.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.integers.ofs.domain.Restaurant;
import com.integers.ofs.repositories.RestaurantRepository;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController
{
	@Autowired
	private RestaurantRepository restaurantRepository;

	@RequestMapping("")
	public ModelAndView list() throws Exception
	{
		List<Restaurant> restaurantList = restaurantRepository.list();
		ModelAndView model = new ModelAndView("RestaurantList");
		model.addObject("restaurantList", restaurantList);
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addNewRestaurant()
	{
		ModelAndView model = new ModelAndView("RestaurantForm");
		model.addObject("restaurant", new Restaurant());
		return model;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editRestaurant(HttpServletRequest request)
	{
		Long restaurantId = Long.parseLong(request.getParameter("id"));
		Restaurant restaurant = restaurantRepository.get(restaurantId);
		ModelAndView model = new ModelAndView("RestaurantForm");
		model.addObject("restaurant", restaurant);
		return model;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteRestaurant(HttpServletRequest request)
	{
		Long restaurantId = Long.parseLong(request.getParameter("id"));
		restaurantRepository.delete(restaurantId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveRestaurant(@ModelAttribute Restaurant restaurant)
	{
		restaurantRepository.saveOrUpdate(restaurant);
		return new ModelAndView("redirect:/");
	}
}