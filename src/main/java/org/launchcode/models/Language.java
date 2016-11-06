package org.launchcode.models;

public class Language {

	private String name;
	private String greeting;
	
	public Language(String name, String greeting) {
		this.name = name;
		this.greeting = greeting;
	}

	public String getName() {
		return name;
	}

	public String getGreeting() {
		return greeting;
	}
	
	
}
