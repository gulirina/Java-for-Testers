package com.example.tests;

public class ContactData {
	public String firstName;
	public String secondName;
	public String mainAddress;
	public String hPhone;
	public String mPhone;
	public String wPhone;
	public String email1;
	public String email2;
	public String bDay;
	public String bMonth;
	public String bYear;
	public String groupName;
	public String supAddress;
	public String supPhone;

	public ContactData(String firstName, String secondName, String mainAddress,
			String hPhone, String mPhone, String wPhone, String email1,
			String email2, String bDay, String bMonth, String bYear,
			String groupName, String supAddress, String supPhone) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.mainAddress = mainAddress;
		this.hPhone = hPhone;
		this.mPhone = mPhone;
		this.wPhone = wPhone;
		this.email1 = email1;
		this.email2 = email2;
		this.bDay = bDay;
		this.bMonth = bMonth;
		this.bYear = bYear;
		this.groupName = groupName;
		this.supAddress = supAddress;
		this.supPhone = supPhone;
	}
	
	public ContactData() {
	}
}