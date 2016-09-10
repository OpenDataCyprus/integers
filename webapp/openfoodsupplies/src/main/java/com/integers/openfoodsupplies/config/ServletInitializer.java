package com.integers.openfoodsupplies.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		return new Class[] { WebConfiguration.class };
	}

	@Override
	protected String[] getServletMappings()
	{
		return new String[] { "/" };
	}

	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		return null;
	}
}