package com.integers.ofs.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.integers.ofs.domain.RestaurantCategory;
import com.integers.ofs.repositories.RestaurantCategoryRepository;

@Repository
public class RestaurantCategoryRepositoryImpl implements RestaurantCategoryRepository
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public RestaurantCategoryRepositoryImpl()
	{
	}
	
	public RestaurantCategoryRepositoryImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<?> list()
	{
		return (List<RestaurantCategory>) sessionFactory.getCurrentSession().createCriteria(RestaurantCategory.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	@Override
	@Transactional
	public Object get(Long id)
	{
		RestaurantCategory restaurantCategory = null;
		
		try
		{
			String hql = "from RestaurantCategory where id=" + id;
			Query query = sessionFactory.getCurrentSession().createQuery(hql);

			@SuppressWarnings("unchecked")
			List<RestaurantCategory> restaurantCategoryList = (List<RestaurantCategory>) query.list();

			if (restaurantCategoryList != null && !restaurantCategoryList.isEmpty())
			{
				restaurantCategory = restaurantCategoryList.get(0);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return restaurantCategory;
	}

	@Override
	@Transactional
	public void saveOrUpdate(Object object)
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate((RestaurantCategory) object);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void delete(Long id)
	{
		final RestaurantCategory restaurantCategory = new RestaurantCategory();
		restaurantCategory.setId(id);
		sessionFactory.getCurrentSession().delete(restaurantCategory);
	}
}