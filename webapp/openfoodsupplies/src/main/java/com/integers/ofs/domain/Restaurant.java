package com.integers.ofs.domain;

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
	
	@Column(name = "V_CATEGORY_DESCRIPTION")
	private String categoryDescription;

	@Column(name = "N_MUNICIPALITY_ID")
	private Long municipalityId;
	
	@Column(name = "V_MUNICIPALITY_NAME")
	private String municipalityName;

	@Column(name = "V_NAME")
	private String name;
	
	@Column(name = "V_COORDINATES")
	private String coordinates;

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

	public String getCategoryDescription()
	{
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription)
	{
		this.categoryDescription = categoryDescription;
	}

	public Long getMunicipalityId()
	{
		return municipalityId;
	}

	public void setMunicipalityId(Long municipalityId)
	{
		this.municipalityId = municipalityId;
	}

	public String getMunicipalityName()
	{
		return municipalityName;
	}

	public void setMunicipalityName(String municipalityName)
	{
		this.municipalityName = municipalityName;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCoordinates()
	{
		return coordinates;
	}

	public void setCoordinates(String coordinates)
	{
		this.coordinates = coordinates;
	}

	@Override
	public String toString()
	{
		return "Restaurant [" + (id != null ? "id=" + id + ", " : "") + (categoryId != null ? "categoryId=" + categoryId + ", " : "") + (categoryDescription != null ? "categoryDescription=" + categoryDescription + ", " : "") + (municipalityId != null ? "municipalityId=" + municipalityId + ", " : "") + (municipalityName != null ? "municipalityName=" + municipalityName + ", " : "") + (name != null ? "name=" + name + ", " : "") + (coordinates != null ? "coordinates=" + coordinates : "") + "]";
	}
}