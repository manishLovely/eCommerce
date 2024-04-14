package com.jsonServer.model;

import java.io.Serializable;
import java.util.Objects;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


public class ProdIds implements Serializable {

	private String prodId;
	
	
	
	public ProdIds() {
		super();
		
	}

	

	public ProdIds(String prodId) {
		super();
		this.prodId = prodId;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
    
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
		return true;
	}
	if(obj==null||getClass()!=obj.getClass()) {
		
		return false;
	}
	ProdIds prodIds = (ProdIds) obj;
	return prodIds.equals(obj);
		
	}
	@Override
	public int hashCode() {
		
	
		return Objects.hash(prodId);
	}
	
	
	
	
	
}
