package com.integers.ofs.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "OFS.T_RESTAURANTS")
public class Restaurant
{
	@Id
	@SequenceGenerator(name = "sequenceRestaurants", sequenceName = "SEQ_RESTAURANTS", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceRestaurants")
	@Column(name = "N_ID")
	private Long id;

	@Column(name = "N_CATEGORY_ID")
	private Long categoryId;

	@Column(name = "N_MUNICIPALITY_ID")
	private Long municipalityId;

	@Column(name = "V_NAME")
	private String name;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getCategoryId()
	{
		return categoryId;
	}

	public void setCategoryId(Long categoryId)
	{
		this.categoryId = categoryId;
	}

	public Long getMunicipalityId()
	{
		return municipalityId;
	}

	public void setMunicipalityId(Long municipalityId)
	{
		this.municipalityId = municipalityId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}