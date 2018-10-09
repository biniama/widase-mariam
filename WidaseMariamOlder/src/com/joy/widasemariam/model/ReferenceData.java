package com.joy.widasemariam.model;

public class ReferenceData extends AbstractModel {
	
	private String name;
	
	private String displayName;
	
	public ReferenceData(String name, String displayName) {
		
		this.name = name;
		this.displayName = displayName;
	}
	
	@Override
	public String toString() {
		
		return displayName;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}