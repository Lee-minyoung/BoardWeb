package com.yedam.vo;

public class Student {
	private String stNumber;
	private String stName;
	private String phone;
	private String address;

	public Student() {

	}

	public Student(String stNumber, String stName, String phone, String address) {
		super();
		this.stNumber = stNumber;
		this.stName = stName;
		this.phone = phone;
		this.address = address;
	}
	

	public String getStNumber() {
		return stNumber;
	}

	public void setStNumber(String stNumber) {
		this.stNumber = stNumber;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [stNumber=" + stNumber + ", stName=" + stName + ", phone=" + phone + ", address=" + address
				+ "]";
	}
	
	
}
