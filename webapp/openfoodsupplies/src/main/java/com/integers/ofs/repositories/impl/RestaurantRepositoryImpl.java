package com.integers.ofs.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.integers.ofs.domain.Restaurant;
import com.integers.ofs.repositories.RestaurantRepository;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository
{
	@Autowired
	private SessionFactory sessionFactory;

	public RestaurantRepositoryImpl()
	{
	}

	public RestaurantRepositoryImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Restaurant> list()
	{
		return (List<Restaurant>) sessionFactory.getCurrentSession().createCriteria(Restaurant.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	@Override
	@Transactional
	public void saveOrUpdate(Restaurant restaurant)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(restaurant);
	}

	@Override
	@Transactional
	public void delete(Long id)
	{
		Restaurant restaurant = new Restaurant();
		restaurant.setId(id);
		sessionFactory.getCurrentSession().delete(restaurant);
	}

	@Override
	@Transactional
	public Restaurant get(Long id)
	{
		String hql = "from Restaurant where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Restaurant> restaurantList = (List<Restaurant>) query.list();

		if (restaurantList != null && !restaurantList.isEmpty())
		{
			return restaurantList.get(0);
		}

		return null;
	}
}