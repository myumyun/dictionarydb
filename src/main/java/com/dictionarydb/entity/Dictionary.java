
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
	private String family;
	private String category;
	@Column(length = 1000)
	private String tags;
	@Column(length = 1000)
	private String feeling;
	@Column(length = 5000)
	private String code;
	@Column(length = 1000)
	private String link;
	private String language;
	private String ip;
	@Column(name = "created_at")
	@NotNull
	private Date createdAt;
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(length = 10)
	private String status;
	private String source;

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

	public String getFeeling() {
		return feeling;
	}

	public void setFeeling(String feeling) {
		this.feeling = feeling;
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

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "Dictionary [uniqueid=" + uniqueid + ", name=" + name + ", type="
				+ type + ", description=" + description + ", family=" + family
				+ ", category=" + category + ", tags=" + tags + ", feeling="
				+ feeling + ", code=" + code + ", link=" + link + ", language="
				+ language + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}

}
