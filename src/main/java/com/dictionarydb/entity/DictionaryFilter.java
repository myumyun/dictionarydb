package com.dictionarydb.entity;

import java.io.Serializable;

public class DictionaryFilter implements Serializable {
	private static final long serialVersionUID = 2545591341510320247L;

	private String title;
	private String category;
	private String tags;
	private String description;
	private boolean hasCode;
	private String language;
	private String feeling;
	private String startDate;
	private String endDate;

	public DictionaryFilter() {
		super();
	}

	public DictionaryFilter(String title, String category, String tags, String description, boolean hasCode,
			String language, String feeling, String startDate, String endDate) {
		super();
		this.title = title;
		this.category = category;
		this.tags = tags;
		this.description = description;
		this.hasCode = hasCode;
		this.language = language;
		this.feeling = feeling;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isHasCode() {
		return hasCode;
	}

	public void setHasCode(boolean hasCode) {
		this.hasCode = hasCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getFeeling() {
		return feeling;
	}

	public void setFeeling(String feeling) {
		this.feeling = feeling;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "DictionaryFilter [title=" + title + ", category=" + category + ", tags=" + tags + ", description="
				+ description + ", hasCode=" + hasCode + ", language=" + language + ", feeling=" + feeling
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
