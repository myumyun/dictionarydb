package com.dictionarydb.dto;

import java.io.Serializable;

public class CategoryDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int uniqueid;
	private String name;
	private String description;
	private int parentCategoryId;
	
	public CategoryDTO() {
		super();
	}

	public CategoryDTO(int uniqueid, String name, String description, int parentCategoryId) {
		super();
		this.uniqueid = uniqueid;
		this.name = name;
		this.description = description;
		this.parentCategoryId = parentCategoryId;
	}

	public int getUniqueid() {
		return uniqueid;
	}

	public void setUniqueid(int uniqueid) {
		this.uniqueid = uniqueid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(int parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

}
