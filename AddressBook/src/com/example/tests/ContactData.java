package com.example.tests;

import com.example.fw.ApplicationManager;

public class ContactData implements Comparable<ContactData> {
	private String id;
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
	public String gethPhone() {
		return hPhone;
	}
	public String getmPhone() {
		return mPhone;
	}
	public String getwPhone() {
		return wPhone;
	}
	public String getEmail1() {
		return email1;
	}
	public String getEmail2() {
		return email2;
	}
	public String getbDay() {
		return bDay;
	}
	public String getbMonth() {
		return bMonth;
	}
	public String getbYear() {
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
	public String getId() {
		return id;
	}
//=======================================================================
	public void setId(String id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public void setMainAddress(String mainAddress) {
		this.mainAddress = mainAddress;
	}

	public void sethPhone(String hPhone) {
		this.hPhone = hPhone;
	}

	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}

	public void setwPhone(String wPhone) {
		this.wPhone = wPhone;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public void setbDay(String bDay) {
		this.bDay = bDay;
	}

	public void setbMonth(String bMonth) {
		this.bMonth = bMonth;
	}

	public void setbYear(String bYear) {
		this.bYear = bYear;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setSupAddress(String supAddress) {
		this.supAddress = supAddress;
	}

	public void setSupPhone(String supPhone) {
		this.supPhone = supPhone;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	
//===================================================================	
	
}