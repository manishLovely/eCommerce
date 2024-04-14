package com.payment.customerAddressDto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Pattern.Flag;
import jakarta.validation.constraints.Size;

public class AddressInfo {
	
	@Pattern(regexp="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message="email is not valid")
	private String email;
	
	
    @Size(min=1,max=40, message="first name can't be greater than 40 and less than 1")
	private String first_name;
	
	@Size(min=1,max=40, message="last name can't be greater than 40 and less than 1")
	private String last_name;
	
	
	@Size(min=1,max=300,message="can't be greater than 300 characters and less than 1")
	private String address;
	@NotEmpty(message="city can't be empty")
	private String city;
	@Pattern(regexp="^\\d{10,12}$",flags = Flag.UNICODE_CASE,message="Invalid mobile number")
	private String mobNumber;
	
	private Boolean news_offers;

	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMobNumber() {
		return mobNumber;
	}

	public void setMobNumber(String mobNumber) {
		this.mobNumber = mobNumber;
	}

	public Boolean getNews_offers() {
		return news_offers;
	}

	public void setNews_offers(Boolean news_offers) {
		this.news_offers = news_offers;
	}

	public AddressInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressInfo(String email,String first_name, String last_name, String address, String city, String mobNumber,
			Boolean news_offers) {
		super();
		this.email= email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.city = city;
		this.mobNumber = mobNumber;
		this.news_offers = news_offers;
	}

	
	
}
