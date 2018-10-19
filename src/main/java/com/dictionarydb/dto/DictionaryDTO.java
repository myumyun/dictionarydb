package com.dictionarydb.dto;

import java.io.Serializable;
import java.util.Date;


public class DictionaryDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int uniqueid;
	private String name;
	private String description;
	private String code;
	private String language;
	private String type;
	private String tags;
	private String feeling;
	private int categoryId;
	private String createdAt;
	private String updatedAt;
	private CategoryDTO categoryDTO;
	private int rowCount;

	public DictionaryDTO() {
		super();
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

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getFeeling() {
		return feeling;
	}

	public void setFeeling(String feeling) {
		this.feeling = feeling;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}

	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "DictionaryDTO [uniqueid=" + uniqueid + ", name=" + name + ", description=" + description + ", code="
				+ code + ", language=" + language + ", type=" + type + ", tags=" + tags + ", feeling=" + feeling
				+ ", categoryId=" + categoryId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", categoryDTO=" + categoryDTO + "]";
	}

	
	public int getRowCount() {
		return rowCount;
	}

	
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

}
