package com.dictionarydb.dto;

public class FamilyDTO {
	private int uniqueid;
	private String name;
	private String description;

	public FamilyDTO() {
		super();
	}


	public FamilyDTO(int uniqueid, String name, String description) {
		super();
		this.uniqueid = uniqueid;
		this.name = name;
		this.description = description;
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

	@Override
	public String toString() {
		return "FamilyDTO [uniqueid=" + uniqueid + ", name=" + name + ", description=" + description + "]";
	}

}
