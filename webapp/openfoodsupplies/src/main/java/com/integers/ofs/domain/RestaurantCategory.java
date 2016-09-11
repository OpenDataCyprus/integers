package com.integers.ofs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "OFS.T_RESTAURANT_CATEGORIES")
public class RestaurantCategory
{
	@Id
	@SequenceGenerator(name = "sequenceRestaurantCategories", sequenceName = "SEQ_RESTAURANT_CATEGORIES", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceRestaurantCategories")
	@Column(name = "N_ID")
	private Long id;
	
	@Column(name = "V_DESCRIPTION")
	private String description;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}