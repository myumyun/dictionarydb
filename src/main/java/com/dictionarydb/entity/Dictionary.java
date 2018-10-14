
package com.dictionarydb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dictionaries")
public class Dictionary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uniqueid;
	@Column(length = 1000)
	@NotNull
	private String name;
	@Column(length = 100)
	private String type;
	@Column(length = 2000)
	private String description;
	private int familyId;
	private int categoryId;
	@Column(length = 1000)
	private String tags;
	@Column(length = 1000)
	private String feeling;
	@Column(length = 5000)
	private String code;
	@Column(length = 1000)
	private String language;
	@Column(name = "created_at")
	private Date createdAt;
	@Column(name = "updated_at")
	private Date updatedAt;

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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getFeeling() {
		return feeling;
	}

	public void setFeeling(String feeling) {
		this.feeling = feeling;
	}

	public int getFamilyId() {
		return familyId;
	}

	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	@Override
	public String toString() {
		return "Dictionary [uniqueid=" + uniqueid + ", name=" + name + ", type=" + type + ", description=" + description
				+ ", familyId=" + familyId + ", categoryId=" + categoryId + ", tags=" + tags + ", feeling=" + feeling
				+ ", code=" + code + ", language=" + language + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}

}
