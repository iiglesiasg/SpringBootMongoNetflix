package com.YooFood.mongo.model;

import java.io.Serializable;
import java.util.List;

public class GoogleMapsJson1Model implements Serializable{

	private List<GoogleMapsJson2Model> results; 
	private String status;
	
	
	public List<GoogleMapsJson2Model> getResults() {
		return results;
	}
	public void setResults(List<GoogleMapsJson2Model> results) {
		this.results = results;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
