package com.joy.widasemariam.model;

public abstract class AbstractModel {

	protected Object id;
	
	public AbstractModel() {}
	
	public String getDisplayName() {
		
		return toString();
	}

	public Object getId() {
		
		return id;
	}
	
}
