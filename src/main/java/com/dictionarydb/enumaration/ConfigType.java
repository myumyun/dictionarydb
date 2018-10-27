package com.dictionarydb.enumaration;

public enum ConfigType {
	SYSTEMCONFIG("systemConfig",""), 
	APPLICATIONCONFIG("applicationConfig","");

	private String name;
	private String value;

	private ConfigType(String name, String value) {
		this.name = name;
		this.value = value;
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

}
