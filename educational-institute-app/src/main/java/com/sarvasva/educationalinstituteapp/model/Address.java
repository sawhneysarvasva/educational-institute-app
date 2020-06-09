package com.sarvasva.educationalinstituteapp.model;

import javax.persistence.Entity;


@Entity
public class Address extends BaseEntity{
	
	String addressLine1;
	String addressLine2;
	String state;
	String city;
	String pinCode;
	public Address(String addressLine1, String addressLine2, String state, String city, String pinCode) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.state = state;
		this.city = city;
		this.pinCode = pinCode;
	}
	public Address() {
		super();
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	
	
	
	

}
