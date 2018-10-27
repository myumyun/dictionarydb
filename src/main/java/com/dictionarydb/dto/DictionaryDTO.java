package com.dictionarydb.dto;

import java.io.Serializable;

public class DictionaryDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int uniqueid;
	private String name;
	private String description;
	private String code;
	private String language;
	private String link;
	private String type;
	private String tags;
	private String feeling;
	private String category;
	private String createdAt;
	private String updatedAt;

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "DictionaryDTO [uniqueid=" + uniqueid + ", name=" + name + ", description=" + description + ", code="
				+ code + ", language=" + language + ", link=" + link + ", type=" + type + ", tags=" + tags
				+ ", feeling=" + feeling + ", category=" + category + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}

}
