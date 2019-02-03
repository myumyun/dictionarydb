package com.dictionarydb.dto;

public class BotDTO {
	private String topic;
	private String input;

	public BotDTO() {
		super();
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	@Override
	public String toString() {
		return "BotDTO [topic=" + topic + ", input=" + input + "]";
	}

}
