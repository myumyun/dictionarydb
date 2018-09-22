package com.dictionarydb.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "family")
public class Family {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uniqueid;
	@Column(length = 1000)
	@NotNull
	private String name;
	@Column(length = 1000)
	@NotNull
	private String description;
	@Column(name = "created_at")
	private Timestamp createdAt;
	@Column(name = "updated_at")
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
		return "Family [uniqueid=" + uniqueid + ", name=" + name + ", description=" + description + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	
	
	

}
