package com.integers.ofs.repositories;

import java.util.List;

public interface IRepository
{
	List<?> list();

	Object get(Long id);

	void saveOrUpdate(Object object);

	void delete(Long id);
}