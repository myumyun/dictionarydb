package com.dictionarydb.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "configs")
public class Config {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uniqueid;
	private String name;
	private String description;
	private String value;
	@Column(length = 23)
	private Timestamp createdAt;
	@Column(length = 23)
	private Timestamp updatedAt;

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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Config [uniqueid=" + uniqueid + ", name=" + name + ", description=" + description + ", value=" + value
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
