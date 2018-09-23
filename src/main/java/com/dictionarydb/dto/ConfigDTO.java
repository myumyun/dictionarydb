package com.dictionarydb.dto;

import java.io.Serializable;

public class ConfigDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int uniqueid;
	private String name;
	private String value;
	
	public ConfigDTO() {
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ConfigDTO [uniqueid=" + uniqueid + ", name=" + name + ", value=" + value + "]";
	}


}
