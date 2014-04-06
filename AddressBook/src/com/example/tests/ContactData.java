package com.example.tests;

import com.example.fw.ApplicationManager;

public class ContactData implements Comparable<ContactData> {
	private String firstName;
	private String secondName;
	private String mainAddress;
	private String hPhone;
	private String mPhone;
	private String wPhone;
	private String email1;
	private String email2;
	private String bDay;
	private String bMonth;
	private String bYear;
	private String groupName;
	private String supAddress;
	private String supPhone;
	private String fullName;
	

	
	public ContactData() {
	}	
	
	@Override
	public String toString() {
		return "ContactData [fullName=" + fullName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result	+ ((fullName == null) ? 0 : fullName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(ContactData other) {
		return this.fullName.toLowerCase().compareTo(other.fullName.toLowerCase());
	}


//=======================================================================
	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public ContactData withSecondName(String secondName) {
		this.secondName = secondName;
		return this;
	}
	
	public ContactData withMainAddress(String mainAddress) {
		this.mainAddress = mainAddress;
		return this;
	}
	
	public ContactData withHPhone(String hPhone) {		
		this.hPhone = hPhone;
		return this;
	}
	
	public ContactData withMPhone(String mPhone) {		
		this.mPhone = mPhone;
		return this;
	}
	
	public ContactData withWPhone(String wPhone) {		
		this.wPhone = wPhone;
		return this;
	}
	
	public ContactData withEmail1(String email1) {		
		this.email1 = email1;
		return this;
	}
	
	public ContactData withEmail2(String email2) {		
		this.email2 = email2;
		return this;
	}
	
	public ContactData withBDay(String bDay) {		
		this.bDay = bDay;
		return this;
	}
	
	public ContactData withBMonth(String bMonth) {		
		this.bMonth = bMonth;
		return this;
	}
	
	public ContactData withBYear(String bYear) {		
		this.bYear = bYear;
		return this;
	}
	
	public ContactData withGroupName(String groupName) {		
		this.groupName = groupName;
		return this;
	}
	
	public ContactData withSupAddress(String supAddress) {		
		this.supAddress = supAddress;
		return this;
	}
	
	public ContactData withSupPhone(String supPhone) {		
		this.supPhone = supPhone;
		return this;
	}
	
	public ContactData saveFullName(String fullName) {		
		this.fullName = fullName;
		return this;
	}
	

//====================================================================	
	public String getFirstName() {
		return firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public String getMainAddress() {
		return mainAddress;
	}
	public String getHPhone() {
		return hPhone;
	}
	public String getMPhone() {
		return mPhone;
	}
	public String getWPhone() {
		return wPhone;
	}
	public String getEmail1() {
		return email1;
	}
	public String getEmail2() {
		return email2;
	}
	public String getBDay() {
		return bDay;
	}
	public String getBMonth() {
		return bMonth;
	}
	public String getBYear() {
		return bYear;
	}
	public String getGroupName() {
		return groupName;
	}
	public String getSupAddress() {
		return supAddress;
	}
	public String getSupPhone() {
		return supPhone;
	}



	
//===================================================================	
	
}