package com.integers.ofs.repositories;

import java.util.List;

import com.integers.ofs.domain.model.Restaurant;

public interface RestaurantRepository
{
	List<Restaurant> list();

	Restaurant get(Long id);

	void saveOrUpdate(Restaurant restaurant);

	void delete(Long id);
}